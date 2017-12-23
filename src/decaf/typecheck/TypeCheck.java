package decaf.typecheck;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import decaf.Driver;
import decaf.Location;
import decaf.tree.Tree;
import decaf.tree.Tree.Expr;
import decaf.error.BadArgCountError;
import decaf.error.BadArgTypeError;
import decaf.error.BadArrElementError;
import decaf.error.BadLengthArgError;
import decaf.error.BadLengthError;
import decaf.error.BadNewArrayLength;
import decaf.error.BadPrintArgError;
import decaf.error.BadPrintCompArgError;
import decaf.error.BadReturnTypeError;
import decaf.error.BadTestExpr;
import decaf.error.BreakOutOfLoopError;
import decaf.error.CaseConditionNotIntError;
import decaf.error.CaseConditionRepeatError;
import decaf.error.CaseExprDiffError;
import decaf.error.ClassNotFoundError;
import decaf.error.CopyClassDiffError;
import decaf.error.CopyNotClassError;
import decaf.error.DecafError;
import decaf.error.DoExprNotBoolError;
import decaf.error.FieldNotAccessError;
import decaf.error.FieldNotFoundError;
import decaf.error.IncompatBinOpError;
import decaf.error.IncompatUnOpError;
import decaf.error.NotArrayError;
import decaf.error.NotClassError;
import decaf.error.NotClassFieldError;
import decaf.error.NotClassMethodError;
import decaf.error.RefNonStaticError;
import decaf.error.SubNotIntError;
import decaf.error.SuperInStaticFuncError;
import decaf.error.SuperLValueError;
import decaf.error.SuperNonParentError;
import decaf.error.ThisInStaticFuncError;
import decaf.error.UndeclVarError;
import decaf.frontend.Parser;
import decaf.scope.ClassScope;
import decaf.scope.FormalScope;
import decaf.scope.Scope;
import decaf.scope.ScopeStack;
import decaf.scope.Scope.Kind;
import decaf.symbol.Class;
import decaf.symbol.Function;
import decaf.symbol.Symbol;
import decaf.symbol.Variable;
import decaf.type.*;

public class TypeCheck extends Tree.Visitor {

	private ScopeStack table;

	private Stack<Tree> breaks;

	private Function currentFunction;

	public TypeCheck(ScopeStack table) {
		this.table = table;
		breaks = new Stack<Tree>();
	}

	public static void checkType(Tree.TopLevel tree) {
		new TypeCheck(Driver.getDriver().getTable()).visitTopLevel(tree);
	}

	@Override
	public void visitBinary(Tree.Binary expr) {		
		expr.left.accept(this);
		expr.right.accept(this);
		if(expr.left.type.equal(BaseType.COMPLEX) || expr.right.type.equal(BaseType.COMPLEX))
		{
			if(expr.left.type.equal(BaseType.INT)) 
			{
				expr.left = new Tree.Unary(Tree.TRANSINT, expr.left, expr.left.loc) ;
				expr.left.type = BaseType.COMPLEX ;
			}
			if(expr.right.type.equal(BaseType.INT)) 			
			{
				expr.right = new Tree.Unary(Tree.TRANSINT, expr.right, expr.right.loc) ;
				expr.right.type = BaseType.COMPLEX ;
			}
		}
		expr.type = checkBinaryOp(expr.left, expr.right, expr.tag, expr.loc);
	}

