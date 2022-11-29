package com.elcom.catalog.dataservice.service;

import java.util.Optional;

import com.elcom.catalog.dataservice.root.User;

public interface UserService {
    Iterable<User> getAllUsers();
	Optional<User> getUserById(Long id);
	Optional<User> getUserByName(String userName);
	User saveUser(User user);
}