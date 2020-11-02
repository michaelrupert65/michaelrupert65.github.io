package com.arteach.main.exceptions;

@SuppressWarnings("serial")
public class PasswordsDoNotMatchException extends Exception {
	public PasswordsDoNotMatchException(String errorMessage) {
		super(errorMessage);
	}

}
