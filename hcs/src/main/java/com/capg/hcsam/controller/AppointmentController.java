package com.capg.hcsam.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hcsam.dto.AppointmentManagementDto;
import com.capg.hcsam.entity.AppointmentManagement;
import com.capg.hcsam.entity.Status;
import com.capg.hcsam.exception.AppointmentAlreadyApprovedException;
import com.capg.hcsam.exception.AppointmentAlreadyDisapprovedException;
import com.capg.hcsam.exception.AppointmentNotFoundException;
import com.capg.hcsam.exception.SlotNotAvailableException;
import com.capg.hcsam.service.IAppointmentService;

/*******************************************************************************************************************************
-Author                   :     Mohammad Ikram
-Created/Modified Date    :     17-11-2020
-Description              :     REST Endpoints for Appointment Management Microservices

*******************************************************************************************************************************/
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController {
	
	@Autowired
	public IAppointmentService appointmentService;
	
	@PostMapping("/makeAppointment")
	public AppointmentManagementDto makeAppointment(@RequestBody AppointmentManagementDto appointmentDto)  throws SlotNotAvailableException
	{
		return appointmentService.makeAppointment(appointmentDto);
	}
	
	@GetMapping("/viewAppointment/{userId}")
	public ResponseEntity<List<AppointmentManagement>> viewAppointment(@PathVariable String userId ) throws AppointmentNotFoundException
	{
		return new ResponseEntity<List<AppointmentManagement>>(appointmentService.viewAppointment(userId), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/removeAppointment/{appointmentId}")
	public ResponseEntity<?> removeAppointment(@PathVariable BigInteger appointmentId) throws AppointmentNotFoundException
	{
		return new ResponseEntity<>(appointmentService.removeAppointmentById(appointmentId),HttpStatus.OK);
	}
	
	@GetMapping("/getAllAppointments/{centreId}")
	public ResponseEntity<List<AppointmentManagement>> getAllAppointments(@PathVariable String centreId )throws AppointmentNotFoundException
	{
		return new ResponseEntity<List<AppointmentManagement>>(appointmentService.getAllAppointments(centreId),HttpStatus.OK);
	}
	
	@GetMapping("/approveAppointment/{appointmentId}/{status}")
	//http://localhost:9200/api/v1/appointment/approveAppointment/27/approved
	public AppointmentManagement approveAppoinment(@PathVariable BigInteger appointmentId, @PathVariable Status status)throws AppointmentAlreadyApprovedException, AppointmentNotFoundException 
	{
		AppointmentManagement appointment = appointmentService.viewAppointmentById(appointmentId);
		return appointmentService.approveAppointment(appointment, status);
	}
	
	@GetMapping("/disapproveAppointment/{appointmentId}/{status}")
	public AppointmentManagement disapproveAppoinment(@PathVariable BigInteger appointmentId, @PathVariable Status status) throws AppointmentAlreadyDisapprovedException, AppointmentNotFoundException
	{
		AppointmentManagement appointment = appointmentService.viewAppointmentById(appointmentId);
		return appointmentService.disapproveAppointment(appointment, status);
	}
	
	@GetMapping("/viewAppointmentById/{appointmentId}")
	public ResponseEntity<AppointmentManagement> viewAppointmentByid(@PathVariable BigInteger appointmentId) throws AppointmentNotFoundException 
	{
		return new ResponseEntity<AppointmentManagement>(appointmentService.viewAppointmentById(appointmentId), HttpStatus.OK);
	}
	

}
