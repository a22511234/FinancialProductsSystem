package com.example.FinancialProductSystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FinancialProductSystem.entity.LikeList;
import com.example.FinancialProductSystem.entity.Product;
import com.example.FinancialProductSystem.repository.LikeListRepo;
import com.example.FinancialProductSystem.repository.ProductRepo;
import jakarta.transaction.Transactional;

@Service
public class ProductService {

	@Autowired
	ProductRepo productRepo;
	@Autowired
	LikeListService likeListService;

	@Transactional
	public String addProduct(Product product) {
		productRepo.saveAndFlush(product);
		return "Scuuess";
	}

	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	public Product getoneProduct(int id) {
		return productRepo.findById(id).get();
	}

	@Transactional
	public String updateProduct(Product product) {
		if (productRepo.existsById(product.getProductID())) {
			Product updateProduct = productRepo.getReferenceById(product.getProductID());
			updateProduct.setProductName(product.getProductName());
			updateProduct.setPrice(product.getPrice());
			updateProduct.setFeeRate(product.getFeeRate());
			productRepo.save(updateProduct);
			
			List<LikeList> likeList = likeListService.getAllLikeList();
			for (int i = 0; i < likeList.size(); i++) {
				if(likeList.get(i).getProductID()==product.getProductID()) {
					likeListService.updateprice(likeList.get(i).getListsID(),product.getProductID());
				}
			}
			
		} else {
			System.out.println("Product ID do not Exist");
		}
		return "Scuuess";
	}

	@Transactional
	public String deleteProduct(int productID) {
		if (productRepo.existsById(productID)) {
			productRepo.deleteById(productID);
			List<LikeList> likeList = likeListService.getAllLikeList();
			for (int i = 0; i < likeList.size(); i++) {
				if(likeList.get(i).getProductID()==productID) {
					likeListService.deleteLikeList(likeList.get(i).getListsID());
				}
			}
		}
		return "Scuuess";
	}

}
