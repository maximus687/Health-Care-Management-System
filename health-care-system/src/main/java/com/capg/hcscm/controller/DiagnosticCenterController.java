package com.capg.hcscm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hcscm.entity.AppointmentManagement;
import com.capg.hcscm.entity.DiagnosticCenter;
import com.capg.hcscm.entity.TestManagement;
import com.capg.hcscm.exception.CenterAlreadyExistsException;
import com.capg.hcscm.exception.CenterNameAlreadyExistsException;
import com.capg.hcscm.exception.NoCentersAreAvailableException;
import com.capg.hcscm.exception.SpecifiedCenterDoesnotExistException;
import com.capg.hcscm.service.DiagnosticCenterServiceImplementation;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/center")
public class DiagnosticCenterController {

	@Autowired
	private DiagnosticCenterServiceImplementation centerService;

	@GetMapping("/getcenter/center-Id/{centerId}")
	public DiagnosticCenter getCenterById(@PathVariable String centerId) throws SpecifiedCenterDoesnotExistException {
		return centerService.getCenterById(centerId);
	}

	@GetMapping("/getallcenters")
	public List<DiagnosticCenter> getAllCenters() throws NoCentersAreAvailableException {
		return centerService.getAllCenters();
	}

	@PostMapping("/addcenter")
	public DiagnosticCenter addCenter(@RequestBody DiagnosticCenter center)
			throws NoCentersAreAvailableException, CenterNameAlreadyExistsException, CenterAlreadyExistsException {

		return centerService.addCenter(center);
	}

	@DeleteMapping("/removecenter/centerId/{centerId}")
	public boolean removeCenter(@PathVariable String centerId) throws SpecifiedCenterDoesnotExistException {
		return centerService.removeCenter(centerId);
	}

	@DeleteMapping("/removeAll")
	public boolean removeAllCenters() throws NoCentersAreAvailableException {
		return centerService.removeAllCenters();
	}

	@GetMapping("/AllTests")
	public List<TestManagement> getTests() {
		return centerService.getAllTests();
	}

    @GetMapping("/getAllAppointment/{centreId}")
    public List<AppointmentManagement> getAllAppointment(@PathVariable String centreId){
	    return centerService.getAllAppointmentByCenterId(centreId);
    }

    @GetMapping("/getAllTest/{centerId}")
    public List<DiagnosticCenter> getAllTestsByCenterId(@PathVariable String centerId){
	    return centerService.getAllTestsByCenterId(centerId);
    }

}