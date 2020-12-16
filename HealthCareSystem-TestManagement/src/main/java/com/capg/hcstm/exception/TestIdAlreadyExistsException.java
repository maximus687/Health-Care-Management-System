package com.capg.hcstm.exception;



@SuppressWarnings("serial")
public class TestIdAlreadyExistsException extends Exception {
	public TestIdAlreadyExistsException(String message)
	{
		super(message);
	}
	public TestIdAlreadyExistsException()
	{
		super();
	}
}

