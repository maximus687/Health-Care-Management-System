package com.capg.hcsam.repository;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.capg.hcsam.entity.AppointmentManagement;

/*******************************************************************************************************************************
-Author                   :     Mohammad Ikram
-Created/Modified Date    :     15-11-2020
-Description              :     Repository interface extending Data JPA

*******************************************************************************************************************************/
@Repository
public interface IAppointmentRepo extends JpaRepository<AppointmentManagement, BigInteger> {
    @Query("FROM AppointmentManagement where centreId = ?1")
	public List<AppointmentManagement> findAll(String centreId);
    
    @Query(" select a from AppointmentManagement a where a.dateTime = ?1 and a.testId = ?2 ")
	public AppointmentManagement getAppointmentByDateTimeAndTestId(LocalDateTime dateTime, String testId);
     
	@Query("FROM AppointmentManagement  WHERE userId = ?1")
	public List<AppointmentManagement> existsById(String userId);
	

}
