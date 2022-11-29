package com.elcom.catalog.dataservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.elcom.catalog.dataservice.root.Auth;

@Repository
@Transactional
public interface AuthRepostiory extends JpaRepository<Auth, Long> {

	@Query("SELECT auth FROM Auth auth WHERE auth.authName = ?1")
	Optional<Auth> getAuthByName(String authName);

}
