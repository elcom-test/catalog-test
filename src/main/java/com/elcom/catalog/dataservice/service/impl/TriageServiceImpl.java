package com.elcom.catalog.dataservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.catalog.dataservice.repository.TriageRepository;
import com.elcom.catalog.dataservice.repository.UserRepository;
import com.elcom.catalog.dataservice.root.Triage;
import com.elcom.catalog.dataservice.root.User;
import com.elcom.catalog.dataservice.service.TriageService;

@Service
public class TriageServiceImpl implements TriageService {

	@Autowired
	private TriageRepository triageRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<Triage> getAllTriage() {
		return triageRepository.findAll();
	}

	@Override
	public List<Triage> getAllTriageByUser(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		
		return user.isPresent() ? triageRepository.findByUser(user.get()) : new ArrayList<Triage>();
	}

	@Override
	public Optional<Triage> getTriageById(Long triageId) {
		return triageRepository.findById(triageId);
	}

	@Override
	public void deleteTriage(Triage triage) {
		triageRepository.delete(triage);
	}

	@Override
	public List<Triage> getTriagesByStatus(String status) {
		
		return triageRepository.findByActiveFlag(status);
	}
}
