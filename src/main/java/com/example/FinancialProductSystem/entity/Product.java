package com.example.FinancialProductSystem.entity;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
	
	@Id
	@Column(name="ProductID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ProductID;
	@Column(name="ProductName")
	private String ProductName;
	@Column(name="Price")
	private double Price;
	@Column(name="FeeRate")
	private double FeeRate;
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public double getFeeRate() {
		return FeeRate;
	}
	public void setFeeRate(double feeRate) {
		FeeRate = feeRate;
	}
	

	
}
