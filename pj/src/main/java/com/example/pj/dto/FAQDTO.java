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
	public int getFaqCode() {
		return faqCode;
	}
	public void setFaqCode(int faqCode) {
		this.faqCode = faqCode;
	}
	public String getAdminid() {
		return adminid;
	}
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
	public String getFaqTitle() {
		return faqTitle;
	}
	public void setFaqTitle(String faqTitle) {
		this.faqTitle = faqTitle;
	}
	public String getFaqContent() {
		return faqContent;
	}
	public void setFaqContent(String faqContent) {
		this.faqContent = faqContent;
	}
	public int getF_categoryCode() {
		return f_categoryCode;
	}
	public void setF_categoryCode(int f_categoryCode) {
		this.f_categoryCode = f_categoryCode;
	}
	public String getF_categoryName() {
		return f_categoryName;
	}
	public void setF_categoryName(String f_categoryName) {
		this.f_categoryName = f_categoryName;
	}
}