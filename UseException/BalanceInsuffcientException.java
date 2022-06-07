package UseException;

public class BalanceInsuffcientException extends Exception {
	public BalanceInsuffcientException() {}
	public BalanceInsuffcientException(String message) {
		super(message);
	}
}
