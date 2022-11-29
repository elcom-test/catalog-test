package com.elcom.catalog.dataservice.service;

import java.util.List;
import java.util.Optional;

import com.elcom.catalog.dataservice.root.UserAuth;

public interface UserAuthService {
	
	public Optional<UserAuth> getUserAuth(UserAuth userAuth);
	public Optional<UserAuth> getUserAuthById(Long id);
	public void saveUserAuthAttrbute(UserAuth userAuth);	
	// hibernate search methods
	public List<UserAuth> searchUserAuth(String searchCriteria);
	

}
