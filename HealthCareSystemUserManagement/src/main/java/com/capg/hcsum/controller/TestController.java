package com.capg.hcsum.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hcsum.entity.User;
import com.capg.hcsum.repository.IUserRepository;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@Autowired
	IUserRepository repository;
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String userAccess() {
		return "User Content.";
	}


	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board.";
	}
	
	@GetMapping("/admin/{username}")
	@PreAuthorize("hasRole('ADMIN')")
	public Optional<User> getUser(@PathVariable("username") String username) {
		return repository.findByUsername(username) ;
	}
}