	@Override
	public void visitUnary(Tree.Unary expr) {
		expr.expr.accept(this);
		if(expr.expr.type.equal(BaseType.ERROR))
		{
			expr.type = BaseType.ERROR ;
			return ;
		}
		if(expr.tag == Tree.NEG){
			if (expr.expr.type.equal(BaseType.ERROR)
					|| expr.expr.type.equal(BaseType.INT) || expr.expr.type.equal(BaseType.COMPLEX)) {
				expr.type = expr.expr.type;
			} else {
				issueError(new IncompatUnOpError(expr.getLocation(), "-",
						expr.expr.type.toString()));
				expr.type = BaseType.ERROR;
			}
		}
		else if(expr.tag == Tree.NOT){
			if (!(expr.expr.type.equal(BaseType.BOOL) || expr.expr.type
					.equal(BaseType.ERROR))) {
				issueError(new IncompatUnOpError(expr.getLocation(), "!",
						expr.expr.type.toString()));
			}
			expr.type = BaseType.BOOL;
		}
		else if(expr.tag == Tree.RELPART) {			
			if (expr.expr.type.equal(BaseType.ERROR)
					|| expr.expr.type.equal(BaseType.COMPLEX)) {
				expr.type = BaseType.INT;
			} else {
				issueError(new IncompatUnOpError(expr.getLocation(), "@",
						expr.expr.type.toString()));
				expr.type = BaseType.ERROR;
			}
		}
		else if(expr.tag == Tree.IMGPART) {			
			if (expr.expr.type.equal(BaseType.ERROR)
					|| expr.expr.type.equal(BaseType.COMPLEX)) {
				expr.type =  BaseType.INT;
			} else {
				issueError(new IncompatUnOpError(expr.getLocation(), "$",
						expr.expr.type.toString()));
				expr.type = BaseType.ERROR;
			}
		}
		else if(expr.tag == Tree.TRANSINT) {			
			if (expr.expr.type.equal(BaseType.ERROR)
				|| expr.expr.type.equal(BaseType.INT)) {
				expr.type =  BaseType.COMPLEX;
			} else {
			issueError(new IncompatUnOpError(expr.getLocation(), "#",
					expr.expr.type.toString()));
			expr.type = BaseType.ERROR;
		}
		}
		
	}

	@Override
	public void visitLiteral(Tree.Literal literal) {
		switch (literal.typeTag) {
		case Tree.INT:
			literal.type = BaseType.INT;
			break;
		case Tree.BOOL:
			literal.type = BaseType.BOOL;
			break;
		case Tree.STRING:
			literal.type = BaseType.STRING;
			break;		
		case Tree.COMPLEX:
			literal.type = BaseType.COMPLEX;
			break;
		}
	}

	@Override
	public void visitNull(Tree.Null nullExpr) {
		nullExpr.type = BaseType.NULL;
	}

	@Override
	public void visitReadIntExpr(Tree.ReadIntExpr readIntExpr) {
		readIntExpr.type = BaseType.INT;
	}

	@Override
	public void visitReadLineExpr(Tree.ReadLineExpr readStringExpr) {
		readStringExpr.type = BaseType.STRING;
	}

	@Override
	public void visitIndexed(Tree.Indexed indexed) {
		indexed.lvKind = Tree.LValue.Kind.ARRAY_ELEMENT;
		indexed.array.accept(this);
		if (!indexed.array.type.isArrayType()) {
			issueError(new NotArrayError(indexed.array.getLocation()));
			indexed.type = BaseType.ERROR;
		} else {
			indexed.type = ((ArrayType) indexed.array.type)
					.getElementType();
		}
		indexed.index.accept(this);
		if (!indexed.index.type.equal(BaseType.INT)) {
			issueError(new SubNotIntError(indexed.getLocation()));
		}
	}

