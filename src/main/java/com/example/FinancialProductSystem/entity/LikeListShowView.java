package com.example.FinancialProductSystem.entity;


public class LikeListShowView {

	private int index;
	private int likeListbyID;
	private int ProductID;
	private String ProductName;
	private int ProductCount;
	private String Account;
	private double TotalFee;
	private double TotalAmount;



	public LikeListShowView(int index, int likeListbyID, int ProductID,String productName, int productCount, String account,
			double totalFee, double totalAmount) {
		super();
		this.index = index;
		this.likeListbyID = likeListbyID;
		this.ProductID=ProductID;
		ProductName = productName;
		ProductCount = productCount;
		Account = account;
		TotalFee = totalFee;
		TotalAmount = totalAmount;
	}

	public int getLikeListbyID() {
		return likeListbyID;
	}

	public void setLikeListbyID(int likeListbyID) {
		this.likeListbyID = likeListbyID;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public int getProductCount() {
		return ProductCount;
	}

	public void setProductCount(int productCount) {
		ProductCount = productCount;
	}

	public String getAccount() {
		return Account;
	}

	public void setAccount(String account) {
		Account = account;
	}

	public double getTotalFee() {
		return TotalFee;
	}

	public void setTotalFee(double totalFee) {
		TotalFee = totalFee;
	}

	public double getTotalAmount() {
		return TotalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		TotalAmount = totalAmount;
	}

	public int getProductID() {
		return ProductID;
	}

	public void setProductID(int productID) {
		ProductID = productID;
	}
	
}
