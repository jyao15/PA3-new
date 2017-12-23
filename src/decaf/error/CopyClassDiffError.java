package decaf.error;

import decaf.Location;

/**
 * example锛�'break' is only allowed inside a loop<br>
 * PA2
 */
public class CopyClassDiffError extends DecafError {
	
	private String source; 
	private String dest; 
	
	public CopyClassDiffError(Location location, String source, String dest) {
		super(location);
		this.source = source ;
		this.dest = dest ;
	}

	@Override
	protected String getErrMsg() {
		return "For copy expr, the source " + source + " and the destination " + dest + " are not same";
	}

}
