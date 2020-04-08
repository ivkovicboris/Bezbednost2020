package com.example.bezbednost.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "UserRoles")
public class UserRole implements GrantedAuthority {
	private static final long serialVersionUID = 7338922787968631932L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	public UserRole() {
		
	}
	
	public UserRole(String name) {
		this.name = name;
	}
	
	public UserRole(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getAuthority() {
		return name;
	}
	
	@Override
	public String toString() {
		return "UserRole [" +
				"name=" + name +
				"]";
	}
}