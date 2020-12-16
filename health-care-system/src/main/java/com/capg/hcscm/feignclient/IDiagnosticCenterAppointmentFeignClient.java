package com.capg.hcscm.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capg.hcscm.entity.AppointmentManagement;


@FeignClient(name = "HealthCareSystem-AppointmentManagement-Microservices")
public interface IDiagnosticCenterAppointmentFeignClient {
	
	@GetMapping("api/v1/appointment/getAllAppointments/{centreId}")
	public List<AppointmentManagement> getAllAppointmentByCenterId(@PathVariable String centreId);
	
}
