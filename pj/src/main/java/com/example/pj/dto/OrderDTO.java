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
    private Date orderDate;
    private String recipient;
    private String rec_PhoneNum;
    private String zipCode;
    private String mainAddress;
    private String detailAddress;
    private String status;
    private String cancelReason;
}
