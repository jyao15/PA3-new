//### This file created by BYACC 1.8(/Java extension  1.13)
//### Java capabilities added 7 Jan 97, Bob Jamison
//### Updated : 27 Nov 97  -- Bob Jamison, Joe Nieten
//###           01 Jan 98  -- Bob Jamison -- fixed generic semantic constructor
//###           01 Jun 99  -- Bob Jamison -- added Runnable support
//###           06 Aug 00  -- Bob Jamison -- made state variables class-global
//###           03 Jan 01  -- Bob Jamison -- improved flags, tracing
//###           16 May 01  -- Bob Jamison -- added custom stack sizing
//###           04 Mar 02  -- Yuval Oren  -- improved java performance, added options
//###           14 Mar 02  -- Tomas Hurka -- -d support, static initializer workaround
//###           14 Sep 06  -- Keltin Leung-- ReduceListener support, eliminate underflow report in error recovery
//### Please send bug reports to tom@hukatronic.cz
//### static char yysccsid[] = "@(#)yaccpar	1.8 (Berkeley) 01/20/90";






//#line 11 "Parser.y"
package decaf.frontend;

import decaf.tree.Tree;
import decaf.tree.Tree.*;
import decaf.error.*;
import java.util.*;
//#line 25 "Parser.java"
interface ReduceListener {
  public boolean onReduce(String rule);
}




