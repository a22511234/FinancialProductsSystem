package com.example.FinancialProductSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FinancialProductSystem.entity.LikeList;
import com.example.FinancialProductSystem.entity.LikeListShowView;
import com.example.FinancialProductSystem.entity.Product;
import com.example.FinancialProductSystem.entity.Users;
import com.example.FinancialProductSystem.repository.LikeListRepo;
import com.example.FinancialProductSystem.repository.ProductRepo;
import com.example.FinancialProductSystem.repository.UserRepo;
import jakarta.transaction.Transactional;

@Service
public class LikeListService {

	@Autowired
	LikeListRepo likeListRepo;
	@Autowired
	UserRepo userRepo;
	@Autowired
	ProductRepo productRepo;

	@Transactional
	public String addtolikeList(int productID, String userId, int oredername) {
		Users user = userRepo.getReferenceById(userId);
		Product product = productRepo.getReferenceById(productID);
		double fee = product.getPrice() * product.getFeeRate() / 100;
		double amount = product.getPrice() * oredername + fee;
		LikeList add = new LikeList(userId, productID, oredername, user.getAccount(), fee, amount);
		likeListRepo.saveAndFlush(add);
		return "Scuuess";
	}

	public List<LikeList> getAllLikeList() {
		return likeListRepo.findAll();
	}
	public LikeList getLikeListbyId(int id) {
		return likeListRepo.findById(id).get();
	}
	@Transactional
	public String deleteLikeList(int ListsID) {
		if (likeListRepo.existsById(ListsID)) {
			likeListRepo.deleteById(ListsID);
		}
		return "Scuuess";
	}


	public String updatelikeList(LikeListShowView likeList) {
		if (likeListRepo.existsById(likeList.getLikeListbyID())) {
			LikeList updateLikeList = likeListRepo.getReferenceById(likeList.getLikeListbyID());
			Product product = productRepo.getReferenceById(likeList.getProductID());
			updateLikeList.setOrderName(likeList.getProductCount());
			double fee = product.getPrice() * product.getFeeRate() / 100;
			double amount = product.getPrice() * likeList.getProductCount() + fee;
			updateLikeList.setTotalFee(fee);
			updateLikeList.setTotalAmount(amount);
			likeListRepo.save(updateLikeList);
		} else {
			System.out.println("Product ID do not Exist");
		}
		return "Scuuess";
	}

}
