package decaf.error;

import decaf.Location;

/**
 * example锛�'break' is only allowed inside a loop<br>
 * PA2
 */
public class CaseConditionRepeatError extends DecafError {
	
	public CaseConditionRepeatError(Location location) {
		super(location);
	}

	@Override
	protected String getErrMsg() {
		return "condition is not unique";
	}

}
