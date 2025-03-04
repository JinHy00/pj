package com.example.pj.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FAQCategoryDTO {
	
	@JsonProperty("f_categoryCode")
	private int f_categoryCode;
	
	@JsonProperty("f_categoryName")
	private String f_categoryName;
}