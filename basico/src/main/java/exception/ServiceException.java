package exception;

@SuppressWarnings("serial")
public abstract class ServiceException extends RuntimeException {
	public ServiceException() {
		super();
	}
	
	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(Throwable tw) {
		super(tw);
	}

	public ServiceException(String message, Throwable tw) {
		super(message, tw);
	}
}