public class Parser
             extends BaseParser
             implements ReduceListener
{

boolean yydebug;        //do I want debug output?
int yynerrs;            //number of errors so far
int yyerrflag;          //was there an error?
int yychar;             //the current working character

ReduceListener reduceListener = null;
void yyclearin ()       {yychar = (-1);}
void yyerrok ()         {yyerrflag=0;}
void addReduceListener(ReduceListener l) {
  reduceListener = l;}


//########## MESSAGES ##########
//###############################################################
// method: debug
//###############################################################
void debug(String msg)
{
  if (yydebug)
    System.out.println(msg);
}

//########## STATE STACK ##########
final static int YYSTACKSIZE = 500;  //maximum stack size
int statestk[] = new int[YYSTACKSIZE]; //state stack
int stateptr;
int stateptrmax;                     //highest index of stackptr
int statemax;                        //state when highest index reached
//###############################################################
// methods: state stack push,pop,drop,peek
//###############################################################
final void state_push(int state)
{
  try {
		stateptr++;
		statestk[stateptr]=state;
	 }
	 catch (ArrayIndexOutOfBoundsException e) {
     int oldsize = statestk.length;
     int newsize = oldsize * 2;
     int[] newstack = new int[newsize];
     System.arraycopy(statestk,0,newstack,0,oldsize);
     statestk = newstack;
     statestk[stateptr]=state;
  }
}
final int state_pop()
{
  return statestk[stateptr--];
}
final void state_drop(int cnt)
{
  stateptr -= cnt; 
}
final int state_peek(int relative)
{
  return statestk[stateptr-relative];
}
//###############################################################
// method: init_stacks : allocate and prepare stacks
//###############################################################
final boolean init_stacks()
{
  stateptr = -1;
  val_init();
  return true;
}
//###############################################################
// method: dump_stacks : show n levels of the stacks
//###############################################################
void dump_stacks(int count)
{
int i;
  System.out.println("=index==state====value=     s:"+stateptr+"  v:"+valptr);
  for (i=0;i<count;i++)
    System.out.println(" "+i+"    "+statestk[i]+"      "+valstk[i]);
  System.out.println("======================");
}


//########## SEMANTIC VALUES ##########
//## **user defined:SemValue
String   yytext;//user variable to return contextual strings
SemValue yyval; //used to return semantic vals from action routines
SemValue yylval;//the 'lval' (result) I got from yylex()
SemValue valstk[] = new SemValue[YYSTACKSIZE];
int valptr;
//###############################################################
// methods: value stack push,pop,drop,peek.
//###############################################################
final void val_init()
{
  yyval=new SemValue();
  yylval=new SemValue();
  valptr=-1;
}
final void val_push(SemValue val)
{
  try {
    valptr++;
    valstk[valptr]=val;
  }
  catch (ArrayIndexOutOfBoundsException e) {
    int oldsize = valstk.length;
    int newsize = oldsize*2;
    SemValue[] newstack = new SemValue[newsize];
    System.arraycopy(valstk,0,newstack,0,oldsize);
    valstk = newstack;
    valstk[valptr]=val;
  }
}
final SemValue val_pop()
{
  return valstk[valptr--];
}
final void val_drop(int cnt)
{
  valptr -= cnt;
}
final SemValue val_peek(int relative)
{
  return valstk[valptr-relative];
}
//#### end semantic value section ####
public final static short VOID=257;
public final static short BOOL=258;
public final static short INT=259;
public final static short COMPLEX=260;
public final static short STRING=261;
public final static short CLASS=262;
public final static short NULL=263;
public final static short EXTENDS=264;
public final static short THIS=265;
public final static short WHILE=266;
public final static short FOR=267;
public final static short IF=268;
public final static short ELSE=269;
public final static short RETURN=270;
public final static short BREAK=271;
public final static short NEW=272;
public final static short PRINT=273;
public final static short PRINTCOMP=274;
public final static short READ_INTEGER=275;
public final static short READ_LINE=276;
public final static short CASE=277;
public final static short DEFAULT=278;
public final static short SUPER=279;
public final static short LITERAL=280;
public final static short DO=281;
public final static short OD=282;
public final static short DCOPY=283;
public final static short SCOPY=284;
public final static short SPLIT=285;
public final static short IDENTIFIER=286;
public final static short AND=287;
public final static short OR=288;
public final static short STATIC=289;
public final static short INSTANCEOF=290;
public final static short LESS_EQUAL=291;
public final static short GREATER_EQUAL=292;
public final static short EQUAL=293;
public final static short NOT_EQUAL=294;
public final static short UMINUS=295;
public final static short EMPTY=296;
public final static short YYERRCODE=256;
final static short yylhs[] = {                           -1,
    0,    1,    1,    3,    4,    5,    5,    5,    5,    5,
    5,    5,    2,    6,    6,    7,    7,    7,    9,    9,
   10,   10,    8,    8,   11,   12,   12,   13,   13,   13,
   13,   13,   13,   13,   13,   13,   13,   13,   14,   14,
   14,   26,   26,   23,   23,   25,   24,   24,   24,   24,
   24,   24,   24,   24,   24,   24,   24,   24,   24,   24,
   24,   24,   24,   24,   24,   24,   24,   24,   24,   24,
   24,   24,   24,   24,   24,   24,   24,   24,   24,   28,
   28,   31,   30,   29,   29,   27,   27,   32,   32,   16,
   17,   21,   15,   33,   33,   18,   18,   19,   20,   34,
   35,   35,   22,
};
final static short yylen[] = {                            2,
    1,    2,    1,    2,    2,    1,    1,    1,    1,    1,
    2,    3,    6,    2,    0,    2,    2,    0,    1,    0,
    3,    1,    7,    6,    3,    2,    0,    1,    2,    1,
    1,    1,    2,    2,    2,    2,    1,    2,    3,    1,
    0,    2,    0,    2,    4,    5,    1,    4,    4,    1,
    1,    8,    3,    3,    3,    3,    3,    3,    3,    3,
    3,    3,    3,    3,    3,    3,    2,    2,    2,    2,
    2,    3,    3,    1,    1,    4,    5,    6,    5,    1,
    1,    4,    4,    2,    0,    1,    0,    3,    1,    5,
    9,    1,    6,    2,    0,    2,    1,    4,    4,    3,
    3,    0,    4,
};
final static short yydefred[] = {                         0,
    0,    0,    0,    3,    0,    2,    0,    0,   14,   18,
    0,    7,    8,    6,    9,   10,    0,    0,   13,   16,
    0,    0,   17,   11,    0,    4,    0,    0,    0,    0,
   12,    0,   22,    0,    0,    0,    0,    5,    0,    0,
    0,   27,   24,   21,   23,    0,   81,   74,    0,    0,
    0,    0,   92,    0,    0,    0,    0,    0,    0,   75,
   80,  102,    0,    0,    0,    0,    0,    0,    0,    0,
    0,   25,   28,   37,   26,    0,   30,   31,   32,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   51,    0,
    0,    0,   47,    0,   50,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   29,   33,   34,   35,   36,   38,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   42,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,   72,   73,    0,    0,    0,    0,
    0,    0,    0,   66,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   76,    0,    0,   98,   99,    0,    0,
  103,  101,   48,   49,    0,    0,   45,    0,    0,   90,
    0,    0,   77,    0,   85,  100,    0,   79,   46,    0,
    0,   93,    0,   78,    0,   94,    0,    0,    0,   84,
    0,    0,    0,   52,   91,    0,    0,   83,   82,
};
final static short yydgoto[] = {                          2,
    3,    4,   73,   21,   34,    8,   11,   23,   35,   36,
   74,   46,   75,   76,   77,   78,   79,   80,   81,   82,
   83,   84,   93,   86,   95,   88,  188,   89,  203,  209,
  210,  143,  202,  149,  103,
};
final static short yysindex[] = {                      -246,
 -269,    0, -246,    0, -242,    0, -258,  -88,    0,    0,
  -98,    0,    0,    0,    0,    0, -243,  -48,    0,    0,
   -7,  -87,    0,    0,  -83,    0,   18,  -27,   27,  -48,
    0,  -48,    0,  -78,   33,   29,   40,    0,  -28,  -48,
  -28,    0,    0,    0,    0,    1,    0,    0,   53,   56,
   58,  308,    0, -130,   65,   66,   67,   69,   72,    0,
    0,    0,   73,   76,   77,  308,  308,  308,  308,  308,
   75,    0,    0,    0,    0,   23,    0,    0,    0,   59,
   60,   62,   63,   64,   79,  933,    0, -161,    0,  308,
  308,  308,    0,  933,    0,   98,   51,  308,  308,  102,
  103,  308,  308,  308,  308,  308,  -32,  -32,  -32,  -32,
  -32, -139,  499,    0,    0,    0,    0,    0,    0,  308,
  308,  308,  308,  308,  308,  308,  308,  308,  308,  308,
  308,  308,  308,    0,  308,  114,  558,   89,  569,  116,
  101,  933,  -12,  -11,    0,    0,  580,  636, -238,  610,
  734,  762,  128,    0,  933,  997,  971,  -22,  -22,  506,
  506,    3,    3,  -32,  -32,  -32,  -22,  -22,  773,  308,
   35,  308,   35,    0,  845,  308,    0,    0,   48,   35,
    0,    0,    0,    0, -114,  308,    0,  132,  130,    0,
  872,  -92,    0,  933,    0,    0,  135,    0,    0,  308,
   35,    0, -225,    0,  137,    0,  126,  129,   61,    0,
   35,  308,  308,    0,    0,  898,  909,    0,    0,
};
final static short yyrindex[] = {                         0,
    0,    0,  188,    0,   70,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  131,    0,    0,  148,
    0,  148,    0,    0,    0,  151,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  -50,    0,    0,    0,    0,
    0,  -41,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,  -91,  -91,  -91,  -91,  -91,
  -91,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  945,    0,  473,    0,    0,  -91,
  -50,  -91,    0,  156,    0,    0,    0,  -91,  -91,    0,
    0,  -91,  -91,  -91,  -91,  -91,  108,  138,  345,  375,
  399,    0,    0,    0,    0,    0,    0,    0,    0,  -91,
  -91,  -91,  -91,  -91,  -91,  -91,  -91,  -91,  -91,  -91,
  -91,  -91,  -91,    0,  -91,   42,    0,    0,    0,    0,
  -91,    7,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  -40,  796,   -2,  953, 1035,  906,
 1058,  161, 1027,  428,  437,  464, 1037, 1056,    0,  -31,
  -50,  -91,  -50,    0,    0,  -91,    0,    0,    0,  -50,
    0,    0,    0,    0,    0,  -91,    0,    0,  166,    0,
    0,  -33,    0,   19,    0,    0,    0,    0,    0,  -30,
  -50,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  -50,  -91,  -91,    0,    0,    0,    0,    0,    0,
};
final static short yygindex[] = {                         0,
    0,  213,  206,   32,   43,    0,    0,    0,  186,    0,
   37,    0,  354,  -86,    0,    0,    0,    0,    0,    0,
    0,    0,  533, 1285, 1034,    0,    0,   80,    0,    0,
    0,  -93,    0,    0,    0,
};
final static int YYTABLESIZE=1498;
static short yytable[];
static { yytable();}
static void yytable(){
yytable = new short[]{                         95,
   39,   95,   95,   28,  138,  144,   95,   28,   41,   87,
   41,   95,   28,  134,  131,    1,    5,   97,   39,  129,
  127,    7,  128,  134,  130,   95,   19,    9,  177,  178,
   95,  176,  176,   70,   10,   69,   67,   47,   65,  131,
   71,   65,   24,  181,  129,   66,  182,   89,  134,  130,
   89,   26,  207,   22,   61,   65,   65,   30,  135,   88,
   25,   33,   88,   33,   68,   31,   32,   70,  135,   69,
   67,   44,   40,   39,   71,   43,  189,   45,   44,   66,
   41,  114,   44,   44,   44,   44,   44,   44,   44,   95,
   65,   95,   90,  135,   42,   91,   97,   92,   68,   44,
   44,   44,   44,   44,   98,   99,  100,   70,  101,   69,
   67,  102,  104,  205,   71,  105,  106,  115,  116,   66,
  117,  118,  119,   42,  136,   72,   12,   13,   14,   15,
   16,   17,   44,   70,   44,   69,   67,  140,   68,  120,
   71,  141,  145,  146,   67,   66,  153,  172,   67,   67,
   67,   67,   67,  170,   67,   96,  174,   42,   12,   13,
   14,   15,   16,   17,   68,   67,   67,   67,  186,   67,
  195,  197,  199,  176,   70,  204,  201,  211,   70,   70,
   70,   70,   70,  212,   70,  214,  213,    1,   20,    5,
   18,   19,   15,   31,   43,   70,   70,   70,   27,   70,
   67,   53,   29,   53,   53,   53,   86,   38,   12,   13,
   14,   15,   16,   17,   96,    6,   20,   37,   53,   53,
   53,    0,   53,   95,   95,   95,   95,   95,   95,   95,
   70,   95,   95,   95,   95,   43,   95,   95,   95,   95,
   95,   95,   95,   95,   43,   95,   95,   95,   95,   95,
   95,   95,   95,   53,   43,   43,   95,   12,   13,   14,
   15,   16,   17,   47,    0,   48,   49,   50,   51,    0,
   52,   53,   54,   55,   56,   57,   58,   59,    0,   60,
   61,   62,  208,   63,   64,   65,    0,    0,    0,    0,
   65,   12,   13,   14,   15,   16,   17,   47,    0,   48,
   49,   50,   51,    0,   52,   53,   54,   55,   56,   57,
   58,   59,    0,   60,   61,   62,    0,   63,   64,    0,
    0,    0,    0,    0,   65,    0,    0,    0,   44,   44,
    0,    0,   44,   44,   44,   44,  112,   47,    0,   48,
   70,    0,   69,   67,    0,    0,   54,   71,    0,   57,
   58,   59,   66,   60,   61,    0,    0,   63,   64,    0,
    0,    0,    0,   47,   65,   48,    0,    0,    0,    0,
    0,   68,   54,    0,    0,   57,   58,   59,    0,   60,
   61,   69,    0,   63,   64,   69,   69,   69,   69,   69,
   65,   69,    0,    0,   67,   67,    0,    0,   67,   67,
   67,   67,   69,   69,   69,    0,   69,    0,    0,    0,
    0,   71,    0,    0,    0,   71,   71,   71,   71,   71,
    0,   71,    0,    0,   70,   70,    0,    0,   70,   70,
   70,   70,   71,   71,   71,   68,   71,   69,    0,   68,
   68,   68,   68,   68,    0,   68,    0,   53,   53,    0,
    0,   53,   53,   53,   53,    0,   68,   68,   68,    0,
   68,    0,    0,    0,   55,    0,    0,   71,   55,   55,
   55,   55,   55,   56,   55,    0,    0,   56,   56,   56,
   56,   56,    0,   56,    0,   55,   55,   55,    0,   55,
    0,   68,    0,    0,   56,   56,   56,    0,   56,    0,
   57,    0,    0,    0,   57,   57,   57,   57,   57,   50,
   57,    0,    0,   40,   50,   50,    0,   50,   50,   50,
   55,   57,   57,   57,  190,   57,  192,    0,    0,   56,
    0,   40,   50,  196,   50,  131,    0,    0,    0,  154,
  129,  127,  131,  128,  134,  130,    0,  129,  127,    0,
  128,  134,  130,    0,  206,    0,   57,    0,  133,    0,
  132,    0,    0,   50,  215,  133,    0,  132,    0,    0,
   47,    0,   48,    0,    0,    0,    0,    0,   85,   54,
    0,    0,   57,   58,   59,    0,   60,   61,    0,  135,
   63,   64,    0,    0,  131,    0,  135,   65,  171,  129,
  127,    0,  128,  134,  130,  131,    0,    0,    0,  173,
  129,  127,    0,  128,  134,  130,  131,  133,    0,  132,
  179,  129,  127,   85,  128,  134,  130,    0,  133,    0,
  132,   69,   69,    0,    0,   69,   69,   69,   69,  133,
    0,  132,    0,    0,    0,    0,  131,    0,  135,    0,
  183,  129,  127,    0,  128,  134,  130,    0,    0,  135,
    0,   71,   71,    0,    0,   71,   71,   71,   71,  133,
  135,  132,  131,    0,    0,    0,    0,  129,  127,    0,
  128,  134,  130,    0,    0,   68,   68,    0,    0,   68,
   68,   68,   68,  180,    0,  133,    0,  132,    0,    0,
  135,    0,    0,   85,    0,   85,    0,    0,    0,    0,
    0,    0,   85,    0,   55,   55,    0,    0,   55,   55,
   55,   55,    0,   56,   56,    0,  135,   56,   56,   56,
   56,    0,   85,   85,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   85,    0,    0,    0,    0,    0,    0,
   57,   57,    0,    0,   57,   57,   57,   57,    0,   50,
   50,    0,    0,   50,   50,   50,   50,    0,    0,    0,
  131,    0,    0,    0,  184,  129,  127,    0,  128,  134,
  130,    0,    0,    0,    0,  121,  122,    0,    0,  123,
  124,  125,  126,  133,    0,  132,  123,  124,  131,    0,
    0,    0,    0,  129,  127,  185,  128,  134,  130,  131,
    0,    0,    0,    0,  129,  127,    0,  128,  134,  130,
    0,  133,    0,  132,  135,    0,    0,    0,    0,    0,
    0,    0,  133,    0,  132,    0,   64,    0,    0,   64,
    0,    0,    0,    0,  121,  122,    0,    0,  123,  124,
  125,  126,  135,   64,   64,  121,  122,    0,    0,  123,
  124,  125,  126,  135,    0,  187,  121,  122,    0,    0,
  123,  124,  125,  126,    0,    0,    0,    0,    0,    0,
    0,  131,    0,    0,    0,    0,  129,  127,   64,  128,
  134,  130,    0,    0,    0,    0,  121,  122,    0,    0,
  123,  124,  125,  126,  133,    0,  132,    0,  131,    0,
    0,    0,    0,  129,  127,    0,  128,  134,  130,    0,
    0,    0,  121,  122,    0,    0,  123,  124,  125,  126,
  200,  133,    0,  132,  131,  135,    0,  193,    0,  129,
  127,    0,  128,  134,  130,  131,   58,    0,    0,   58,
  129,  127,    0,  128,  134,  130,  218,  133,    0,  132,
    0,    0,  135,   58,   58,    0,    0,  219,  133,  131,
  132,    0,    0,    0,  129,  127,    0,  128,  134,  130,
    0,   47,    0,    0,    0,    0,   47,   47,  135,   47,
   47,   47,  133,   62,  132,    0,   62,    0,   58,  135,
    0,    0,    0,    0,   47,    0,   47,  131,    0,    0,
   62,   62,  129,  127,    0,  128,  134,  130,    0,    0,
  121,  122,    0,  135,  123,  124,  125,  126,    0,    0,
  133,    0,  132,  131,    0,   47,    0,    0,  129,  127,
    0,  128,  134,  130,    0,   62,    0,    0,  121,  122,
    0,    0,  123,  124,  125,  126,  133,    0,  132,  121,
  122,  135,    0,  123,  124,  125,  126,   54,    0,   54,
   54,   54,    0,    0,    0,   63,    0,   61,   63,   87,
   61,    0,   64,   64,   54,   54,   54,  135,   54,    0,
    0,    0,   63,   63,   61,   61,   60,    0,   59,   60,
    0,   59,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   60,   60,   59,   59,    0,    0,   54,
    0,    0,    0,    0,   87,    0,    0,   63,    0,   61,
    0,  121,  122,    0,    0,  123,  124,  125,  126,    0,
    0,    0,    0,    0,    0,    0,    0,    0,   60,    0,
   59,    0,    0,    0,    0,    0,    0,    0,  121,  122,
    0,    0,  123,  124,  125,  126,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  121,  122,    0,    0,  123,  124,
  125,  126,   58,   58,    0,  121,  122,    0,    0,  123,
  124,  125,  126,    0,   87,    0,   87,    0,    0,    0,
    0,    0,    0,   87,    0,    0,    0,    0,    0,  121,
  122,    0,    0,  123,  124,  125,  126,    0,    0,    0,
    0,   47,   47,   87,   87,   47,   47,   47,   47,   62,
   62,    0,    0,    0,   87,   62,   62,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  121,    0,    0,
    0,  123,  124,  125,  126,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,  123,  124,  125,
  126,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,   54,   54,    0,    0,   54,   54,   54,
   54,   63,   63,   61,   61,    0,    0,   63,   63,   61,
   61,    0,    0,    0,    0,    0,   94,    0,    0,    0,
    0,    0,   60,   60,   59,   59,    0,    0,   60,   60,
  107,  108,  109,  110,  111,  113,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  137,    0,  139,    0,    0,    0,
    0,    0,  142,  142,    0,    0,  147,  148,  150,  151,
  152,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  155,  156,  157,  158,  159,  160,
  161,  162,  163,  164,  165,  166,  167,  168,    0,  169,
    0,    0,    0,    0,    0,  175,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,  142,    0,  191,    0,    0,    0,
  194,    0,    0,    0,    0,    0,    0,    0,    0,    0,
  198,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
    0,    0,    0,    0,    0,    0,  216,  217,
};
}
static short yycheck[];
static { yycheck(); }
static void yycheck() {
yycheck = new short[] {                         33,
   41,   35,   36,   91,   91,   99,   40,   91,   59,   41,
   41,   45,   91,   46,   37,  262,  286,   59,   59,   42,
   43,  264,   45,   46,   47,   59,  125,  286,   41,   41,
   64,   44,   44,   33,  123,   35,   36,  263,   41,   37,
   40,   44,  286,  282,   42,   45,  285,   41,   46,   47,
   44,   59,  278,   11,  280,   58,   59,   40,   91,   41,
   18,   30,   44,   32,   64,   93,   40,   33,   91,   35,
   36,   40,   44,   41,   40,   39,  170,   41,   37,   45,
   41,   59,   41,   42,   43,   44,   45,   46,   47,  123,
   93,  125,   40,   91,  123,   40,   54,   40,   64,   58,
   59,   60,   61,   62,   40,   40,   40,   33,   40,   35,
   36,   40,   40,  200,   40,   40,   40,   59,   59,   45,
   59,   59,   59,  123,  286,  125,  257,  258,  259,  260,
  261,  262,   91,   33,   93,   35,   36,   40,   64,   61,
   40,   91,   41,   41,   37,   45,  286,   59,   41,   42,
   43,   44,   45,   40,   47,  286,   41,  123,  257,  258,
  259,  260,  261,  262,   64,   58,   59,   60,   41,   62,
  123,  286,   41,   44,   37,   41,  269,   41,   41,   42,
   43,   44,   45,   58,   47,  125,   58,    0,   41,   59,
  289,   41,  123,   93,  286,   58,   59,   60,  286,   62,
   93,   41,  286,   43,   44,   45,   41,  286,  257,  258,
  259,  260,  261,  262,   59,    3,   11,   32,   58,   59,
   60,   -1,   62,  257,  258,  259,  260,  261,  262,  263,
   93,  265,  266,  267,  268,  286,  270,  271,  272,  273,
  274,  275,  276,  277,  286,  279,  280,  281,  282,  283,
  284,  285,  286,   93,  286,  286,  290,  257,  258,  259,
  260,  261,  262,  263,   -1,  265,  266,  267,  268,   -1,
  270,  271,  272,  273,  274,  275,  276,  277,   -1,  279,
  280,  281,  203,  283,  284,  288,   -1,   -1,   -1,   -1,
  290,  257,  258,  259,  260,  261,  262,  263,   -1,  265,
  266,  267,  268,   -1,  270,  271,  272,  273,  274,  275,
  276,  277,   -1,  279,  280,  281,   -1,  283,  284,   -1,
   -1,   -1,   -1,   -1,  290,   -1,   -1,   -1,  287,  288,
   -1,   -1,  291,  292,  293,  294,  262,  263,   -1,  265,
   33,   -1,   35,   36,   -1,   -1,  272,   40,   -1,  275,
  276,  277,   45,  279,  280,   -1,   -1,  283,  284,   -1,
   -1,   -1,   -1,  263,  290,  265,   -1,   -1,   -1,   -1,
   -1,   64,  272,   -1,   -1,  275,  276,  277,   -1,  279,
  280,   37,   -1,  283,  284,   41,   42,   43,   44,   45,
  290,   47,   -1,   -1,  287,  288,   -1,   -1,  291,  292,
  293,  294,   58,   59,   60,   -1,   62,   -1,   -1,   -1,
   -1,   37,   -1,   -1,   -1,   41,   42,   43,   44,   45,
   -1,   47,   -1,   -1,  287,  288,   -1,   -1,  291,  292,
  293,  294,   58,   59,   60,   37,   62,   93,   -1,   41,
   42,   43,   44,   45,   -1,   47,   -1,  287,  288,   -1,
   -1,  291,  292,  293,  294,   -1,   58,   59,   60,   -1,
   62,   -1,   -1,   -1,   37,   -1,   -1,   93,   41,   42,
   43,   44,   45,   37,   47,   -1,   -1,   41,   42,   43,
   44,   45,   -1,   47,   -1,   58,   59,   60,   -1,   62,
   -1,   93,   -1,   -1,   58,   59,   60,   -1,   62,   -1,
   37,   -1,   -1,   -1,   41,   42,   43,   44,   45,   37,
   47,   -1,   -1,   41,   42,   43,   -1,   45,   46,   47,
   93,   58,   59,   60,  171,   62,  173,   -1,   -1,   93,
   -1,   59,   60,  180,   62,   37,   -1,   -1,   -1,   41,
   42,   43,   37,   45,   46,   47,   -1,   42,   43,   -1,
   45,   46,   47,   -1,  201,   -1,   93,   -1,   60,   -1,
   62,   -1,   -1,   91,  211,   60,   -1,   62,   -1,   -1,
  263,   -1,  265,   -1,   -1,   -1,   -1,   -1,   46,  272,
   -1,   -1,  275,  276,  277,   -1,  279,  280,   -1,   91,
  283,  284,   -1,   -1,   37,   -1,   91,  290,   41,   42,
   43,   -1,   45,   46,   47,   37,   -1,   -1,   -1,   41,
   42,   43,   -1,   45,   46,   47,   37,   60,   -1,   62,
   41,   42,   43,   91,   45,   46,   47,   -1,   60,   -1,
   62,  287,  288,   -1,   -1,  291,  292,  293,  294,   60,
   -1,   62,   -1,   -1,   -1,   -1,   37,   -1,   91,   -1,
   41,   42,   43,   -1,   45,   46,   47,   -1,   -1,   91,
   -1,  287,  288,   -1,   -1,  291,  292,  293,  294,   60,
   91,   62,   37,   -1,   -1,   -1,   -1,   42,   43,   -1,
   45,   46,   47,   -1,   -1,  287,  288,   -1,   -1,  291,
  292,  293,  294,   58,   -1,   60,   -1,   62,   -1,   -1,
   91,   -1,   -1,  171,   -1,  173,   -1,   -1,   -1,   -1,
   -1,   -1,  180,   -1,  287,  288,   -1,   -1,  291,  292,
  293,  294,   -1,  287,  288,   -1,   91,  291,  292,  293,
  294,   -1,  200,  201,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  211,   -1,   -1,   -1,   -1,   -1,   -1,
  287,  288,   -1,   -1,  291,  292,  293,  294,   -1,  287,
  288,   -1,   -1,  291,  292,  293,  294,   -1,   -1,   -1,
   37,   -1,   -1,   -1,   41,   42,   43,   -1,   45,   46,
   47,   -1,   -1,   -1,   -1,  287,  288,   -1,   -1,  291,
  292,  293,  294,   60,   -1,   62,  291,  292,   37,   -1,
   -1,   -1,   -1,   42,   43,   44,   45,   46,   47,   37,
   -1,   -1,   -1,   -1,   42,   43,   -1,   45,   46,   47,
   -1,   60,   -1,   62,   91,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   60,   -1,   62,   -1,   41,   -1,   -1,   44,
   -1,   -1,   -1,   -1,  287,  288,   -1,   -1,  291,  292,
  293,  294,   91,   58,   59,  287,  288,   -1,   -1,  291,
  292,  293,  294,   91,   -1,   93,  287,  288,   -1,   -1,
  291,  292,  293,  294,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   37,   -1,   -1,   -1,   -1,   42,   43,   93,   45,
   46,   47,   -1,   -1,   -1,   -1,  287,  288,   -1,   -1,
  291,  292,  293,  294,   60,   -1,   62,   -1,   37,   -1,
   -1,   -1,   -1,   42,   43,   -1,   45,   46,   47,   -1,
   -1,   -1,  287,  288,   -1,   -1,  291,  292,  293,  294,
   59,   60,   -1,   62,   37,   91,   -1,   93,   -1,   42,
   43,   -1,   45,   46,   47,   37,   41,   -1,   -1,   44,
   42,   43,   -1,   45,   46,   47,   59,   60,   -1,   62,
   -1,   -1,   91,   58,   59,   -1,   -1,   59,   60,   37,
   62,   -1,   -1,   -1,   42,   43,   -1,   45,   46,   47,
   -1,   37,   -1,   -1,   -1,   -1,   42,   43,   91,   45,
   46,   47,   60,   41,   62,   -1,   44,   -1,   93,   91,
   -1,   -1,   -1,   -1,   60,   -1,   62,   37,   -1,   -1,
   58,   59,   42,   43,   -1,   45,   46,   47,   -1,   -1,
  287,  288,   -1,   91,  291,  292,  293,  294,   -1,   -1,
   60,   -1,   62,   37,   -1,   91,   -1,   -1,   42,   43,
   -1,   45,   46,   47,   -1,   93,   -1,   -1,  287,  288,
   -1,   -1,  291,  292,  293,  294,   60,   -1,   62,  287,
  288,   91,   -1,  291,  292,  293,  294,   41,   -1,   43,
   44,   45,   -1,   -1,   -1,   41,   -1,   41,   44,   46,
   44,   -1,  287,  288,   58,   59,   60,   91,   62,   -1,
   -1,   -1,   58,   59,   58,   59,   41,   -1,   41,   44,
   -1,   44,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   58,   59,   58,   59,   -1,   -1,   93,
   -1,   -1,   -1,   -1,   91,   -1,   -1,   93,   -1,   93,
   -1,  287,  288,   -1,   -1,  291,  292,  293,  294,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   93,   -1,
   93,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  287,  288,
   -1,   -1,  291,  292,  293,  294,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  287,  288,   -1,   -1,  291,  292,
  293,  294,  287,  288,   -1,  287,  288,   -1,   -1,  291,
  292,  293,  294,   -1,  171,   -1,  173,   -1,   -1,   -1,
   -1,   -1,   -1,  180,   -1,   -1,   -1,   -1,   -1,  287,
  288,   -1,   -1,  291,  292,  293,  294,   -1,   -1,   -1,
   -1,  287,  288,  200,  201,  291,  292,  293,  294,  287,
  288,   -1,   -1,   -1,  211,  293,  294,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  287,   -1,   -1,
   -1,  291,  292,  293,  294,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,  291,  292,  293,
  294,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,  287,  288,   -1,   -1,  291,  292,  293,
  294,  287,  288,  287,  288,   -1,   -1,  293,  294,  293,
  294,   -1,   -1,   -1,   -1,   -1,   52,   -1,   -1,   -1,
   -1,   -1,  287,  288,  287,  288,   -1,   -1,  293,  294,
   66,   67,   68,   69,   70,   71,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   90,   -1,   92,   -1,   -1,   -1,
   -1,   -1,   98,   99,   -1,   -1,  102,  103,  104,  105,
  106,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  120,  121,  122,  123,  124,  125,
  126,  127,  128,  129,  130,  131,  132,  133,   -1,  135,
   -1,   -1,   -1,   -1,   -1,  141,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,  170,   -1,  172,   -1,   -1,   -1,
  176,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
  186,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,
   -1,   -1,   -1,   -1,   -1,   -1,  212,  213,
};
}
final static short YYFINAL=2;
final static short YYMAXTOKEN=296;
final static String yyname[] = {
"end-of-file",null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,"'!'",null,"'#'","'$'","'%'",null,null,"'('","')'","'*'","'+'",
"','","'-'","'.'","'/'",null,null,null,null,null,null,null,null,null,null,"':'",
"';'","'<'","'='","'>'",null,"'@'",null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,"'['",null,"']'",null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,"'{'",null,"'}'",null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,
null,null,null,null,null,null,null,null,null,"VOID","BOOL","INT","COMPLEX",
"STRING","CLASS","NULL","EXTENDS","THIS","WHILE","FOR","IF","ELSE","RETURN",
"BREAK","NEW","PRINT","PRINTCOMP","READ_INTEGER","READ_LINE","CASE","DEFAULT",
"SUPER","LITERAL","DO","OD","DCOPY","SCOPY","SPLIT","IDENTIFIER","AND","OR",
"STATIC","INSTANCEOF","LESS_EQUAL","GREATER_EQUAL","EQUAL","NOT_EQUAL","UMINUS",
"EMPTY",
};
final static String yyrule[] = {
"$accept : Program",
"Program : ClassList",
"ClassList : ClassList ClassDef",
"ClassList : ClassDef",
"VariableDef : Variable ';'",
"Variable : Type IDENTIFIER",
"Type : INT",
"Type : VOID",
"Type : BOOL",
"Type : COMPLEX",
"Type : STRING",
"Type : CLASS IDENTIFIER",
"Type : Type '[' ']'",
"ClassDef : CLASS IDENTIFIER ExtendsClause '{' FieldList '}'",
"ExtendsClause : EXTENDS IDENTIFIER",
"ExtendsClause :",
"FieldList : FieldList VariableDef",
"FieldList : FieldList FunctionDef",
"FieldList :",
"Formals : VariableList",
"Formals :",
"VariableList : VariableList ',' Variable",
"VariableList : Variable",
"FunctionDef : STATIC Type IDENTIFIER '(' Formals ')' StmtBlock",
"FunctionDef : Type IDENTIFIER '(' Formals ')' StmtBlock",
"StmtBlock : '{' StmtList '}'",
"StmtList : StmtList Stmt",
"StmtList :",
"Stmt : VariableDef",
"Stmt : SimpleStmt ';'",
"Stmt : IfStmt",
"Stmt : WhileStmt",
"Stmt : ForStmt",
"Stmt : ReturnStmt ';'",
"Stmt : PrintStmt ';'",
"Stmt : PrintCompStmt ';'",
"Stmt : BreakStmt ';'",
"Stmt : StmtBlock",
"Stmt : DoStmt ';'",
"SimpleStmt : LValue '=' Expr",
"SimpleStmt : Call",
"SimpleStmt :",
"Receiver : Expr '.'",
"Receiver :",
"LValue : Receiver IDENTIFIER",
"LValue : Expr '[' Expr ']'",
"Call : Receiver IDENTIFIER '(' Actuals ')'",
"Expr : LValue",
"Expr : DCOPY '(' Expr ')'",
"Expr : SCOPY '(' Expr ')'",
"Expr : Call",
"Expr : Constant",
"Expr : CASE '(' Expr ')' '{' ACaseExorList DefaultExpr '}'",
"Expr : Expr '+' Expr",
"Expr : Expr '-' Expr",
"Expr : Expr '*' Expr",
"Expr : Expr '/' Expr",
"Expr : Expr '%' Expr",
"Expr : Expr EQUAL Expr",
"Expr : Expr NOT_EQUAL Expr",
"Expr : Expr '<' Expr",
"Expr : Expr '>' Expr",
"Expr : Expr LESS_EQUAL Expr",
"Expr : Expr GREATER_EQUAL Expr",
"Expr : Expr AND Expr",
"Expr : Expr OR Expr",
"Expr : '(' Expr ')'",
"Expr : '-' Expr",
"Expr : '!' Expr",
"Expr : '@' Expr",
"Expr : '$' Expr",
"Expr : '#' Expr",
"Expr : READ_INTEGER '(' ')'",
"Expr : READ_LINE '(' ')'",
"Expr : THIS",
"Expr : SUPER",
"Expr : NEW IDENTIFIER '(' ')'",
"Expr : NEW Type '[' Expr ']'",
"Expr : INSTANCEOF '(' Expr ',' IDENTIFIER ')'",
"Expr : '(' CLASS IDENTIFIER ')' Expr",
"Constant : LITERAL",
"Constant : NULL",
"ACaseExor : Constant ':' Expr ';'",
"DefaultExpr : DEFAULT ':' Expr ';'",
"ACaseExorList : ACaseExorList ACaseExor",
"ACaseExorList :",
"Actuals : ExprList",
"Actuals :",
"ExprList : ExprList ',' Expr",
"ExprList : Expr",
"WhileStmt : WHILE '(' Expr ')' Stmt",
"ForStmt : FOR '(' SimpleStmt ';' Expr ';' SimpleStmt ')' Stmt",
"BreakStmt : BREAK",
"IfStmt : IF '(' Expr ')' Stmt ElseClause",
"ElseClause : ELSE Stmt",
"ElseClause :",
"ReturnStmt : RETURN Expr",
"ReturnStmt : RETURN",
"PrintStmt : PRINT '(' ExprList ')'",
"PrintCompStmt : PRINTCOMP '(' ExprList ')'",
"DoSubStmt : Expr ':' Stmt",
"DoBranch : DoBranch DoSubStmt SPLIT",
"DoBranch :",
"DoStmt : DO DoBranch DoSubStmt OD",
};

//#line 506 "Parser.y"
    
	/**
	 * 鎵撳嵃褰撳墠褰掔害鎵�鐢ㄧ殑璇硶瑙勫垯<br>
	 * 璇峰嬁淇敼銆�
	 */
    public boolean onReduce(String rule) {
		if (rule.startsWith("$$"))
			return false;
		else
			rule = rule.replaceAll(" \\$\\$\\d+", "");

   	    if (rule.endsWith(":"))
    	    System.out.println(rule + " <empty>");
   	    else
			System.out.println(rule);
		return false;
    }
    
    public void diagnose() {
		addReduceListener(this);
		yyparse();
	}
//#line 724 "Parser.java"
//###############################################################
// method: yylexdebug : check lexer state
//###############################################################
void yylexdebug(int state,int ch)
{
String s=null;
  if (ch < 0) ch=0;
  if (ch <= YYMAXTOKEN) //check index bounds
     s = yyname[ch];    //now get it
  if (s==null)
    s = "illegal-symbol";
  debug("state "+state+", reading "+ch+" ("+s+")");
}





//The following are now global, to aid in error reporting
int yyn;       //next next thing to do
int yym;       //
int yystate;   //current parsing state from state table
String yys;    //current token string


//###############################################################
// method: yyparse : parse input and execute indicated items
//###############################################################
int yyparse()
{
boolean doaction;
  init_stacks();
  yynerrs = 0;
  yyerrflag = 0;
  yychar = -1;          //impossible char forces a read
  yystate=0;            //initial state
  state_push(yystate);  //save it
  while (true) //until parsing is done, either correctly, or w/error
    {
    doaction=true;
    //if (yydebug) debug("loop"); 
    //#### NEXT ACTION (from reduction table)
    for (yyn=yydefred[yystate];yyn==0;yyn=yydefred[yystate])
      {
      //if (yydebug) debug("yyn:"+yyn+"  state:"+yystate+"  yychar:"+yychar);
      if (yychar < 0)      //we want a char?
        {
        yychar = yylex();  //get next token
        //if (yydebug) debug(" next yychar:"+yychar);
        //#### ERROR CHECK ####
        //if (yychar < 0)    //it it didn't work/error
        //  {
        //  yychar = 0;      //change it to default string (no -1!)
          //if (yydebug)
          //  yylexdebug(yystate,yychar);
        //  }
        }//yychar<0
      yyn = yysindex[yystate];  //get amount to shift by (shift index)
      if ((yyn != 0) && (yyn += yychar) >= 0 &&
          yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
        {
        //if (yydebug)
          //debug("state "+yystate+", shifting to state "+yytable[yyn]);
        //#### NEXT STATE ####
        yystate = yytable[yyn];//we are in a new state
        state_push(yystate);   //save it
        val_push(yylval);      //push our lval as the input for next rule
        yychar = -1;           //since we have 'eaten' a token, say we need another
        if (yyerrflag > 0)     //have we recovered an error?
           --yyerrflag;        //give ourselves credit
        doaction=false;        //but don't process yet
        break;   //quit the yyn=0 loop
        }

    yyn = yyrindex[yystate];  //reduce
    if ((yyn !=0 ) && (yyn += yychar) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yychar)
      {   //we reduced!
      //if (yydebug) debug("reduce");
      yyn = yytable[yyn];
      doaction=true; //get ready to execute
      break;         //drop down to actions
      }
    else //ERROR RECOVERY
      {
      if (yyerrflag==0)
        {
        yyerror("syntax error");
        yynerrs++;
        }
      if (yyerrflag < 3) //low error count?
        {
        yyerrflag = 3;
        while (true)   //do until break
          {
          if (stateptr<0 || valptr<0)   //check for under & overflow here
            {
            return 1;
            }
          yyn = yysindex[state_peek(0)];
          if ((yyn != 0) && (yyn += YYERRCODE) >= 0 &&
                    yyn <= YYTABLESIZE && yycheck[yyn] == YYERRCODE)
            {
            //if (yydebug)
              //debug("state "+state_peek(0)+", error recovery shifting to state "+yytable[yyn]+" ");
            yystate = yytable[yyn];
            state_push(yystate);
            val_push(yylval);
            doaction=false;
            break;
            }
          else
            {
            //if (yydebug)
              //debug("error recovery discarding state "+state_peek(0)+" ");
            if (stateptr<0 || valptr<0)   //check for under & overflow here
              {
              return 1;
              }
            state_pop();
            val_pop();
            }
          }
        }
      else            //discard this token
        {
        if (yychar == 0)
          return 1; //yyabort
        //if (yydebug)
          //{
          //yys = null;
          //if (yychar <= YYMAXTOKEN) yys = yyname[yychar];
          //if (yys == null) yys = "illegal-symbol";
          //debug("state "+yystate+", error recovery discards token "+yychar+" ("+yys+")");
          //}
        yychar = -1;  //read another
        }
      }//end error recovery
    }//yyn=0 loop
    if (!doaction)   //any reason not to proceed?
      continue;      //skip action
    yym = yylen[yyn];          //get count of terminals on rhs
    //if (yydebug)
      //debug("state "+yystate+", reducing "+yym+" by rule "+yyn+" ("+yyrule[yyn]+")");
    if (yym>0)                 //if count of rhs not 'nil'
      yyval = val_peek(yym-1); //get current semantic value
    if (reduceListener == null || reduceListener.onReduce(yyrule[yyn])) // if intercepted!
      switch(yyn)
      {
//########## USER-SUPPLIED ACTIONS ##########
case 1:
//#line 54 "Parser.y"
{
						tree = new Tree.TopLevel(val_peek(0).clist, val_peek(0).loc);
					}
break;
case 2:
//#line 60 "Parser.y"
{
						yyval.clist.add(val_peek(0).cdef);
					}
break;
case 3:
//#line 64 "Parser.y"
{
                		yyval.clist = new ArrayList<Tree.ClassDef>();
                		yyval.clist.add(val_peek(0).cdef);
                	}
break;
case 5:
//#line 74 "Parser.y"
{
						yyval.vdef = new Tree.VarDef(val_peek(0).ident, val_peek(1).type, val_peek(0).loc);
					}
break;
case 6:
//#line 80 "Parser.y"
{
						yyval.type = new Tree.TypeIdent(Tree.INT, val_peek(0).loc);
					}
break;
case 7:
//#line 84 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.VOID, val_peek(0).loc);
                	}
break;
case 8:
//#line 88 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.BOOL, val_peek(0).loc);
                	}
break;
case 9:
//#line 92 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.COMPLEX, val_peek(0).loc);
                	}
break;
case 10:
//#line 96 "Parser.y"
{
                		yyval.type = new Tree.TypeIdent(Tree.STRING, val_peek(0).loc);
                	}
break;
case 11:
//#line 100 "Parser.y"
{
                		yyval.type = new Tree.TypeClass(val_peek(0).ident, val_peek(1).loc);
                	}
break;
case 12:
//#line 104 "Parser.y"
{
                		yyval.type = new Tree.TypeArray(val_peek(2).type, val_peek(2).loc);
                	}
break;
case 13:
//#line 110 "Parser.y"
{
						yyval.cdef = new Tree.ClassDef(val_peek(4).ident, val_peek(3).ident, val_peek(1).flist, val_peek(5).loc);
					}
break;
case 14:
//#line 116 "Parser.y"
{
						yyval.ident = val_peek(0).ident;
					}
break;
case 15:
//#line 120 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 16:
//#line 126 "Parser.y"
{
						yyval.flist.add(val_peek(0).vdef);
					}
break;
case 17:
//#line 130 "Parser.y"
{
						yyval.flist.add(val_peek(0).fdef);
					}
break;
case 18:
//#line 134 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.flist = new ArrayList<Tree>();
                	}
break;
case 20:
//#line 142 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.vlist = new ArrayList<Tree.VarDef>(); 
                	}