	private void checkCallExpr(Tree.CallExpr callExpr, Symbol f) {
		Type receiverType = callExpr.receiver == null ? ((ClassScope) table
				.lookForScope(Scope.Kind.CLASS)).getOwner().getType()
				: callExpr.receiver.type;
		if (f == null) {
			issueError(new FieldNotFoundError(callExpr.getLocation(),
					callExpr.method, receiverType.toString()));
			callExpr.type = BaseType.ERROR;
		} else if (!f.isFunction()) {
			issueError(new NotClassMethodError(callExpr.getLocation(),
					callExpr.method, receiverType.toString()));
			callExpr.type = BaseType.ERROR;
		} else {
			Function func = (Function) f;
			callExpr.symbol = func;
			callExpr.type = func.getReturnType();
			if (callExpr.receiver == null && currentFunction.isStatik()
					&& !func.isStatik()) {
				issueError(new RefNonStaticError(callExpr.getLocation(),
						currentFunction.getName(), func.getName()));
			}		
			if (!func.isStatik() && callExpr.receiver != null
					&& callExpr.receiver.isClass) {
				issueError(new NotClassFieldError(callExpr.getLocation(),
						callExpr.method, callExpr.receiver.type.toString()));
			}
			if (func.isStatik()) {
				callExpr.receiver = null;
			} else {
				if (callExpr.receiver == null && !currentFunction.isStatik()) {
					callExpr.receiver = new Tree.ThisExpr(callExpr.getLocation());
					callExpr.receiver.accept(this);
				}
			}
			for (Tree.Expr e : callExpr.actuals) {
				e.accept(this);
			}
			List<Type> argList = func.getType().getArgList();
			int argCount = func.isStatik() ? callExpr.actuals.size()
					: callExpr.actuals.size() + 1;
			if (argList.size() != argCount) {
				issueError(new BadArgCountError(callExpr.getLocation(),
						callExpr.method, func.isStatik() ? argList.size()
								: argList.size() - 1, callExpr.actuals.size()));
			} else {
				Iterator<Type> iter1 = argList.iterator();
				if (!func.isStatik()) {
					iter1.next();
				}
				Iterator<Tree.Expr> iter2 = callExpr.actuals.iterator();
				for (int i = 1; iter1.hasNext(); i++) {
					Type t1 = iter1.next();
					Tree.Expr e = iter2.next();
					Type t2 = e.type;
					if (!t2.equal(BaseType.ERROR) && !t2.compatible(t1)) {
						issueError(new BadArgTypeError(e.getLocation(), i, 
								t2.toString(), t1.toString()));
					}
				}
			}
		}
	}

	@Override
	public void visitCallExpr(Tree.CallExpr callExpr) {
		if (callExpr.receiver == null) {
			ClassScope cs = (ClassScope) table.lookForScope(Kind.CLASS);
			checkCallExpr(callExpr, cs.lookupVisible(callExpr.method));
			return;
		}
		callExpr.receiver.usedForRef = true;
		callExpr.receiver.accept(this);
		if (callExpr.receiver.type.equal(BaseType.ERROR)) {
			callExpr.type = BaseType.ERROR;
			return;
		}
		if (callExpr.method.equals("length")) {
			if (callExpr.receiver.type.isArrayType()) {
				if (callExpr.actuals.size() > 0) {
					issueError(new BadLengthArgError(callExpr.getLocation(),
							callExpr.actuals.size()));
				}
				callExpr.type = BaseType.INT;
				callExpr.isArrayLength = true;
				return;
			} else if (!callExpr.receiver.type.isClassType()) {
				issueError(new BadLengthError(callExpr.getLocation()));
				callExpr.type = BaseType.ERROR;
				return;
			}
		}

		if (!callExpr.receiver.type.isClassType()) {
			issueError(new NotClassFieldError(callExpr.getLocation(),
					callExpr.method, callExpr.receiver.type.toString()));
			callExpr.type = BaseType.ERROR;
			return;
		}
		ClassScope cs = ((ClassType) callExpr.receiver.type)
				.getClassScope();
		Symbol f = null ;
		Type tempType = null ;
		if(callExpr.receiver != null) tempType = callExpr.receiver.type ;
		if(callExpr.receiver instanceof Tree.Super)
		{
			Class parent = ((Tree.Super)callExpr.receiver).thisclass.getParent() ;
			if(parent == null)
			{
				callExpr.type = BaseType.ERROR;
				issueError(new SuperNonParentError(callExpr.getLocation(),
						callExpr.receiver.type.toString()));
				return ;
			}
			for(; parent != null; parent = parent.getParent())
			{
				f = parent.getType().getClassScope().lookupVisible(callExpr.method) ;
				if(f != null || (parent.getParent() == null)) 
				{
					callExpr.receiver.type = parent.getType() ;
					break ;
				}
			}
		}
		else f = cs.lookupVisible(callExpr.method) ;
		checkCallExpr(callExpr, f);
		if(callExpr.receiver != null) callExpr.receiver.type = tempType ;
	}

