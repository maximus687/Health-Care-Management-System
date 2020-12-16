package com.capg.hcsum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "HealthCare APIs", version = "1.0",description = "HealthCareSystem-UserManagement-Microservices" ))
@EnableEurekaClient
@SpringBootApplication
public class HealthCareSystemUserManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthCareSystemUserManagementApplication.class, args);
	}

}
