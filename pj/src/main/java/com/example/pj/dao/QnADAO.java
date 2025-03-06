package com.example.pj.dao;

import java.util.List;
import java.util.Map;

import com.example.pj.dto.QnACategoryDTO;
import com.example.pj.dto.QnADTO;
import com.example.pj.dto.QnAReplyDTO;

public interface QnADAO {
	List<QnADTO> qna_list(String searchkey, String search);
	
	List<QnAReplyDTO> reply_list(String searchkey, String search);
	
	String qna_insert(Map<String, Object> map);
	
	String reply_insert(Map<String, Object> map);
	
	QnADTO qna_detail(int qnaCode);
	
	QnAReplyDTO reply_detail(int qnaReplyCode);
	
	QnADTO qna_edit(int qnaCode);
	
	QnAReplyDTO reply_edit(int qnaReplyCode);
	
	void qna_update(Map<String, Object> map);
	
	void reply_update(Map<String, Object> map);
	
	void qna_delete(int qnaCode);
	
	void reply_delete(int qnaReplyCode);
	
	String filename(int qnaCode);
	
	List<QnACategoryDTO> category();
}
