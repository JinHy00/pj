package com.example.pj.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FAQDTO {
	private int faqCode;
	private String adminid;
	private int f_categoryCode;
	private String faqTitle;
	private String faqContent;
	private Date faqDate;
	private String f_categoryName;
	private String faqFile;
	private MultipartFile img;
}