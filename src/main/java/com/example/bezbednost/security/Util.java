package com.example.bezbednost.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.example.bezbednost.model.User;
import com.example.bezbednost.service.UserService;

@Component
public class Util {
	
	@Autowired
	private UserService userService;
	
	public User getCurrentUser() {
		String userEmail;
		Authentication currentUserAuth;
		currentUserAuth = SecurityContextHolder.getContext().getAuthentication();
		if(currentUserAuth != null) {
			userEmail = currentUserAuth.getName();
			if(userEmail != null) {
				if(userService != null) {
					return userService.findOne(userEmail);
				}
				System.out.println("USER SERVICE = NULL");
			}
			return null;
		}
		return null;
	}
}
