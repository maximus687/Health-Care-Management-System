package com.capg.hcscm;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "HealthCare APIs", version = "1.0",description = "HealthCareSystem-CentreManagement-Microservices"))
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.capg.hcscm.feignclient")
public class HealthCareSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthCareSystemApplication.class, args);
	}
	@Bean
	public Random generateRandom()
	{
	return new Random();	
	}
}
