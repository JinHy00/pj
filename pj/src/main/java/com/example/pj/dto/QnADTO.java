package com.example.pj.dto;

import org.springframework.web.multipart.MultipartFile;

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
	private String qnaDate;
	private String qnaFile;
	private String userid;
	private int q_categoryCode;
	private String q_categoryName;
	private MultipartFile img;
	private QnAReplyDTO qnaReply;
}