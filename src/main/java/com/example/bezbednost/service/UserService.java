package com.example.bezbednost.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bezbednost.model.User;
import com.example.bezbednost.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository repository;
	
	public User findOne(String email) {
		return repository.findOneByEmail(email);
	}
	
	public User findOne(long id) {
		return repository.findOneById(id);
	}
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User save(User user) {
		return repository.save(user);
	}
	
	public void delete(User user) {
		repository.delete(user);
	}
}

