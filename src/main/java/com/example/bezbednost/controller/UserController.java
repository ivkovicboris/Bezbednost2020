package com.example.bezbednost.controller;

import java.util.ArrayList;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.bezbednost.model.User;
import com.example.bezbednost.model.UserRole;
import com.example.bezbednost.security.Util;
import com.example.bezbednost.service.UserRoleService;
import com.example.bezbednost.service.UserService;
import com.example.bezbednost.dto.UserDTO;

@RestController
@RequestMapping(value="/user")
public class UserController {

Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService service;
	
	@Autowired
	UserRoleService roleService;
	
	@Autowired
	Util util;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable long id){
		User user = service.findOne(id);
		
		if(user == null) {
			logger.warn("NP-K: {}, NP_EVENT", id);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("P-K: {}, NP_EVENT", id);
		return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value="/getAll")
	public ResponseEntity<List<UserDTO>> findAll(){
		
		List<User> services = service.findAll();
		
		List<UserDTO> servicesDTO = new ArrayList<UserDTO>();
		
		for(User u : services) {
			servicesDTO.add(new UserDTO(u));
		}
		logger.info("PS-K, NP_EVENT");
		return new ResponseEntity<>(servicesDTO, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('USER')")
	@PostMapping(value="/create")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
		User user = new User(userDTO);
		List<UserRole> roles = new ArrayList<UserRole>();
		roles.add(roleService.findByName("ROLE_USER"));
		user.setRoles(roles);
		user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		System.out.println(passwordEncoder.encode(userDTO.getPassword()));
		
		user = service.save(user);
		
		logger.info("R-K: {}, NP_EVENT", user.getId());
		return new ResponseEntity<UserDTO>(new UserDTO(user), HttpStatus.OK);
	}
	
	// Ako zelimo da dozvolimo korisniku koji mora da ima i jednu i drugu rolu
	//@PreAuthorize("hasRole('ADMIN') and hasRole('AGENT')")
	// Ako zelimo da dozvolimo korisniku koji ima ili jednu ili drugu rolu
	//@PreAuthorize("hasRole('ADMIN') or hasRole('AGENT')")
	// Ako zelimo da dozvolimo korisniku koji ima samo tu rolu
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping(value="/{id}")
	public void delete(@PathVariable long id){
		User user = service.findOne(id);
		logger.info("O-K: {}, NP_EVENT", user.getId());
		service.delete(user);
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping(value="/getCurrentUser")
	public ResponseEntity<UserDTO> getCurrentUser(){
		User user = util.getCurrentUser();
		if(user == null) {
			logger.warn("NP-K, NP_EVENT");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		logger.info("P-K: {}, NP_EVENT", user.getId());
		return new ResponseEntity<>(new UserDTO(user), HttpStatus.OK);
		
	}
	
	
}
