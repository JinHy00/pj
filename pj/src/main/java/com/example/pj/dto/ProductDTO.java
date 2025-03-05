package com.example.pj.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {
   private int productCode;
   private int brandCode;
   private String productName;
   private int price;
   private String description;
   private int amount;
   private String capacity;
   private String gender;
   private String mainImage;
   private String detailImage;
   
   // 파일 경로 잘 모르겠음..
   private MultipartFile mainImg;
   private MultipartFile detailImg;
   
   // join column
   private String brandName;
   
   public ProductDTO(int productCode, int brandCode, String productName, int price, String description, 
		           int amount, String capacity, String gender, String mainImage, String detailImage, 
		           String brandName) {
		this.productCode = productCode;
		this.brandCode = brandCode;
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.amount = amount;
		this.capacity = capacity;
		this.gender = gender;
		this.mainImage = mainImage;
		this.detailImage = detailImage;
		this.brandName = brandName;
	}

}
