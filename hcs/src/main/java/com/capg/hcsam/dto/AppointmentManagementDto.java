package com.capg.hcsam.dto;

import java.math.BigInteger;
import java.time.LocalDateTime;
import com.capg.hcsam.entity.Status;
/*******************************************************************************************************************************
-Author                   :     Mohammad Ikram
-Created/Modified Date    :     21-11-2020
-Description              :     Appointment DTO class

*******************************************************************************************************************************/

public class AppointmentManagementDto {
	
	private BigInteger appointmentId;
	
	private String centreId;
	
	private String userId;
	
	private String testId;
	
	private LocalDateTime dateTime;
	
	private Status status;
	
	
	public AppointmentManagementDto(BigInteger appointmentId, String centreId, String userId, String testId,
			LocalDateTime dateTime, Status status) {
		super();
		this.appointmentId = appointmentId;
		this.centreId = centreId;
		this.userId = userId;
		this.testId = testId;
		this.dateTime = dateTime;
		this.status = status;
	}

	public BigInteger getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(BigInteger appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getCentreId() {
		return centreId;
	}

	public void setCentreId(String centreId) {
		this.centreId = centreId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