	@Override
	public void visitExec(Tree.Exec exec){
		exec.expr.accept(this);
	}
	
	@Override
	public void visitNewArray(Tree.NewArray newArrayExpr) {
		newArrayExpr.elementType.accept(this);
		if (newArrayExpr.elementType.type.equal(BaseType.ERROR)) {
			newArrayExpr.type = BaseType.ERROR;
		} else if (newArrayExpr.elementType.type.equal(BaseType.VOID)) {
			issueError(new BadArrElementError(newArrayExpr.elementType
					.getLocation()));
			newArrayExpr.type = BaseType.ERROR;
		} else {
			newArrayExpr.type = new ArrayType(
					newArrayExpr.elementType.type);
		}
		newArrayExpr.length.accept(this);
		if (!newArrayExpr.length.type.equal(BaseType.ERROR)
				&& !newArrayExpr.length.type.equal(BaseType.INT)) {
			issueError(new BadNewArrayLength(newArrayExpr.length.getLocation()));
		}
	}

	@Override
	public void visitNewClass(Tree.NewClass newClass) {
		Class c = table.lookupClass(newClass.className);
		newClass.symbol = c;
		if (c == null) {
			issueError(new ClassNotFoundError(newClass.getLocation(),
					newClass.className));
			newClass.type = BaseType.ERROR;
		} else {
			newClass.type = c.getType();
		}
	}

	@Override
	public void visitThisExpr(Tree.ThisExpr thisExpr) {
		if (currentFunction.isStatik()) {
			issueError(new ThisInStaticFuncError(thisExpr.getLocation()));
			thisExpr.type = BaseType.ERROR;
		} else {
			thisExpr.type = ((ClassScope) table.lookForScope(Scope.Kind.CLASS))
					.getOwner().getType();
		}
	}
	@Override
	public void visitSuper(Tree.Super superExpr) {
		if (currentFunction.isStatik()) {
			issueError(new SuperInStaticFuncError(superExpr.getLocation()));
			superExpr.type = BaseType.ERROR;
		} 
		else 
		{
			superExpr.thisclass = ((ClassScope) table.lookForScope(Scope.Kind.CLASS)).getOwner() ;
			superExpr.type = superExpr.thisclass.getType();
		}
	}
	
	@Override
	public void visitTypeTest(Tree.TypeTest instanceofExpr) {
		instanceofExpr.instance.accept(this);
		if (!instanceofExpr.instance.type.isClassType()) {
			issueError(new NotClassError(instanceofExpr.instance.type
					.toString(), instanceofExpr.getLocation()));
		}
		Class c = table.lookupClass(instanceofExpr.className);
		instanceofExpr.symbol = c;
		instanceofExpr.type = BaseType.BOOL;
		if (c == null) {
			issueError(new ClassNotFoundError(instanceofExpr.getLocation(),
					instanceofExpr.className));
		}
	}

	@Override
	public void visitTypeCast(Tree.TypeCast cast) {
		cast.expr.accept(this);
		if (!cast.expr.type.isClassType()) {
			issueError(new NotClassError(cast.expr.type.toString(),
					cast.getLocation()));
		}
		Class c = table.lookupClass(cast.className);
		cast.symbol = c;
		if (c == null) {
			issueError(new ClassNotFoundError(cast.getLocation(),
					cast.className));
			cast.type = BaseType.ERROR;
		} else {
			cast.type = c.getType();
		}
	}

