package com.example.bezbednost.dto;

import com.example.bezbednost.model.User;

public class UserDTO {
	
	private Long id;
	private String email;
	private String password;
	
	
	public UserDTO() {
		
	}
	
	public UserDTO(User user) {
		super();
		this.id = user.getId();
		this.email = user.getEmail();
		//this.password = user.getPassword();
		
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

}
