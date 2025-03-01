package com.example.pj.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeCategoryDTO {
	
	@JsonProperty("n_categoryCode")
	private int n_categoryCode;
	
	@JsonProperty("n_categoryName")
	private String n_categoryName;
}