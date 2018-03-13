package lab2926.exceptions;

public class InvalidBudgetException extends Exception {
	private static final long serialVersionUID = -69637829093235855L;
	public InvalidBudgetException(String message) {
		super(message);
	}
}
