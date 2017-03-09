package marketplace.domain.exceptions;

@SuppressWarnings("serial")
public final class DoesNotExistException extends Exception {

	public DoesNotExistException(String message) {
		super(message);
	}

}
