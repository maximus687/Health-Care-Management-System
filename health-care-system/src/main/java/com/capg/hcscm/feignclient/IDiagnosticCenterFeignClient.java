package com.capg.hcscm.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.capg.hcscm.entity.TestManagement;



@FeignClient(name = "HealthCareSystem-TestManagement-Microservices")
public interface IDiagnosticCenterFeignClient {
	
	@GetMapping("/test/getAll")
	public List<TestManagement> getTests();
}
