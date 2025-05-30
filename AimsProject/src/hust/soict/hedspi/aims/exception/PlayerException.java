package hust.soict.hedspi.aims.exception;

public class PlayerException extends Exception {

	public PlayerException() {}

	public PlayerException(String message) {
		super(message);
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(message);

		alert.showAndWait();		
	}

	public PlayerException(Throwable cause) {
		super(cause);
	}

	public PlayerException(String message, Throwable cause) {
		super(message, cause);
	}

	public PlayerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
