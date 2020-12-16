package com.capg.hcstm.exception;

@SuppressWarnings("serial")
public class NoTestIsAvailableException extends Exception {

	public NoTestIsAvailableException(String message)
	{
		super(message);
	}
	public NoTestIsAvailableException()
	{
		super();
	}
}
