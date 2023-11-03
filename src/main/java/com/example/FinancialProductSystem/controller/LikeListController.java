package com.example.FinancialProductSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FinancialProductSystem.entity.LikeList;
import com.example.FinancialProductSystem.service.LikeListService;

@RestController
@RequestMapping("/likelistapi")
@CrossOrigin("http://localhost:8081/")
public class LikeListController {
	
	@Autowired
	LikeListService likeListService;
	
	@GetMapping("/likelist/{userID}")
	public List<LikeList> getUserLikelist(String userID) {
		List<LikeList> temps = likeListService.getUserLikelist(userID);
		return temps;
	}
	@PutMapping("/update")
	public String updateLikelist(@RequestBody LikeList likeList) {
		String status = likeListService.updateUser(likeList);
		return status;
	}
	@DeleteMapping("{likelistID}")
	public String deletevendor(int likelistID) {
		String status = likeListService.deleteLikeList(likelistID);
		return status;
	}
}
