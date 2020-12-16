package com.capg.hcsam.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capg.hcsam.exception.AppointmentAlreadyApprovedException;
import com.capg.hcsam.exception.AppointmentAlreadyDisapprovedException;
import com.capg.hcsam.exception.AppointmentNotFoundException;
import com.capg.hcsam.exception.SlotNotAvailableException;

/*******************************************************************************************************************************
-Author                   :     Mohammad Ikram
-Created/Modified Date    :     18-11-2020/20-11-2020
-Description              :     Global Exception Advisor

*******************************************************************************************************************************/

@RestControllerAdvice
public class ExceptionAppointmentAdvisor {
	
	@ExceptionHandler(AppointmentNotFoundException.class)
	public ResponseEntity<String> handleAppointmentNotFoundException(AppointmentNotFoundException exp) 
	{
		return new ResponseEntity<String>(exp.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AppointmentAlreadyApprovedException.class)
	public ResponseEntity<String> handleAppointmentAlreadyApprovedException(AppointmentAlreadyApprovedException exp) 
	{
		return new ResponseEntity<String>(exp.getMessage(),HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(AppointmentAlreadyDisapprovedException.class)
	public ResponseEntity<String> handleAppointmentAlreadyDisapprovedException(AppointmentAlreadyDisapprovedException exp) 
	{
		return new ResponseEntity<String>(exp.getMessage(),HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(SlotNotAvailableException.class)
	public ResponseEntity<String> handleSlotNotAvailableException(SlotNotAvailableException exp)
	{
		return new ResponseEntity<String>(exp.getMessage(), HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleInvalidData(Exception exp) 
	{
		return new ResponseEntity<String>(exp.getMessage(), HttpStatus.BAD_REQUEST);
	}
	

	
	

}
