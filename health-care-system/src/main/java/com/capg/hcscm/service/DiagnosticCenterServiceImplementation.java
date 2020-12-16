package com.capg.hcscm.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hcscm.entity.AppointmentManagement;
import com.capg.hcscm.entity.DiagnosticCenter;
import com.capg.hcscm.entity.TestManagement;
import com.capg.hcscm.exception.CenterAlreadyExistsException;
import com.capg.hcscm.exception.CenterNameAlreadyExistsException;
import com.capg.hcscm.exception.NoCentersAreAvailableException;
import com.capg.hcscm.exception.SpecifiedCenterDoesnotExistException;
import com.capg.hcscm.feignclient.IDiagnosticCenterAppointmentFeignClient;
import com.capg.hcscm.feignclient.IDiagnosticCenterFeignClient;
import com.capg.hcscm.repository.DiagnosticCenterRepo;

@Service
public class DiagnosticCenterServiceImplementation implements IDiagnosticCenterService {

	@Autowired
	private Random random;

	@Autowired
	private DiagnosticCenterRepo repository;

	@Autowired
	private IDiagnosticCenterFeignClient feignClient;
	
	@Autowired
	private IDiagnosticCenterAppointmentFeignClient appointmentFeignClient;

	@Override
	public DiagnosticCenter getCenterById(String centerId) throws SpecifiedCenterDoesnotExistException {
		boolean existingCenter = repository.existsById(centerId);
		if (existingCenter) {
			DiagnosticCenter center = repository.getOne(centerId);
			return center;
		}
		throw new SpecifiedCenterDoesnotExistException("Center with center id " + centerId + "Doesnot exist");

	}

	@Override
	public DiagnosticCenter addCenter(DiagnosticCenter center)
			throws NoCentersAreAvailableException, CenterNameAlreadyExistsException, CenterAlreadyExistsException {
		//center.setCenterId(String.valueOf(random.nextInt(10000000)));
		if (repository.existsById(center.getCenterId())) {
			throw new CenterAlreadyExistsException("Center already exists kindly enter another center ID");
		}

		if (repository.existsByCenterName(center.getCenterName())) {
			throw new CenterNameAlreadyExistsException("Center Name Already exists Kindly enter some other name ");
		}

		return repository.save(center);

	}

	@Override
	public List<DiagnosticCenter> getAllCenters() throws NoCentersAreAvailableException {
		List<DiagnosticCenter> centerList = repository.findAll();

		if (centerList.isEmpty()) {
			throw new NoCentersAreAvailableException("No center is present");
		}

		return centerList;
	}

	@Override
	public boolean removeAllCenters() throws NoCentersAreAvailableException {
		List<DiagnosticCenter> centerList = repository.findAll();
		if (centerList.isEmpty()) {

			throw new NoCentersAreAvailableException("Centers are not present");
		}
		repository.deleteAll();
		return true;
	}

	@Override
	public boolean removeCenter(String centerId) throws SpecifiedCenterDoesnotExistException {
		if (repository.existsById(centerId)) {
			repository.deleteById(centerId);
			return true;
		}

		else {
			throw new SpecifiedCenterDoesnotExistException("Center doesnot exist kindly enter another center ID");
		}
	}

	@Override
	public List<TestManagement> getAllTests() {

		// TestManagement[]
		// testEntity=restTemplate.getForObject("http://localhost:8001/test/getAll",
		// TestManagement[].class);
		List<TestManagement> testList = feignClient.getTests();
		return testList;
	}
	
	@Override
	public List<AppointmentManagement> getAllAppointmentByCenterId(String centreId){
		
		List<AppointmentManagement> appointmentList = appointmentFeignClient.getAllAppointmentByCenterId(centreId);
		return appointmentList;
	}
	
	@Override
	public List<DiagnosticCenter> getAllTestsByCenterId(String centerId){
		List<DiagnosticCenter> testList = repository.getAllTestsByCenterId(centerId);
		return testList;
	}
	
	

}
