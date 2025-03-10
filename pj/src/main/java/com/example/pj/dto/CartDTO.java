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
    private int selectedCapacity;
    private int cartAmount;
    private int finalPrice;
    private String productName;
    private String mainImage;
}
