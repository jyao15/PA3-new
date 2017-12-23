package decaf.error;

import decaf.Location;

/**
 * example锛歩ncompatible argument 3: int[] given, int/bool/string expected<br>
 * 3琛ㄧず鍙戠敓閿欒鐨勬槸绗笁涓弬鏁�<br>
 * PA2
 */
public class BadPrintCompArgError extends DecafError {

	private String count;

	private String type;

	public BadPrintCompArgError(Location location, String count, String type) {
		super(location);
		this.count = count;
		this.type = type;
	}

	@Override
	protected String getErrMsg() {
		return "incompatible argument " + count + ": " + type
				+ " given, complex expected";
	}

}
