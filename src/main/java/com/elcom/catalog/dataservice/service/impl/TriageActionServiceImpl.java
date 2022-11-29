package com.elcom.catalog.dataservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.catalog.dataservice.repository.TriageActionRepository;
import com.elcom.catalog.dataservice.root.TriageAction;
import com.elcom.catalog.dataservice.service.TriageActionService;

@Service
public class TriageActionServiceImpl implements TriageActionService {

	@Autowired
	private TriageActionRepository triageActionRepository;

	
	@Override
	public List<TriageAction> getAllTriageActions() {
		return triageActionRepository.findAll();
	}

	@Override
	public Optional<TriageAction> getTriageActionById(Long triageActionId) {
		return triageActionRepository.findById(triageActionId);
	}
	
	@Override
	public TriageAction saveTriageAction(TriageAction triageAction) {
		
		return triageActionRepository.saveAndFlush(triageAction);
	}

	@Override
	public void deleteTriageAction(TriageAction triageAction) {
		triageActionRepository.delete(triageAction);
	}

}
