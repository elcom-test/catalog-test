package com.elcom.catalog.dataservice.service;

import java.util.List;
import java.util.Optional;

import com.elcom.catalog.dataservice.root.Triage;

public interface TriageService {
	List<Triage> getAllTriage();
	List<Triage> getTriagesByStatus(String status);
	List<Triage> getAllTriageByUser(Long userId);
	Optional<Triage> getTriageById(Long triageId);
	void deleteTriage(Triage triage);
}