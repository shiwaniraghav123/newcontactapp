package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;





public interface RegistrationRepository extends CrudRepository<User, Long> {

	public User findByEmailId(String EmailId);
	public User findByEmailIdAndPassword(String EmailId, String Password);
}
