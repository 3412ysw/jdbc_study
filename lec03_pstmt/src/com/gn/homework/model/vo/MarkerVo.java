package com.gn.homework.model.vo;


import java.time.LocalDateTime;

public class MarkerVo {
	
	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private LocalDateTime userRegdate;
	private LocalDateTime userModdate;
	private int productNo;
	private String productName;
	private String productPrice;
	private int productAmount;
	
	
	public MarkerVo() {}

	public MarkerVo(int userNo, String userId, String userPw, String userName, int productNo,
			String productName, String productPrice, int productAmount) {
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.productNo = productNo;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productAmount = productAmount;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public LocalDateTime getUserRegdate() {
		return userRegdate;
	}

	public void setUserRegdate(LocalDateTime userRegdate) {
		this.userRegdate = userRegdate;
	}

	public LocalDateTime getUserModdate() {
		return userModdate;
	}

	public void setUserModdate(LocalDateTime userModdate) {
		this.userModdate = userModdate;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(int productAmount) {
		this.productAmount = productAmount;
	}

	@Override
	public String toString() {
		return "[제품 번호 : " + productNo + ", 제품명 : " + productName + ", 가격 : "
				+ productPrice + ", 구매가능 개수 : " + productAmount + "]";
	}
	
	
}
