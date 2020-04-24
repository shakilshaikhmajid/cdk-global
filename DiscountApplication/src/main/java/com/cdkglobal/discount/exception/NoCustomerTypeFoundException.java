package com.cdkglobal.discount.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NoCustomerTypeFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	public NoCustomerTypeFoundException(String message)
	{
		super(message);
		
	}
	public String toString()
	{
		return super.getMessage();
	}

}
