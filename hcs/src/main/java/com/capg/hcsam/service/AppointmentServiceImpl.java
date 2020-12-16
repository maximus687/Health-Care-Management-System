package com.capg.hcsam.service;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hcsam.dto.AppointmentManagementDto;
import com.capg.hcsam.entity.AppointmentManagement;
import com.capg.hcsam.entity.Status;
import com.capg.hcsam.exception.AppointmentAlreadyApprovedException;
import com.capg.hcsam.exception.AppointmentAlreadyDisapprovedException;
import com.capg.hcsam.exception.AppointmentNotFoundException;
import com.capg.hcsam.exception.SlotNotAvailableException;
import com.capg.hcsam.repository.IAppointmentRepo;

/*******************************************************************************************************************************
 * -Author                :    Mohammad Ikram 
 * -Created/Modified Date :    16-11-2020
 * -Description           :    Service Implementation Class for Appointment Management 
 * 
 *******************************************************************************************************************************/
@Service
public class AppointmentServiceImpl implements IAppointmentService {

	@Autowired
	IAppointmentRepo appointmentRepo;

	@Override
	public AppointmentManagementDto makeAppointment(AppointmentManagementDto appointmentDto) throws SlotNotAvailableException {
		LocalTime time = appointmentDto.getDateTime().toLocalTime();
		if ((appointmentRepo.getAppointmentByDateTimeAndTestId(appointmentDto.getDateTime(),
				appointmentDto.getTestId())!=null)
				|| appointmentDto.getDateTime().isBefore(LocalDateTime.now().plusHours(1))
				|| appointmentDto.getDateTime().isAfter(LocalDateTime.now().plusMonths(3))
				|| time.isBefore(LocalTime.of(6, 59)) || time.isAfter(LocalTime.of(21, 00))) {
			throw new SlotNotAvailableException("This slot is not available");
		}
		AppointmentManagement appointment = new AppointmentManagement();
		appointment.setCentreId(appointmentDto.getCentreId());
		appointment.setTestId(appointmentDto.getTestId());
		appointment.setUserId(appointmentDto.getUserId());
		appointment.setDateTime(appointmentDto.getDateTime());
		appointment.setStatus(appointmentDto.getStatus());
		//AppointmentManagement appointment = new ObjectMapper().convertValue(appointmentDto, AppointmentManagement.class);
		appointmentDto.setAppointmentId(appointmentRepo.save(appointment).getAppointmentId());
		return appointmentDto;
	}

	@Override
	public List<AppointmentManagement> viewAppointment(String userId) throws AppointmentNotFoundException {
        
		
		if (appointmentRepo.existsById(userId)==null) {
			throw new AppointmentNotFoundException("Appointment For User with  UserId: " + userId + " not present");
		}
		return appointmentRepo.existsById(userId);

	}

	@Override
	public AppointmentManagement approveAppointment(AppointmentManagement appointment, Status status) throws AppointmentAlreadyApprovedException {

		if (appointment.getStatus() == Status.approved) {
			throw new AppointmentAlreadyApprovedException(
					"Appointment with Id :" + appointment.getAppointmentId() + " is Already Approved");
		}
		appointment.setStatus(status);

		return appointmentRepo.save(appointment);

	}
	
	@Override
	public AppointmentManagement disapproveAppointment(AppointmentManagement appointment, Status status) throws AppointmentAlreadyDisapprovedException 
	{

		if (appointment.getStatus() == Status.disapproved)  {
			throw new AppointmentAlreadyDisapprovedException(
					"Appointment with Id :" + appointment.getAppointmentId() + "is Already Disapproved");
		}
		appointment.setStatus(status);

		return appointmentRepo.save(appointment);

	}
	
	@Override
	public boolean removeAppointmentById(BigInteger appointmentId) throws AppointmentNotFoundException {
		
		if(!appointmentRepo.existsById(appointmentId)) {
			throw new AppointmentNotFoundException("Appointment with id: " + appointmentId + " not found");
		}
		appointmentRepo.deleteById(appointmentId);
		return true;
	}

	@Override
	public List<AppointmentManagement> getAllAppointments(String centreId) throws AppointmentNotFoundException {
		
		if(appointmentRepo.findAll(centreId).isEmpty()) {
			throw new AppointmentNotFoundException("Appointment list is empty");
		}
		
		 List<AppointmentManagement> allAppointments = appointmentRepo.findAll(centreId);
		 return allAppointments;
		
	}

	@Override
	public AppointmentManagement viewAppointmentById(BigInteger appointmentId) throws AppointmentNotFoundException {
		if(appointmentRepo.findById(appointmentId).isEmpty()) {
			throw new AppointmentNotFoundException("Appointment not found");	
		}
		return appointmentRepo.getOne(appointmentId);
	}

}
