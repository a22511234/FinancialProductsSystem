package com.example.FinancialProductSystem.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FinancialProductSystem.entity.Product;
import com.example.FinancialProductSystem.entity.Users;
import com.example.FinancialProductSystem.service.ProductService;
import com.example.FinancialProductSystem.service.UserService;

@RestController
@RequestMapping("/productapi")
@CrossOrigin("http://localhost:8081/")
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/product")
	public List<Product> getAllProducts() {
		List<Product> temps = productService.getAllProducts();
		return temps;
	}

	@PostMapping("/save")
	public String createUser(@RequestBody Product product) {
		String status = productService.addProduct(product);
		return status;
	}

	@PutMapping("/update")
	public String updatevendor(@RequestBody Product product) {
		String status = productService.updateProduct(product);
		return status;
	}

	@DeleteMapping("{productID}")
	public String deletevendor(int productID) {
		String status = productService.deleteProduct(productID);
		return status;
	}
}