	@Override
	public void visitIdent(Tree.Ident ident) {
		if (ident.owner == null) {
			Symbol v = table.lookupBeforeLocation(ident.name, ident
					.getLocation());
			if (v == null) {
				issueError(new UndeclVarError(ident.getLocation(), ident.name));
				ident.type = BaseType.ERROR;
			} else if (v.isVariable()) {
				Variable var = (Variable) v;
				ident.type = var.getType();
				ident.symbol = var;
				if (var.isLocalVar()) {
					ident.lvKind = Tree.LValue.Kind.LOCAL_VAR;
				} else if (var.isParam()) {
					ident.lvKind = Tree.LValue.Kind.PARAM_VAR;
				} else {
					if (currentFunction.isStatik()) {
						issueError(new RefNonStaticError(ident.getLocation(),
								currentFunction.getName(), ident.name));
					} else {
						ident.owner = new Tree.ThisExpr(ident.getLocation());
						ident.owner.accept(this);
					}
					ident.lvKind = Tree.LValue.Kind.MEMBER_VAR;
				}
			} 
			else {
				ident.type = v.getType();
				if (v.isClass()) {
					if (ident.usedForRef) {
						ident.isClass = true;
					} else {
						issueError(new UndeclVarError(ident.getLocation(),
								ident.name));
						ident.type = BaseType.ERROR;
					}

				}
			}
		} else {
			ident.owner.usedForRef = true;
			ident.owner.accept(this);				
			if(ident.owner instanceof Tree.Super && !ident.owner.type.equal(BaseType.ERROR))
			{
				ident.type = BaseType.ERROR;
				issueError(new SuperLValueError(ident.getLocation()));
			}
			else if (!ident.owner.type.equal(BaseType.ERROR)) {
				if (ident.owner.isClass || !ident.owner.type.isClassType()) {
					issueError(new NotClassFieldError(ident.getLocation(),
							ident.name, ident.owner.type.toString()));
					ident.type = BaseType.ERROR;
				} else {
					ClassScope cs = ((ClassType) ident.owner.type)
							.getClassScope();
					Symbol v = cs.lookupVisible(ident.name);
					if (v == null) {
						issueError(new FieldNotFoundError(ident.getLocation(),
								ident.name, ident.owner.type.toString()));
						ident.type = BaseType.ERROR;
					} else if (v.isVariable()) {
						ClassType thisType = ((ClassScope) table
								.lookForScope(Scope.Kind.CLASS)).getOwner()
								.getType();
						ident.type = v.getType();
						if (!thisType.compatible(ident.owner.type)) {
							issueError(new FieldNotAccessError(ident
									.getLocation(), ident.name,
									ident.owner.type.toString()));
						} else {
							ident.symbol = (Variable) v;
							ident.lvKind = Tree.LValue.Kind.MEMBER_VAR;
						}
					} else {
						ident.type = v.getType();
					}
				}
			} else {
				ident.type = BaseType.ERROR;
			}
		}
	}

	@Override
	public void visitClassDef(Tree.ClassDef classDef) {
		table.open(classDef.symbol.getAssociatedScope());
		for (Tree f : classDef.fields) {
			f.accept(this);
		}
		table.close();
	}

	@Override
	public void visitMethodDef(Tree.MethodDef func) {
		this.currentFunction = func.symbol;
		table.open(func.symbol.getAssociatedScope());
		func.body.accept(this);
		table.close();
	}

	@Override
	public void visitTopLevel(Tree.TopLevel program) {
		table.open(program.globalScope);
		for (Tree.ClassDef cd : program.classes) {
			cd.accept(this);
		}
		table.close();
	}

	@Override
	public void visitBlock(Tree.Block block) {
		table.open(block.associatedScope);
		for (Tree s : block.block) {
			s.accept(this);
		}
		table.close();
	}

	@Override
	public void visitAssign(Tree.Assign assign) {
		assign.left.accept(this);
		assign.expr.accept(this);
		if (!assign.left.type.equal(BaseType.ERROR) && !assign.expr.type.equal(BaseType.ERROR))
			if((assign.expr instanceof Tree.DCopy || assign.expr instanceof Tree.SCopy) && !assign.left.type.equal(assign.expr.type))
				issueError(new CopyClassDiffError(assign.getLocation(),
					assign.expr.type.toString(), assign.left.type.toString()));
			else if(assign.left.type.isFuncType() || !assign.expr.type.compatible(assign.left.type)) 
				issueError(new IncompatBinOpError(assign.getLocation(),
					assign.left.type.toString(), "=", assign.expr.type
							.toString()));
	}

