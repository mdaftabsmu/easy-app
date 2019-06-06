package com.easyapper.easyapperservices.exception;

public class EmailAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailAlreadyExistException() {
		super();
	}

	public EmailAlreadyExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmailAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmailAlreadyExistException(String message) {
		super(message);
	}

	public EmailAlreadyExistException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
