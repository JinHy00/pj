package com.example.pj.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QnAReplyDTO {
	private int q_replyCode;
	private int qnaCode;
	private String q_replyContent;
	private Date q_replyDate;
	private String adminid;
	public int getQ_replyCode() {
		return q_replyCode;
	}
	public void setQ_replyCode(int q_replyCode) {
		this.q_replyCode = q_replyCode;
	}
	public int getQnaCode() {
		return qnaCode;
	}
	public void setQnaCode(int qnaCode) {
		this.qnaCode = qnaCode;
	}
	public String getQ_replyContent() {
		return q_replyContent;
	}
	public void setQ_replyContent(String q_replyContent) {
		this.q_replyContent = q_replyContent;
	}
	public Date getQ_replyDate() {
		return q_replyDate;
	}
	public void setQ_replyDate(Date q_replyDate) {
		this.q_replyDate = q_replyDate;
	}
	public String getAdminid() {
		return adminid;
	}
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
}