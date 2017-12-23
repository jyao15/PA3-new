package decaf.error;

import decaf.Location;

/**
 * example锛�'break' is only allowed inside a loop<br>
 * PA2
 */
public class CaseConditionNotIntError extends DecafError {

	private String given; 
	
	public CaseConditionNotIntError(Location location, String given) {
		super(location);
		this.given = given ;
	}

	@Override
	protected String getErrMsg() {
		return "incompatible case expr: " + given + " given, but int expected";
	}

}
