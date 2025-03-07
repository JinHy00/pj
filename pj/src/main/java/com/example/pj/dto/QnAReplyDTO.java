package com.example.pj.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QnAReplyDTO {
	private int qnaReplyCode;
	private int qnaCode;
	private String qnaReplyTitle;
	private String qnaReplyContent;
	private Date qnaReplyDate;
	private String adminid;
}
