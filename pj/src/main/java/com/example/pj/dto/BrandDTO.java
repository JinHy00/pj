package com.example.pj.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BrandDTO {
	private int brandCode;
    private String brandName;
    private String email;
    private String phoneNum;
    private String address;
    private String brandInfo;
}
