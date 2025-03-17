package com.example.pj.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CouponDTO {
   private int couponCode;
   private String couponName;
   private int couponPrice;
   private int couponCount;
   private String couponImage;
   private MultipartFile couponImgURL;
   
}