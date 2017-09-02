package com.library.exception;

/**
 * throws validation exception when bad request passed in the system
 * @author Test
 *
 */
public class ValidationException  extends Exception{

	
	String code;
	String message;

	public ValidationException(String code, String message) {

		this.code = code;
		this.message = message;
	}

}
