package marketplace.domain.exceptions;

@SuppressWarnings("serial")
public final class AlreadyExistException extends Exception {

	public AlreadyExistException(String message) {
		super(message);
	}

}
