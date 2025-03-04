package com.example.pj.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QnADTO {
	private int qnaCode;
	private String qnaTitle;
	private String qnaContent;
	private String userid;
	private String adminid;
	private String qnaDate;
	private String qnaFile;
	private String q_categoryName;
	private String q_categoryCode;
}