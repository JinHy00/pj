package com.example.pj.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDTO {
    private int orderCode;
    private String userId;
    private int couponId;
    private int productCode;
    private int orderAmount;
    private String recipient;
    private String recPhoneNum;
    private String zipCode;
    private String mainAddress;
    private String detailAddress;
    private Date orderDate;
}
