package com.example.bezbednost.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


import com.example.bezbednost.dto.UserDTO;

@Entity
@Table(name = "users")
public class User {
	private static final long serialVersionUID = 5304180350013858260L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "email", nullable = false, length = 50, unique = true)
	private String email;
	
	@Column(name = "password", nullable = false, length = 80)
	private String password;
		
	

	public User() {
		super();
	}

	public User(Long id, String email, String password, String name, String surname, String phoneNumber) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		
	}
	
	public User(UserDTO user) {
		this.email = user.getEmail();
		this.password = user.getPassword();
		
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}