package decaf.error;

import decaf.Location;

/**
 * example锛�'orz' is not a method in class 'Person'<br>
 * PA2
 */
public class SuperNonParentError extends DecafError {

	private String name;

	public SuperNonParentError(Location location, String name) {
		super(location);
		this.name = name;
	}

	@Override
	protected String getErrMsg() {
		return "no parent class exist for " + name;
	}

}
