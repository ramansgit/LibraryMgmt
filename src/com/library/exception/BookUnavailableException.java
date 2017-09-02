package com.library.exception;

public class BookUnavailableException extends Exception {

	String code;
	String message;

	public BookUnavailableException(String code, String message) {

		this.code = code;
		this.message = message;
	}

}
