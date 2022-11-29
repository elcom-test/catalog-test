package com.elcom.catalog.dataservice.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcom.catalog.dataservice.repository.UserRepository;
import com.elcom.catalog.dataservice.root.User;
import com.elcom.catalog.dataservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	private UserRepository userRepository;

	public Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}
	
	public Optional<User> getUserByName(String userName) {
		return userRepository.getUserByName(userName);
	}
	
	@Override
	public User saveUser(User user) {
		return userRepository.saveAndFlush(user);
	}
}