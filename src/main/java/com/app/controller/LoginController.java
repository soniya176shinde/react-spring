package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginDto;
import com.app.dto.ResponseDTO;
import com.app.service.ILoginService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class LoginController 
{
	
	@Autowired
	private ILoginService userService;

	
	
	
	
	@PostMapping("/register")
	public ResponseDTO<?> addUserDetails(@RequestBody LoginDto userDTO) {
		System.out.println("in add user details " + userDTO);
		userDTO.setStatus("offline");
		return new ResponseDTO<>(HttpStatus.OK, "User details added", userService.addUserDetails(userDTO));
	}
	
	@PostMapping("/login")
	public ResponseDTO<?> authenticateUser(@RequestBody LoginDto request) {
		System.out.println("in auth " + request);
		String message="Successful";
		return new ResponseDTO<>(HttpStatus.OK, message,userService.authenticateUser(request.getEmail(), request.getPassword()));

	}

}
