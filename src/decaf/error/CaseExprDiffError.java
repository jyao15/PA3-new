package decaf.error;

import decaf.Location;

/**
 * example锛�'break' is only allowed inside a loop<br>
 * PA2
 */
public class CaseExprDiffError extends DecafError {
	
	private String given; 
	private String expected; 
	
	public CaseExprDiffError(Location location, String given, String expected) {
		super(location);
		this.given = given ;
		this.expected = expected ;
	}

	@Override
	protected String getErrMsg() {
		return "type: " + given + " is different with other expr's type " + expected;
	}

}
