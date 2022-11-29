package com.project.ecart.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ecart.RequestPojo.ApiResponse;
import com.project.ecart.model.User;
import com.project.ecart.service.UserServices.UserService;

@RestController
@RequestMapping("api/signup/")
public class SignUpController {
	@Autowired
	UserService userservice;
	
	@RequestMapping("user")
	public ResponseEntity<?> userLogin(@RequestBody HashMap<String,String> signupRequest) {
		System.out.println(signupRequest);
		try {
			User user = userservice.signUpUser(signupRequest);
			return  ResponseEntity.ok(user);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(),"Try with different mobile Number"));
		}
	}
	
	@GetMapping("getUser/{id}")
	public ResponseEntity<?> getUser(@PathVariable("id") Long id)
	{
		User user;
		try {
			user = userservice.getUserDetailById(id);
			return ResponseEntity.ok(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(),"Please check ID that you passed."));
		}
	}
	
//	@PatchMapping("updateUser")
//	public ResponseEntity<?> updateUser()
//	{
//		return null;
//	}
}
