package com.capg.hcstm.exception;



@SuppressWarnings("serial")
public class TestIdDoesNotExistException extends Exception {

	public TestIdDoesNotExistException(String message)
	{
		super(message);
	}
	public TestIdDoesNotExistException()
	{
		super();
	}
}