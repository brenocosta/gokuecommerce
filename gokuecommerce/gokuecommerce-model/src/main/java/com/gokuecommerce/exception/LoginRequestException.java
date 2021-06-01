package com.gokuecommerce.exception;

public class LoginRequestException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public LoginRequestException(String exceptioMessage){
		super(exceptioMessage);
	}

}
