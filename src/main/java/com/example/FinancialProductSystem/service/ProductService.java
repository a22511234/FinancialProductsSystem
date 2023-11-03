package com.example.FinancialProductSystem.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FinancialProductSystem.entity.Product;
import com.example.FinancialProductSystem.repository.ProductRepo;
import jakarta.transaction.Transactional;

@Service
public class ProductService {
	
	@Autowired
	ProductRepo productRepo;

	@Transactional
	public String addProduct(Product product) {
		productRepo.saveAndFlush(product);
		return "Scuuess";
	}

	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Transactional
	public String updateProduct(Product product) {
		if (productRepo.existsById(product.getProductID())) {
			Product updateProduct = productRepo.getReferenceById(product.getProductID());
			updateProduct.setProductName(product.getProductName());
			updateProduct.setPrice(product.getPrice());
			updateProduct.setFeeRate(product.getFeeRate());
			productRepo.save(updateProduct);
		} else {
			System.out.println("Product ID do not Exist");
		}
		return "Scuuess";
	}

	@Transactional
	public String deleteProduct(int productID) {
		if (productRepo.existsById(productID)) {
			productRepo.deleteById(productID);
		}
		return "Scuuess";
	}

}
