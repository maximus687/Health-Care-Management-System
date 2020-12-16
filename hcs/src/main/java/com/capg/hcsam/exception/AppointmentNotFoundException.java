package com.capg.hcsam.exception;

import org.springframework.http.HttpStatus;

/*******************************************************************************************************************************
-Author                   :     Mohammad Ikram
-Created/Modified Date    :     19-11-2020
-Description              :     Appointment Not Found Exception Handler

*******************************************************************************************************************************/

@SuppressWarnings("serial")
public class AppointmentNotFoundException extends Exception {
	
	String message;
	HttpStatus status;
	
	public AppointmentNotFoundException(String errorMessage) {
		super(errorMessage);
	}

	public AppointmentNotFoundException(String message, HttpStatus status) 
	{
		this.message = message;
		this.status = status;
	}
	
	

}