	@Override
	public void visitBreak(Tree.Break breakStmt) {
		if (breaks.empty()) {
			issueError(new BreakOutOfLoopError(breakStmt.getLocation()));
		}
	}

	@Override
	public void visitForLoop(Tree.ForLoop forLoop) {
		if (forLoop.init != null) {
			forLoop.init.accept(this);
		}
		checkTestExpr(forLoop.condition);
		if (forLoop.update != null) {
			forLoop.update.accept(this);
		}
		breaks.add(forLoop);
		if (forLoop.loopBody != null) {
			forLoop.loopBody.accept(this);
		}
		breaks.pop();
	}

	@Override
	public void visitIf(Tree.If ifStmt) {
		checkTestExpr(ifStmt.condition);
		if (ifStmt.trueBranch != null) {
			ifStmt.trueBranch.accept(this);
		}
		if (ifStmt.falseBranch != null) {
			ifStmt.falseBranch.accept(this);
		}
	}

	@Override
	public void visitPrint(Tree.Print printStmt) {
		int i = 0;
		for (Tree.Expr e : printStmt.exprs) {
			e.accept(this);
			i++;
			if (!e.type.equal(BaseType.ERROR) && !e.type.equal(BaseType.BOOL)
					&& !e.type.equal(BaseType.INT)
					&& !e.type.equal(BaseType.STRING)) {
				issueError(new BadPrintArgError(e.getLocation(), Integer
						.toString(i), e.type.toString()));
			}
		}
	}
	
	@Override
	public void visitPrintComp(Tree.PrintComp printCompStmt) {
		int i = 0;
		for (Tree.Expr e : printCompStmt.exprs) {
			e.accept(this);
			i++;
			if (!e.type.equal(BaseType.ERROR) && !e.type.equal(BaseType.COMPLEX)) {
				issueError(new BadPrintCompArgError(e.getLocation(), Integer
						.toString(i), e.type.toString()));
			}
		}
	}
	@Override
	public void visitReturn(Tree.Return returnStmt) {
		Type returnType = ((FormalScope) table
				.lookForScope(Scope.Kind.FORMAL)).getOwner().getReturnType();
		if (returnStmt.expr != null) {
			returnStmt.expr.accept(this);
		}
		if (returnType.equal(BaseType.VOID)) {
			if (returnStmt.expr != null) {
				issueError(new BadReturnTypeError(returnStmt.getLocation(),
						returnType.toString(), returnStmt.expr.type.toString()));
			}
		} else if (returnStmt.expr == null) {
			issueError(new BadReturnTypeError(returnStmt.getLocation(),
					returnType.toString(), "void"));
		} else if (!returnStmt.expr.type.equal(BaseType.ERROR)
				&& !returnStmt.expr.type.compatible(returnType)) {
			issueError(new BadReturnTypeError(returnStmt.getLocation(),
					returnType.toString(), returnStmt.expr.type.toString()));
		}
	}

	@Override
	public void visitWhileLoop(Tree.WhileLoop whileLoop) {
		checkTestExpr(whileLoop.condition);
		breaks.add(whileLoop);
		if (whileLoop.loopBody != null) {
			whileLoop.loopBody.accept(this);
		}
		breaks.pop();
	}

	// visiting types
	@Override
	public void visitTypeIdent(Tree.TypeIdent type) {
		switch (type.typeTag) {
		case Tree.VOID:
			type.type = BaseType.VOID;
			break;
		case Tree.INT:
			type.type = BaseType.INT;
			break;
		case Tree.BOOL:
			type.type = BaseType.BOOL;
			break;
		case Tree.COMPLEX:
			type.type = BaseType.COMPLEX;
			break;
		default:
			type.type = BaseType.STRING;
		}
	}

