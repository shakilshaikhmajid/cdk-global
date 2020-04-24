package com.cdkglobal.discount.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NegativeOrZeroAmountException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	public NegativeOrZeroAmountException(String message)
	{
		super(message);
		
	}
	public String toString()
	{
		return super.getMessage();
	}

}
