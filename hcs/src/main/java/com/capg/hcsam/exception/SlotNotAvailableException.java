package com.capg.hcsam.exception;

/*******************************************************************************************************************************
-Author                   :     Mohammad Ikram
-Created/Modified Date    :     19-11-2020
-Description              :     Slot Not Available Exception Handler

*******************************************************************************************************************************/

@SuppressWarnings("serial")
public class SlotNotAvailableException extends Exception {

	public SlotNotAvailableException(String errorMessage) {
		super( errorMessage);
	}

}