	@Override
	public void visitTypeClass(Tree.TypeClass typeClass) {
		Class c = table.lookupClass(typeClass.name);
		if (c == null) {
			issueError(new ClassNotFoundError(typeClass.getLocation(),
					typeClass.name));
			typeClass.type = BaseType.ERROR;
		} else {
			typeClass.type = c.getType();
		}
	}

	@Override
	public void visitTypeArray(Tree.TypeArray typeArray) {
		typeArray.elementType.accept(this);
		if (typeArray.elementType.type.equal(BaseType.ERROR)) {
			typeArray.type = BaseType.ERROR;
		} else if (typeArray.elementType.type.equal(BaseType.VOID)) {
			issueError(new BadArrElementError(typeArray.getLocation()));
			typeArray.type = BaseType.ERROR;
		} else {
			typeArray.type = new ArrayType(typeArray.elementType.type);
		}
	}
	
	@Override
    public void visitCaseDef(Tree.CaseDef caseDef) {
		if(caseDef.typeTag != Tree.DEFAULTCASE)
		{
			caseDef.caseValue.accept(this);
			if(caseDef.caseValue.type.equal(BaseType.ERROR))
			{
				caseDef.type = BaseType.ERROR ;
				return ;
			}
			if(!caseDef.caseValue.type.equal(BaseType.INT))
			{
				issueError(new CaseConditionNotIntError(caseDef.loc, caseDef.caseValue.type.toString())) ;
				caseDef.type = BaseType.ERROR ;
				return ;
			}
		}
		caseDef.expr.accept(this);
		caseDef.type = caseDef.expr.type ;
    }
	
	@Override
    public void visitSwitch(Tree.Switch switchStmt) {
    	for(Tree.CaseDef ncase : switchStmt.normalCaseExpr)
    		ncase.accept(this) ;
    	switchStmt.defaultCaseExpr.accept(this);
    	switchStmt.expr.accept(this);
    	Set<Object> conditions = new HashSet<Object>() ;
    	boolean legal = true ;
    	for(Tree.CaseDef ncase : switchStmt.normalCaseExpr)
    	{
    		if(ncase.type != BaseType.ERROR)
    			if(conditions.contains(ncase.caseValue.value))
    			{
    				issueError(new CaseConditionRepeatError(ncase.loc)) ;
    				legal = false ;
    			}
    			else if(!switchStmt.defaultCaseExpr.type.equal(BaseType.ERROR) && !ncase.type.equal(switchStmt.defaultCaseExpr.type))
    			{
    				issueError(new CaseExprDiffError(ncase.loc, ncase.type.toString(), switchStmt.defaultCaseExpr.type.toString())) ;
    				legal = false ;
    			}
    		conditions.add(ncase.caseValue.value) ;
    	}    	
    	if(switchStmt.expr.type.equal(BaseType.ERROR))
    		legal = false ;
    	else if(!switchStmt.expr.type.equal(BaseType.INT))
    	{
    		issueError(new CaseConditionNotIntError(switchStmt.expr.loc, switchStmt.expr.type.toString())) ;
    		legal = false ;
    	}
    	switchStmt.type = (legal ? switchStmt.defaultCaseExpr.type : BaseType.ERROR) ;
    }     
	
	@Override
    public void visitDCopy(Tree.DCopy dCopy) {
		dCopy.expr.accept(this);
		if(dCopy.expr.type == BaseType.ERROR)
			dCopy.type =  BaseType.ERROR ;
		else if(!dCopy.expr.type.isClassType())
		{
			dCopy.type = BaseType.ERROR ;
			issueError(new CopyNotClassError(dCopy.loc, dCopy.expr.type.toString())) ;
		}
		else dCopy.type = dCopy.expr.type ;
    }	
	@Override
    public void visitSCopy(Tree.SCopy sCopy) {
		sCopy.expr.accept(this);
		if(sCopy.expr.type == BaseType.ERROR)
			sCopy.type =  BaseType.ERROR ;
		else if(!sCopy.expr.type.isClassType())
		{
			sCopy.type = BaseType.ERROR ;
			issueError(new CopyNotClassError(sCopy.loc, sCopy.expr.type.toString())) ;
		}
		else sCopy.type = sCopy.expr.type ;
    }  	
	
