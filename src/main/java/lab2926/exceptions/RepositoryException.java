package lab2926.exceptions;

public class RepositoryException extends Exception{
	private static final long serialVersionUID = -69637829093235855L;
	public RepositoryException() {
		super();
	}
	public RepositoryException(String message) {
		super(message);
	}
	public RepositoryException(String message, Throwable throwable) {
		super(message,throwable);
	}
}
