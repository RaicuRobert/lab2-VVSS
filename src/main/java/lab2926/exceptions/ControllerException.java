package lab2926.exceptions;

public class ControllerException extends Exception{
private static final long serialVersionUID = -69637829093235855L;
	
	public ControllerException(String message, Throwable throwable) {
		super(message,throwable);
	}
}
