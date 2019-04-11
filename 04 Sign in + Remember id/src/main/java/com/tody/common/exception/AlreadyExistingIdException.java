package com.tody.common.exception;

public class AlreadyExistingIdException extends RuntimeException {
	public AlreadyExistingIdException(String message) {
		super(message);
	}
}
