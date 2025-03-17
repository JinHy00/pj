package com.example.pj.dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDTO {
   private int orderCode;
   private String userid;
   private int couponid;
   private int productCode;
   private int orderAdmount;
   private String recipient;
   private String rec_phoneNum;
   private String zipCode;
   private String mainAddress;
   private String detailAddress;
   private int usePoint;
   private int orderState;
   private Date orderDate;
   
   // join column
   private int price;
   private String productName;
   private String mainImage;
   
   private String name;
   private String phoneNum;
   

   private List<OrderItemDTO> orderOne; // 주문상품
   
   // private int orderPrice; // orderOne에서 money의 합
   // private int totalMoney; => orderPrice - usePoint - couponPrice + delivery
}

