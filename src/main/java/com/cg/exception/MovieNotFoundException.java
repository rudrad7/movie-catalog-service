package com.cg.exception;

public class MovieNotFoundException extends Exception
{
	String msg;
	public MovieNotFoundException() {
		super();
		
	}

	public MovieNotFoundException(String message) {
	
		super(message);
		this.msg=msg;
		// TODO Auto-generated constructor stub
	}
	 
}
