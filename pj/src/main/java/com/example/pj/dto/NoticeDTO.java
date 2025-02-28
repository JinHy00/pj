package com.example.pj.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

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
	private Date noticeDate;
	private String filename;
	private MultipartFile img;
}