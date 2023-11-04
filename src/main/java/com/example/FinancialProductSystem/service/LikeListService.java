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
		List<LikeList> likelists = getAllLikeList();
		boolean exist = false;
		for (int i = 0; i < likelists.size(); i++) {
			if (likelists.get(i).getProductID() == productID) {
				exist = true;
				Product product = productRepo.getReferenceById(productID);
				LikeList likelist = likelists.get(i);
				likelist.setOrderName(likelist.getOrderName() + oredername);
				double fee = Math.round((product.getPrice() * product.getFeeRate() / 100) * likelist.getOrderName()*100.0)* 0.01d;
				double amount = Math.round((product.getPrice() * likelist.getOrderName() + fee)*100)* 0.01d;
				likelist.setTotalAmount(amount);
				likelist.setTotalFee(fee);
				likeListRepo.save(likelist);
			}
		}
		if (exist == false) {
			Users user = userRepo.getReferenceById(userId);
			Product product = productRepo.getReferenceById(productID);
			double fee = Math.round((product.getPrice() * product.getFeeRate() / 100) *100.0)* 0.01d;
			double amount = Math.round((product.getPrice() * oredername + fee)*100)* 0.01d;
			LikeList add = new LikeList(userId, productID, oredername, user.getAccount(), fee, amount);
			likeListRepo.saveAndFlush(add);
		}
		return "Scuess";
	}
	@Transactional
	public void updateprice(int likelistID,int productID) {
		LikeList list = likeListRepo.findById(likelistID).get();
		Product product = productRepo.getReferenceById(productID);
		double fee = Math.round((product.getPrice() * product.getFeeRate() / 100) * list.getOrderName()*100.0)* 0.01d;
		double amount = Math.round((product.getPrice() * list.getOrderName() + fee)*100)* 0.01d;
		list.setTotalAmount(amount);
		list.setTotalFee(fee);
		likeListRepo.save(list);
		
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
			double fee = Math.round((product.getPrice() * product.getFeeRate() / 100) * likeList.getProductCount()*100.0)* 0.01d;
			double amount = Math.round((product.getPrice() * likeList.getProductCount() + fee)*100)* 0.01d;
			updateLikeList.setTotalFee(fee);
			updateLikeList.setTotalAmount(amount);
			likeListRepo.save(updateLikeList);
		} else {
			System.out.println("Product ID do not Exist");
		}
		return "Scuuess";
	}

}
