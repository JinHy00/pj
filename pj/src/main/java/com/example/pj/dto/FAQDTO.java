package com.example.pj.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FAQDTO {
	private int faqCode;
	private String adminid;
	private String faqTitle;
	private String faqContent;
	private int f_categoryCode;
	private String f_categoryName;
}