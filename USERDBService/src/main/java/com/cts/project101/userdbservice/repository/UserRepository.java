package com.cts.project101.userdbservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.project101.userdbservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmailId(String emailId);
	
	Optional<User> findByUsername(String username);
	
	Integer deleteByUsername(String username);
	
	Integer deleteByEmailId(String emailId);
	
}
