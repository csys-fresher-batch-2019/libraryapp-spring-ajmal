package com.chainsys.libraryapp.exception;

public class ValidationException extends Exception {

	private static final long serialVersionUID = 1L;

	public ValidationException(String message) {
		super(message);
	}
	public ValidationException(String message, Exception e) {
		super(message,e);
	}

}
