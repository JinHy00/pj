package com.example.pj.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WishDTO {
	private int wishCode;
	private String userid;
	private int productCode;
	private String productName;
	private String mainImage;
	private int price;
	
	public int getWishCode() {
		return wishCode;
	}
	public void setWishCode(int wishCode) {
		this.wishCode = wishCode;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getMainImage() {
		return mainImage;
	}
	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}