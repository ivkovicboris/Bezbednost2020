package com.example.bezbednost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bezbednost.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findOneById(long id);
	User findOneByEmail(String email);
	
}
