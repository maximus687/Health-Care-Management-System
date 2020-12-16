package com.capg.hcscm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.hcscm.entity.DiagnosticCenter;

public interface DiagnosticCenterRepo extends JpaRepository<DiagnosticCenter, String> {
	
	public boolean existsByCenterName(String centerName);
	
	public List<DiagnosticCenter> getAllTestsByCenterId(String centerId);
}
