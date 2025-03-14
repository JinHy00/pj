package com.example.pj.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartDTO {
    private int cartCode;
    private String userId;
    private int productCode;
    private int cartAmount;
    private int capacity;
    private int finalPrice;  
    private String productName;
    private String mainImage;
    private int price;  
}
