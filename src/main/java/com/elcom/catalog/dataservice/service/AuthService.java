package com.elcom.catalog.dataservice.service;

import java.util.List;
import java.util.Optional;

import com.elcom.catalog.dataservice.root.Auth;

public interface AuthService {
	
	public Optional<Auth> getAuth(Auth auth);
	public Optional<Auth> getAuthById(Long id);
	public void saveAuth(Auth auth);

}
