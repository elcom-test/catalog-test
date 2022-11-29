package com.elcom.catalog.dataservice.service;

import java.util.List;
import java.util.Optional;

import com.elcom.catalog.dataservice.root.TriageAction;

public interface TriageActionService {
	List<TriageAction> getAllTriageActions();
	Optional<TriageAction> getTriageActionById(Long triageActionId);
	TriageAction saveTriageAction(TriageAction triageAction);
	void deleteTriageAction(TriageAction triageAction);
}