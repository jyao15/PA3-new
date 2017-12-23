package decaf.error;

import decaf.Location;

/**
 * example锛�'orz' is not a method in class 'Person'<br>
 * PA2
 */
public class SuperLValueError extends DecafError {

	public SuperLValueError(Location location) {
		super(location);
	}

	@Override
	protected String getErrMsg() {
		return "super.member_var is not supported" ;
	}

}
