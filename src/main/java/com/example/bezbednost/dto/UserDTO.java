package com.example.bezbednost.dto;

import com.example.bezbednost.model.User;
import com.example.bezbednost.model.UserRole;

public class UserDTO {
	
	private Long id;
	private String email;
	private String password;
	private String name;
	private String surname;
	private String phoneNumber;
	private UserRole role;
	
	public UserDTO() {
		
	}
	
	public UserDTO(User user) {
		super();
		this.id = user.getId();
		this.email = user.getEmail();
		//this.password = user.getPassword();
		this.name = user.getName();
		this.surname = user.getSurname();
		this.phoneNumber = user.getPhoneNumber();
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
