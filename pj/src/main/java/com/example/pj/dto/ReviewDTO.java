package com.example.pj.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewDTO {
	private int reviewCode;
	private String userid;
	private int orderCode;
	private int productCode;
	private String reviewContent;
	private String reviewFile;
	private String reviewDate;
	private int reviewScore;
}
