package hust.soict.hedspi.aims.exception;

public class DataValidationException extends Exception {

	public DataValidationException() {
	}

	public DataValidationException(String message) {
		super(message);
	}

	public DataValidationException(Throwable cause) {
		super(cause);
	}

	public DataValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataValidationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
