package com.example.bezbednost.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import com.example.bezbednost.model.User;
import com.example.bezbednost.service.*;

@RestController
@RequestMapping(value="/auth")
public class AuthenticationController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value="/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> login(@RequestBody User user) {
		if (user.getEmail().contentEquals("admin@gmail.com") && user.getPassword().contentEquals("admin")) {
			return new ResponseEntity<String>("OKAY", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Wrong email/password.", HttpStatus.FORBIDDEN);
		}
	}
	
	
}

