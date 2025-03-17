package com.example.pj.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CouponDetailDTO {
   private int couponid;
   private int couponState;
   private int couponCode;
   private String userid;
   
   // join column
   private String couponName;
   private int couponPrice;
   private String couponImage;
}
