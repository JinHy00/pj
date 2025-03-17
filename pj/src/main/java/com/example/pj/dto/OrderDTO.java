package com.example.pj.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class OrderDTO {
    private int orderCode;
    private int productCode;
    private String userId;
    private Integer couponId;
    private String recipient;
    private String recPhoneNum;
    private String zipCode;
    private String mainAddress;
    private String detailAddress;
    private Integer usePoint;
    private int orderState;
    private Date orderDate;
    private String productName;
    private int price;
    private String mainImage;
}
