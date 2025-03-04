package com.example.pj.dto;

import org.springframework.web.multipart.MultipartFile;

import groovy.transform.ToString;
import lombok.Getter;
import lombok.Setter;

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
}
