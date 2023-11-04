package com.example.FinancialProductSystem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FinancialProductSystem.entity.Users;
import com.example.FinancialProductSystem.service.UserService;

@RestController
@RequestMapping("/userapi")
@CrossOrigin("http://localhost:5173/")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<Users> getAllUsers() {
		List<Users> temps = userService.getAllUsers();
		return temps;
	}
	@GetMapping("{userID}")
	public Users getoneProducts(@PathVariable("userID")String userID) {
		return userService.getoneUser(userID);
	}
	@PostMapping("/save")
	public String createUser(@RequestBody Users user) {
		String status = userService.addUser(user);
		return status;
	}

	@PutMapping("/update")
	public String updatevendor(@RequestBody Users user) {
		String status = userService.updateUser(user);
		return status;
	}

	@DeleteMapping("{userID}")
	public String deletevendor(String userID) {
		String status = userService.deleteUser(userID);
		return status;
	}
}
