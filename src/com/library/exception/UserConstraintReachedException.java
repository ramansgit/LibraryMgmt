package com.library.exception;

public class UserConstraintReachedException  extends Exception {

	String code;
	String message;

	public UserConstraintReachedException(String code, String message) {

		this.code = code;
		this.message = message;
	}

}
