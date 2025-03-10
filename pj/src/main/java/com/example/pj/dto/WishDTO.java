package com.example.pj.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WishDTO {
	private int wishCode;
	private String userid;
	private int productCode;
	private String productName;
	private String mainImage;
	private int price;
}