package com.elcom.catalog.dataservice.service.impl;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.catalog.dataservice.repository.AuthRepostiory;
import com.elcom.catalog.dataservice.root.Auth;
import com.elcom.catalog.dataservice.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	AuthRepostiory authRepo;

	@Override
	public Optional<Auth> getAuth(Auth auth) {
		
		return null;
		//return authRepo.get(auth);
	}

	@Override
	public Optional<Auth> getAuthById(Long id) {
		// TODO Auto-generated method stub
		return authRepo.findById(id);
	}

	@Override
	public void saveAuth(Auth auth) {
		authRepo.saveAndFlush(auth);
	}

	

}
