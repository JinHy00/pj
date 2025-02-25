package com.example.pj.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeDTO {
	private int noticeCode;
	private String adminid;
	private int n_categoryCode;
	private String noticeTitle;
	private String noticeContent;
	private String[] files;
	private int cnt;
	private int hit;
	private Date noticeDate;
}