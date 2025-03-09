package com.example.pj.service;

import java.util.List;
import java.util.Map;

import com.example.pj.dto.NoticeCategoryDTO;
import com.example.pj.dto.NoticeDTO;
import com.example.pj.dto.QnACategoryDTO;
import com.example.pj.dto.QnADTO;
import com.example.pj.dto.QnAReplyDTO;

public interface QnAService {
	
	List<QnADTO> list(String searchkey, String search);
	
	String insert(Map<String, Object> map);
	
	QnADTO detail(int qnaCode);

	QnADTO edit(int qnaCode);
	
	void update(Map<String, Object> map);
	
	void delete(int qnaCode);
	
	String filename(int qnaCode);
	
	List<QnACategoryDTO> category();
	
	QnAReplyDTO reply_list(int q_replyCode);
	
	String reply_write(Map<String, Object> map);
}