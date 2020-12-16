package com.capg.hcsam.exception;


/*******************************************************************************************************************************
-Author                   :     Mohammad Ikram
-Created/Modified Date    :     18-11-2020
-Description              :     Appointment Already Approved Exception Handler

*******************************************************************************************************************************/

@SuppressWarnings("serial")
public class AppointmentAlreadyApprovedException extends RuntimeException {

	public AppointmentAlreadyApprovedException(String errorMessage)
	{
		super(errorMessage);
	}

}
