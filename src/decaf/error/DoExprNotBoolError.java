package decaf.error;

import decaf.Location;

/**
 * example：field 'homework' of 'Others' not accessible here<br>
 * PA2
 */
public class DoExprNotBoolError extends DecafError {

	private String given;
	
	public DoExprNotBoolError(Location location, String given) {
		super(location);
		this.given = given;
	}

	@Override
	protected String getErrMsg() {
		return "The condition of Do Stmt requestd type bool but " + given + " given";
	}

}
