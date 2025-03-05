package com.example.pj.service;

import java.util.List;
import java.util.Map;

import com.example.pj.dto.QnACategoryDTO;
import com.example.pj.dto.QnADTO;

public interface QnAService {
	
	List<QnADTO> list(String searchkey, String search);
	
	String qna_insert(Map<String, Object> map);
	
	String reply_insert(Map<String, Object> map);
	
	QnADTO detail(int qnaCode);

	QnADTO edit(int qnaCode);
	
	void qna_update(Map<String, Object> map);
	
	void reply_update(Map<String, Object> map);
	
	void delete(int qnaCode);
	
	String filename(int qnaCode);
	
	List<QnACategoryDTO> category();
}