	@Override
    public void visitDoStmt(Tree.DoStmt doStmt) {
		for(Tree.DoSubStmt subStmt : doStmt.subStmts)
		{
			subStmt.accept(this) ;
			if(subStmt.type == BaseType.ERROR)
				doStmt.type = BaseType.ERROR ;
		}
    }           
	@Override
    public void visitDoSubStmt(Tree.DoSubStmt doSubStmt) {
		doSubStmt.expr.accept(this);	
		if(!doSubStmt.expr.type.equal(BaseType.BOOL))
		{
			doSubStmt.type = BaseType.ERROR ;
			issueError(new DoExprNotBoolError(doSubStmt.loc, doSubStmt.expr.type.toString())) ;
			return ;
		}
		breaks.add(doSubStmt);
		doSubStmt.stmt.accept(this);
		breaks.pop();		
		if(doSubStmt.expr.type == BaseType.ERROR || doSubStmt.stmt.type == BaseType.ERROR)
		{
			doSubStmt.type = BaseType.ERROR ;
			return ;
		}
    }           
	
	private void issueError(DecafError error) {
		Driver.getDriver().issueError(error);
	}

	private Type checkBinaryOp(Tree.Expr left, Tree.Expr right, int op, Location location) {
		
		if (left.type.equal(BaseType.ERROR) || right.type.equal(BaseType.ERROR)) {
			return BaseType.ERROR ;
			/*switch (op) {
			case Tree.PLUS:
			case Tree.MINUS:
			case Tree.MUL:
			case Tree.DIV:
				return left.type;
			case Tree.MOD:
				return BaseType.INT;
			default:
				return BaseType.BOOL;
			}*/
		}

		boolean compatible = false;
		Type returnType = BaseType.ERROR;
		switch (op) {
		case Tree.PLUS:
		case Tree.MUL:
			compatible = (left.type.equals(BaseType.INT) || left.type.equals(BaseType.COMPLEX))
			&& left.type.equal(right.type);
			returnType = left.type;
			break;
		case Tree.MINUS:
		case Tree.DIV:
			compatible = left.type.equals(BaseType.INT)
					&& left.type.equal(right.type);
			returnType = left.type;
			break;
		case Tree.GT:
		case Tree.GE:
		case Tree.LT:
		case Tree.LE:
			compatible = left.type.equal(BaseType.INT)
					&& left.type.equal(right.type);
			returnType = BaseType.BOOL;
			break;
		case Tree.MOD:
			compatible = left.type.equal(BaseType.INT)
					&& right.type.equal(BaseType.INT);
			returnType = BaseType.INT;
			break;
		case Tree.EQ:
		case Tree.NE:
			compatible = left.type.compatible(right.type)
					|| right.type.compatible(left.type);
			returnType = BaseType.BOOL;
			break;
		case Tree.AND:
		case Tree.OR:
			compatible = left.type.equal(BaseType.BOOL)
					&& right.type.equal(BaseType.BOOL);
			returnType = BaseType.BOOL;
			break;
		default:
			break;
		}

		if (!compatible) {
			issueError(new IncompatBinOpError(location, left.type.toString(),
					Parser.opStr(op), right.type.toString()));
			returnType = BaseType.ERROR;
		}
		return returnType;
	}

	private void checkTestExpr(Tree.Expr expr) {
		expr.accept(this);
		if (!expr.type.equal(BaseType.ERROR) && !expr.type.equal(BaseType.BOOL)) {
			issueError(new BadTestExpr(expr.getLocation()));
		}
	}

}
