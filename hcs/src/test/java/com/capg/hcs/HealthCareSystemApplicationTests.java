package com.capg.hcs;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.math.BigInteger;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.capg.hcsam.controller.AppointmentController;
import com.capg.hcsam.entity.AppointmentManagement;
import com.capg.hcsam.entity.Status;
import com.capg.hcsam.service.IAppointmentService;


@WebMvcTest(AppointmentController.class)
class HealthCareSystemApplicationTests {
	
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	public IAppointmentService appointmentService;
	
	@Test
	public void getAppointmentById() throws Exception {
		
		//mock the data return by the userService class
		
		AppointmentManagement appointment = new AppointmentManagement();
		 appointment.setAppointmentId(BigInteger.valueOf(3));
		 appointment.setCentreId("C002");
		 appointment.setDateTime(LocalDateTime.of(2020, 11, 20, 12, 25, 44));
		 appointment.setStatus(Status.approved);
		 appointment.setTestId("T002");
		 appointment.setUserId("U002");
		 appointmentService.viewAppointmentById(BigInteger.valueOf(2));
		 
		 when(appointmentService.viewAppointmentById(BigInteger.valueOf(2))).thenReturn(appointment);
		 
		 //create Mock HTTP request to verify the expected results
		 
		 mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/appointment//viewAppointment/2"))
		                                    .andDo(print())
		 									.andExpect(MockMvcResultMatchers.jsonPath("$.appointmentId").value(2))
		 									.andExpect(status().isOk());
		 }
}
