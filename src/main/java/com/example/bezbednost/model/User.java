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

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.bezbednost.dto.UserDTO;

@Entity
@Table(name = "users")
public class User implements UserDetails {
	private static final long serialVersionUID = 5304180350013858260L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	
	@Column(name = "email", nullable = false, length = 50, unique = true)
	private String email;
	
	@Column(name = "password", nullable = false, length = 80)
	private String password;
		
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns=@JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns=@JoinColumn(name = "role_id", referencedColumnName = "id"))
	private List<UserRole> roles;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;

	public User() {
		super();
	}

	public User(Long id, String email, String password, String name, String surname, String phoneNumber) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
	}
	
	public User(UserDTO user) {
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.name = user.getName();
		this.surname = user.getSurname();
		this.phoneNumber = user.getPhoneNumber();
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

	@Override
	public List<UserRole> getAuthorities() {
		return roles;
	}

	@Override
	public String getUsername() {
		return email;
	}

	public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	/*USERS
	 * Admin
	 * 	email: admin@gmail.com
	 * 	pass: admin
	 * Agent:
	 * 	email: agent@gmail.com
	 * 	pass: agent
	 */

}

