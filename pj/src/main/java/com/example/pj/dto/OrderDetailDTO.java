package com.example.pj.dto;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.ToString;

@Getter
@Service
@ToString
public class OrderDetailDTO {
	private String productCode;
    private String productName;
    private int price;
    private int amount;
    private int money;
}
