package com.example.FinancialProductSystem.entity;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "likelists")
public class LikeList {
	
	@Id
	@Column(name="ListsID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ListsID;
	
	@Column(name="UserID")
	private String UserID;
	
	@Column(name="ProductID")
	private int ProductID;
	
	@Column(name="OrderName")
	private int OrderName;
	
	@Column(name="Account")
	private String Account;
	
	@Column(name="TotalFee")
	private double TotalFee;
	
	@Column(name="TotalAmount")
	private double TotalAmount;
	public LikeList(){}
	public LikeList(String userID, int productID, int orderName, String account, double totalFee, double totalAmount) {
		super();
		UserID = userID;
		ProductID = productID;
		OrderName = orderName;
		Account = account;
		TotalFee = totalFee;
		TotalAmount = totalAmount;
	}

	public int getListsID() {
		return ListsID;
	}

	public void setListsID(int listsID) {
		ListsID = listsID;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public int getProductID() {
		return ProductID;
	}

	public void setProductID(int productID) {
		ProductID = productID;
	}

	public int getOrderName() {
		return OrderName;
	}

	public void setOrderName(int orderName) {
		OrderName = orderName;
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
	
	


	

	
}
