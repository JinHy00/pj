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
    private int finalPrice;  // 최종 가격은 DB에서 계산됨
    private String productName;
    private String mainImage;
    private int price;  // 기본 가격
}
