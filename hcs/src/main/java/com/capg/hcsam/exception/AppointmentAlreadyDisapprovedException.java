package com.capg.hcsam.exception;

/*******************************************************************************************************************************
-Author                   :     Mohammad Ikram
-Created/Modified Date    :     19-11-2020
-Description              :     Appointment already Disapproved Exception Handler

*******************************************************************************************************************************/

@SuppressWarnings("serial")
public class AppointmentAlreadyDisapprovedException extends Exception {


	public AppointmentAlreadyDisapprovedException(String errorMessage) {
		
		super(errorMessage);
	}

}
