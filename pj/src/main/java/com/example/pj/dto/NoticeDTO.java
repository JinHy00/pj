package com.example.pj.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class NoticeDTO {
	private int noticeCode;
	private String adminid;
	private int n_categoryCode;
	private String noticeTitle;
	private String noticeContent;
	private Date noticeDate;
	private String n_categoryName;
	
	public String getN_categoryName() {
		return n_categoryName;
	}

	public void setN_categoryName(String n_categoryName) {
		this.n_categoryName = n_categoryName;
	}

	public int getNoticeCode() {
		return noticeCode;
	}

	public void setNoticeCode(int noticeCode) {
		this.noticeCode = noticeCode;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public int getN_categoryCode() {
		return n_categoryCode;
	}

	public void setN_categoryCode(int n_categoryCode) {
		this.n_categoryCode = n_categoryCode;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeFile() {
		return noticeFile;
	}

	public void setNoticeFile(String noticeFile) {
		this.noticeFile = noticeFile;
	}

	private String noticeFile;
	private MultipartFile img;
	
	public MultipartFile getImg() {
		return img;
	}
	
	public void setImg(MultipartFile img) {
		this.img = img;
	}
}