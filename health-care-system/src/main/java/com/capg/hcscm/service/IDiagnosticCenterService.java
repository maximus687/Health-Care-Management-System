package com.capg.hcscm.service;

import java.util.List;

import com.capg.hcscm.entity.AppointmentManagement;
import com.capg.hcscm.entity.DiagnosticCenter;
import com.capg.hcscm.entity.TestManagement;
import com.capg.hcscm.exception.CenterAlreadyExistsException;
import com.capg.hcscm.exception.CenterNameAlreadyExistsException;
import com.capg.hcscm.exception.NoCentersAreAvailableException;
import com.capg.hcscm.exception.SpecifiedCenterDoesnotExistException;

public interface IDiagnosticCenterService {
		
		DiagnosticCenter addCenter(DiagnosticCenter center) throws  NoCentersAreAvailableException, CenterNameAlreadyExistsException, CenterAlreadyExistsException;
		
		List<DiagnosticCenter> getAllCenters() throws NoCentersAreAvailableException;
		
		DiagnosticCenter getCenterById(String centerId) throws SpecifiedCenterDoesnotExistException;
		
		boolean removeAllCenters() throws NoCentersAreAvailableException;
		
		boolean removeCenter(String centerId) throws SpecifiedCenterDoesnotExistException;
		
		List<TestManagement> getAllTests();

		List<AppointmentManagement> getAllAppointmentByCenterId(String centreId);

		List<DiagnosticCenter> getAllTestsByCenterId(String centerId);	
}
