package com.example.bezbednost.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bezbednost.model.UserRole;
import com.example.bezbednost.repository.UserRoleRepository;

@Service
public class UserRoleService {

	@Autowired
	UserRoleRepository repository;
	
	public UserRole findByName(String name) {
		return repository.findByName(name);
	}
}
