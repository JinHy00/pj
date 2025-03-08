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
	public int getQnaCode() {
		return qnaCode;
	}
	public void setQnaCode(int qnaCode) {
		this.qnaCode = qnaCode;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	public String getQnaDate() {
		return qnaDate;
	}
	public void setQnaDate(String qnaDate) {
		this.qnaDate = qnaDate;
	}
	public String getQnaFile() {
		return qnaFile;
	}
	public void setQnaFile(String qnaFile) {
		this.qnaFile = qnaFile;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getQ_categoryCode() {
		return q_categoryCode;
	}
	public void setQ_categoryCode(int q_categoryCode) {
		this.q_categoryCode = q_categoryCode;
	}
	public String getQ_categoryName() {
		return q_categoryName;
	}
	public void setQ_categoryName(String q_categoryName) {
		this.q_categoryName = q_categoryName;
	}
	public MultipartFile getImg() {
		return img;
	}
	public void setImg(MultipartFile img) {
		this.img = img;
	}
	public QnAReplyDTO getQnaReply() {
		return qnaReply;
	}
	public void setQnaReply(QnAReplyDTO qnaReply) {
		this.qnaReply = qnaReply;
	}
}