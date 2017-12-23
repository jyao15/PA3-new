package decaf.error;

import decaf.Location;

/**
 * example：class 'zig' not found<br>
 * PA2
 */
public class CopyNotClassError extends DecafError {

	private String name;

	public CopyNotClassError(Location location, String name) {
		super(location);
		this.name = name;
	}

	@Override
	protected String getErrMsg() {
		return "expected class type for copy expr but " + name + " given";
	}

}
