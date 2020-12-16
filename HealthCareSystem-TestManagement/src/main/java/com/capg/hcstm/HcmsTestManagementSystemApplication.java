package com.capg.hcstm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "HealthCare APIs", version = "1.0",description = "HealthCareSystem-TestManagement-Microservices" ))
@SpringBootApplication
@EnableEurekaClient
public class HcmsTestManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HcmsTestManagementSystemApplication.class, args);
	}
}
