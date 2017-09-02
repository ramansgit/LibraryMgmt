package com.library.exception;

/**
 * throws user not found exception when user not found
 * @author Test
 *
 */
public class UserNotFoundException extends Exception{

	
	String code;
	String message;

	public UserNotFoundException(String code, String message) {

		this.code = code;
		this.message = message;
	}

}
