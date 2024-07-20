package com.aingenious.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aingenious.model.UserDetails;
import com.aingenious.service.UserService;
import com.aingenious.util.JwtTokenUtil;

@RestController
@RequestMapping("/api/auth")
public class UserController {
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private UserService userDetailsService;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
		UserDetails userDetails = userDetailsService.getUserDetailsByUsernameAndPassword(username, password);
		if (userDetails != null) {
			String token = jwtTokenUtil.generateToken(username);
			return new ResponseEntity<>("JWT " + token, HttpStatus.OK);
		}
		return new ResponseEntity<>("User doesn't exist.",HttpStatus.UNAUTHORIZED);

	}
}

