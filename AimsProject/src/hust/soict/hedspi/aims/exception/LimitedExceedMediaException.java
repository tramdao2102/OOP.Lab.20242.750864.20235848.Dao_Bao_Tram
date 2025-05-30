package hust.soict.hedspi.aims.exception;

public class LimitExceedMediaException extends Exception {

	public LimitExceedMediaException() { }

	public LimitExceedMediaException(String message) {
		super(message);
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(message);

		alert.showAndWait();	
	}

	public LimitExceedMediaException(Throwable cause) {
		super(cause);
	}

	public LimitExceedMediaException(String message, Throwable cause) {
		super(message, cause);
	}

	public LimitExceedMediaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}