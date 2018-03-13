package lab2926.exceptions;

public class InvalidNameException extends Exception {
	private static final long serialVersionUID = -69637829093235855L;
	
	public InvalidNameException(String message) {
		super(message);
	}
}