break;
case 21:
//#line 149 "Parser.y"
{
						yyval.vlist.add(val_peek(0).vdef);
					}
break;
case 22:
//#line 153 "Parser.y"
{
                		yyval.vlist = new ArrayList<Tree.VarDef>();
						yyval.vlist.add(val_peek(0).vdef);
                	}
break;
case 23:
//#line 160 "Parser.y"
{
						yyval.fdef = new MethodDef(true, val_peek(4).ident, val_peek(5).type, val_peek(2).vlist, (Block) val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 24:
//#line 164 "Parser.y"
{
						yyval.fdef = new MethodDef(false, val_peek(4).ident, val_peek(5).type, val_peek(2).vlist, (Block) val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 25:
//#line 170 "Parser.y"
{
						yyval.stmt = new Block(val_peek(1).slist, val_peek(2).loc);
					}
break;
case 26:
//#line 176 "Parser.y"
{
						yyval.slist.add(val_peek(0).stmt);
					}
break;
case 27:
//#line 180 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.slist = new ArrayList<Tree>();
                	}
break;
case 28:
//#line 187 "Parser.y"
{
						yyval.stmt = val_peek(0).vdef;
					}
break;
case 29:
//#line 192 "Parser.y"
{
                		if (yyval.stmt == null) {
                			yyval.stmt = new Tree.Skip(val_peek(0).loc);
                		}
                	}
break;
case 39:
//#line 209 "Parser.y"
{
						yyval.stmt = new Tree.Assign(val_peek(2).lvalue, val_peek(0).expr, val_peek(1).loc);
					}
break;
case 40:
//#line 213 "Parser.y"
{
                		yyval.stmt = new Tree.Exec(val_peek(0).expr, val_peek(0).loc);
                	}
break;
case 41:
//#line 217 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 43:
//#line 224 "Parser.y"
{
                		yyval = new SemValue();
                	}
break;
case 44:
//#line 230 "Parser.y"
{
						yyval.lvalue = new Tree.Ident(val_peek(1).expr, val_peek(0).ident, val_peek(0).loc);
						if (val_peek(1).loc == null) {
							yyval.loc = val_peek(0).loc;
						}
					}
break;
case 45:
//#line 237 "Parser.y"
{
                		yyval.lvalue = new Tree.Indexed(val_peek(3).expr, val_peek(1).expr, val_peek(3).loc);
                	}
break;
case 46:
//#line 243 "Parser.y"
{
						yyval.expr = new Tree.CallExpr(val_peek(4).expr, val_peek(3).ident, val_peek(1).elist, val_peek(3).loc);
						if (val_peek(4).loc == null) {
							yyval.loc = val_peek(3).loc;
						}
					}
break;
case 47:
//#line 252 "Parser.y"
{
						yyval.expr = val_peek(0).lvalue;
					}
break;
case 48:
//#line 256 "Parser.y"
{
						yyval.expr = new Tree.DCopy(val_peek(1).expr, val_peek(3).loc);
					}
break;
case 49:
//#line 260 "Parser.y"
{
						yyval.expr = new Tree.SCopy(val_peek(1).expr, val_peek(3).loc);
					}
break;
case 52:
//#line 266 "Parser.y"
{
                		yyval.expr = new Tree.Switch(val_peek(5).expr, val_peek(2).caselist, val_peek(1).casedef, val_peek(7).loc);
                	}
break;
case 53:
//#line 270 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.PLUS, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 54:
//#line 274 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MINUS, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 55:
//#line 278 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MUL, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 56:
//#line 282 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.DIV, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 57:
//#line 286 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.MOD, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 58:
//#line 290 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.EQ, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 59:
//#line 294 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.NE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 60:
//#line 298 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.LT, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 61:
//#line 302 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.GT, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 62:
//#line 306 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.LE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 63:
//#line 310 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.GE, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 64:
//#line 314 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.AND, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 65:
//#line 318 "Parser.y"
{
                		yyval.expr = new Tree.Binary(Tree.OR, val_peek(2).expr, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 66:
//#line 322 "Parser.y"
{
                		yyval = val_peek(1);
                	}
break;
case 67:
//#line 326 "Parser.y"
{
                		yyval.expr = new Tree.Unary(Tree.NEG, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 68:
//#line 330 "Parser.y"
{
                		yyval.expr = new Tree.Unary(Tree.NOT, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 69:
//#line 334 "Parser.y"
{
                		yyval.expr = new Tree.Unary(Tree.RELPART, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 70:
//#line 338 "Parser.y"
{
                		yyval.expr = new Tree.Unary(Tree.IMGPART, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 71:
//#line 342 "Parser.y"
{
                		yyval.expr = new Tree.Unary(Tree.TRANSINT, val_peek(0).expr, val_peek(1).loc);
                	}
break;
case 72:
//#line 346 "Parser.y"
{
                		yyval.expr = new Tree.ReadIntExpr(val_peek(2).loc);
                	}
break;
case 73:
//#line 350 "Parser.y"
{
                		yyval.expr = new Tree.ReadLineExpr(val_peek(2).loc);
                	}
break;
case 74:
//#line 354 "Parser.y"
{
                		yyval.expr = new Tree.ThisExpr(val_peek(0).loc);
                	}
break;
case 75:
//#line 358 "Parser.y"
{
						yyval.expr = new Tree.Super(val_peek(0).loc);
					}
break;
case 76:
//#line 362 "Parser.y"
{
                		yyval.expr = new Tree.NewClass(val_peek(2).ident, val_peek(3).loc);
                	}
break;
case 77:
//#line 366 "Parser.y"
{
                		yyval.expr = new Tree.NewArray(val_peek(3).type, val_peek(1).expr, val_peek(4).loc);
                	}
break;
case 78:
//#line 370 "Parser.y"
{
                		yyval.expr = new Tree.TypeTest(val_peek(3).expr, val_peek(1).ident, val_peek(5).loc);
                	}
break;
case 79:
//#line 374 "Parser.y"
{
                		yyval.expr = new Tree.TypeCast(val_peek(2).ident, val_peek(0).expr, val_peek(0).loc);
                	}
break;
case 80:
//#line 380 "Parser.y"
{
						yyval.expr = new Tree.Literal(val_peek(0).typeTag, val_peek(0).literal, val_peek(0).loc);
					}
break;
case 81:
//#line 384 "Parser.y"
{
						yyval.expr = new Null(val_peek(0).loc);
					}
break;
case 82:
//#line 390 "Parser.y"
{
						yyval.casedef = new Tree.CaseDef(Tree.NORMALCASE, val_peek(3).expr, val_peek(1).expr, val_peek(3).loc);
					}
break;
case 83:
//#line 395 "Parser.y"
{
						yyval.casedef = new Tree.CaseDef(Tree.DEFAULTCASE, null, val_peek(1).expr, val_peek(3).loc);
					}
break;
case 84:
//#line 400 "Parser.y"
{
						yyval.caselist.add(val_peek(0).casedef);
					}
break;
case 85:
//#line 404 "Parser.y"
{
                		yyval = new SemValue() ;
                		yyval.caselist = new ArrayList<Tree.CaseDef>();
                	}
break;
case 87:
//#line 412 "Parser.y"
{
                		yyval = new SemValue();
                		yyval.elist = new ArrayList<Tree.Expr>();
                	}
break;
case 88:
//#line 419 "Parser.y"
{
						yyval.elist.add(val_peek(0).expr);
					}
break;
case 89:
//#line 423 "Parser.y"
{
                		yyval.elist = new ArrayList<Tree.Expr>();
						yyval.elist.add(val_peek(0).expr);
                	}
break;
case 90:
//#line 430 "Parser.y"
{
						yyval.stmt = new Tree.WhileLoop(val_peek(2).expr, val_peek(0).stmt, val_peek(4).loc);
					}
break;
case 91:
//#line 436 "Parser.y"
{
						yyval.stmt = new Tree.ForLoop(val_peek(6).stmt, val_peek(4).expr, val_peek(2).stmt, val_peek(0).stmt, val_peek(8).loc);
					}
break;
case 92:
//#line 442 "Parser.y"
{
						yyval.stmt = new Tree.Break(val_peek(0).loc);
					}
break;
case 93:
//#line 448 "Parser.y"
{
						yyval.stmt = new Tree.If(val_peek(3).expr, val_peek(1).stmt, val_peek(0).stmt, val_peek(5).loc);
					}
break;
case 94:
//#line 454 "Parser.y"
{
						yyval.stmt = val_peek(0).stmt;
					}
break;
case 95:
//#line 458 "Parser.y"
{
						yyval = new SemValue();
					}
break;
case 96:
//#line 464 "Parser.y"
{
						yyval.stmt = new Tree.Return(val_peek(0).expr, val_peek(1).loc);
					}
break;
case 97:
//#line 468 "Parser.y"
{
                		yyval.stmt = new Tree.Return(null, val_peek(0).loc);
                	}
break;
case 98:
//#line 474 "Parser.y"
{
						yyval.stmt = new Print(val_peek(1).elist, val_peek(3).loc);
					}
break;
case 99:
//#line 480 "Parser.y"
{
						yyval.stmt = new PrintComp(val_peek(1).elist, val_peek(3).loc);
					}
break;
case 100:
//#line 485 "Parser.y"
{
						yyval.dosubstmt = new Tree.DoSubStmt(val_peek(2).expr, val_peek(0).stmt, val_peek(2).loc);
					}
break;
case 101:
//#line 490 "Parser.y"
{
						yyval.dosubstmtlist.add(val_peek(1).dosubstmt) ;
					}
break;
case 102:
//#line 494 "Parser.y"
{
                		yyval = new SemValue() ;
                		yyval.dosubstmtlist = new ArrayList<Tree.DoSubStmt>();
                	}
break;
case 103:
//#line 500 "Parser.y"
{
						yyval.stmt = new Tree.DoStmt(val_peek(2).dosubstmtlist, val_peek(1).dosubstmt, val_peek(3).loc);
					}
break;
//#line 1415 "Parser.java"
//########## END OF USER-SUPPLIED ACTIONS ##########
    }//switch
    //#### Now let's reduce... ####
    //if (yydebug) debug("reduce");
    state_drop(yym);             //we just reduced yylen states
    yystate = state_peek(0);     //get new state
    val_drop(yym);               //corresponding value drop
    yym = yylhs[yyn];            //select next TERMINAL(on lhs)
    if (yystate == 0 && yym == 0)//done? 'rest' state and at first TERMINAL
      {
      //if (yydebug) debug("After reduction, shifting from state 0 to state "+YYFINAL+"");
      yystate = YYFINAL;         //explicitly say we're done
      state_push(YYFINAL);       //and save it
      val_push(yyval);           //also save the semantic value of parsing
      if (yychar < 0)            //we want another character?
        {
        yychar = yylex();        //get next character
        //if (yychar<0) yychar=0;  //clean, if necessary
        //if (yydebug)
          //yylexdebug(yystate,yychar);
        }
      if (yychar == 0)          //Good exit (if lex returns 0 ;-)
         break;                 //quit the loop--all DONE
      }//if yystate
    else                        //else not done yet
      {                         //get next state and push, for next yydefred[]
      yyn = yygindex[yym];      //find out where to go
      if ((yyn != 0) && (yyn += yystate) >= 0 &&
            yyn <= YYTABLESIZE && yycheck[yyn] == yystate)
        yystate = yytable[yyn]; //get new state
      else
        yystate = yydgoto[yym]; //else go to new defred
      //if (yydebug) debug("after reduction, shifting from state "+state_peek(0)+" to state "+yystate+"");
      state_push(yystate);     //going again, so push state & val...
      val_push(yyval);         //for next action
      }
    }//main loop
  return 0;//yyaccept!!
}
//## end of method parse() ######################################



//## run() --- for Thread #######################################
//## The -Jnorun option was used ##
//## end of method run() ########################################



//## Constructors ###############################################
//## The -Jnoconstruct option was used ##
//###############################################################



}
//################### END OF CLASS ##############################
