package com.example.FinancialProductSystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FinancialProductSystem.entity.Users;
import com.example.FinancialProductSystem.repository.UserRepo;
import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;

	@Transactional
	public String addUser(Users user) {
		userRepo.saveAndFlush(user);
		return "Scuuess";
	}

	public List<Users> getAllUsers() {
		return userRepo.findAll();
	}

	@Transactional
	public String updateUser(Users user) {
		if (userRepo.existsById(user.getUserID())) {
			Users updateuser = userRepo.getReferenceById(user.getUserID());
			updateuser.setUserName(user.getUserName());
			updateuser.setEmail(user.getEmail());
			updateuser.setAccount(user.getAccount());
			userRepo.save(updateuser);
		} else {
			System.out.println("User ID do not Exist");
		}
		return "Scuuess";
	}

	@Transactional
	public String deleteUser(String userID) {
		if (userRepo.existsById(userID)) {
			userRepo.deleteById(userID);
		}
		return "Scuuess";
	}

}
