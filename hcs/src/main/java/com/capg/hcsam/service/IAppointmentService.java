package com.capg.hcsam.service;

import java.math.BigInteger;
import java.util.List;

import com.capg.hcsam.dto.AppointmentManagementDto;
import com.capg.hcsam.entity.AppointmentManagement;
import com.capg.hcsam.entity.Status;
import com.capg.hcsam.exception.AppointmentAlreadyApprovedException;
import com.capg.hcsam.exception.AppointmentAlreadyDisapprovedException;
import com.capg.hcsam.exception.AppointmentNotFoundException;
import com.capg.hcsam.exception.SlotNotAvailableException;

/*******************************************************************************************************************************
 * -Author                : Mohammad Ikram 
 * -Created/Modified Date : 15-11-2020 
 * -Description           : Service Interface for Appointment Management Microservices
 * 
 *******************************************************************************************************************************/

public interface IAppointmentService {

	AppointmentManagementDto makeAppointment(AppointmentManagementDto appointmentDto) throws SlotNotAvailableException;

	boolean removeAppointmentById(BigInteger appointmentId) throws AppointmentNotFoundException;

	List<AppointmentManagement> viewAppointment(String userId) throws AppointmentNotFoundException;

	List<AppointmentManagement> getAllAppointments(String centreId) throws AppointmentNotFoundException;

	AppointmentManagement approveAppointment(AppointmentManagement appointment, Status status) throws AppointmentAlreadyApprovedException;

	AppointmentManagement disapproveAppointment(AppointmentManagement appointment, Status status) throws AppointmentAlreadyDisapprovedException;

	AppointmentManagement viewAppointmentById(BigInteger appointmentId) throws AppointmentNotFoundException;

}
