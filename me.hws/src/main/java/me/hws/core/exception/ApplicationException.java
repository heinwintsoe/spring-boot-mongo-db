package me.hws.core.exception;

public class ApplicationException extends Exception {

	public ApplicationException() {
		super();
	}

	public ApplicationException(String message, Throwable throwable, boolean arg2,
			boolean arg3) {
		super(message, throwable, arg2, arg3);
	}

	public ApplicationException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(Throwable throwable) {
		super(throwable);
	}

}
