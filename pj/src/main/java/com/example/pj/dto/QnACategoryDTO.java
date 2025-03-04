package com.example.pj.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QnACategoryDTO {
	
	@JsonProperty("q_categoryCode")
	private int q_categoryCode;
	
	@JsonProperty("q_categoryName")
	private String q_categoryName;
}