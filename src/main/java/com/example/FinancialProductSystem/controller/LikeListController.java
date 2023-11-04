package com.example.FinancialProductSystem.controller;

import java.util.ArrayList;
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

import com.example.FinancialProductSystem.entity.LikeList;
import com.example.FinancialProductSystem.entity.LikeListShowView;
import com.example.FinancialProductSystem.entity.Product;
import com.example.FinancialProductSystem.entity.Users;
import com.example.FinancialProductSystem.service.LikeListService;
import com.example.FinancialProductSystem.service.ProductService;
import com.example.FinancialProductSystem.service.UserService;

@RestController
@RequestMapping("/likelistapi")
@CrossOrigin("http://localhost:5173/")
public class LikeListController {

	@Autowired
	LikeListService likeListService;
	@Autowired
	ProductService productService;
	@Autowired
	UserService userService;

	
	@PostMapping("{userID}/{productID}")
	public String addLikeList(@PathVariable("userID")String userID,@PathVariable("productID")int productID) {
		Users user = userService.getoneUser(userID);
		String status = likeListService.addtolikeList(productID, user.getUserID(), 1);
		return status;
	}
	
	@GetMapping("/likelist/{userID}")
	public List<LikeListShowView> getUserLikelist(@PathVariable("userID") String userID) {
		List<LikeList> temps = likeListService.getAllLikeList();
		List<LikeListShowView> likeListShowViews = new ArrayList<LikeListShowView>();

		for (int i = 0; i < temps.size(); i++) {
			int index=i+1;
			int likeListbyID = temps.get(i).getListsID();
			String ProductName=productService.getoneProduct(temps.get(i).getProductID()).getProductName();
			int ProductCount=temps.get(i).getOrderName();
			String Account=userService.getoneUser(userID).getAccount();
			double TotalFee=temps.get(i).getTotalFee();
			double TotalAmount=temps.get(i).getTotalAmount();
			LikeListShowView likelistshowview=new LikeListShowView(index,likeListbyID,temps.get(i).getProductID(),ProductName,ProductCount,Account,TotalFee,TotalAmount);
			likeListShowViews.add(likelistshowview);
		}
		return likeListShowViews;
	}
	@GetMapping("/likelist/{userID}/{LikeListbyID}")
	public LikeListShowView getLikeListbyID(@PathVariable("userID") String userID,@PathVariable("LikeListbyID") int LikeListbyID) {
		LikeList temps = likeListService.getLikeListbyId(LikeListbyID);
		int likeListbyID=temps.getListsID();
		int productID=temps.getProductID();
		String ProductName=productService.getoneProduct(temps.getProductID()).getProductName();
		int ProductCount=temps.getOrderName();
		String Account=userService.getoneUser(userID).getAccount();
		double TotalFee=temps.getTotalFee();
		double TotalAmount=temps.getTotalAmount();
		LikeListShowView likelistshowview=new LikeListShowView(0,likeListbyID,productID,ProductName,ProductCount,Account,TotalFee,TotalAmount);
		return likelistshowview;
		
	}

	@PutMapping("/update")
	public String updateLikelist(@RequestBody LikeListShowView likeList) {
		
		String status = likeListService.updatelikeList(likeList);
		return status;
	}

	@DeleteMapping("{likelistID}")
	public String deleteLikeList(@PathVariable("likelistID") int likelistID) {
		String status = likeListService.deleteLikeList(likelistID);
		return status;
	}
}
