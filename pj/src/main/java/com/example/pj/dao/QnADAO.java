package com.example.pj.dao;

import java.util.List;
import java.util.Map;

import com.example.pj.dto.QnACategoryDTO;
import com.example.pj.dto.QnADTO;
import com.example.pj.dto.QnAReplyDTO;

public interface QnADAO {
	List<QnADTO> list(String searchkey, String search);
	
	List<QnADTO> my_list(String userid);
	
	String insert(Map<String, Object> map);
	
	QnADTO detail(int qnaCode);

	QnADTO edit(int qnaCode);
	
	void update(Map<String, Object> map);
	
	void delete(int qnaCode);
	
	String filename(int qnaCode);
	
	List<QnACategoryDTO> category();
	
	List<QnAReplyDTO> reply_list(int qnaCode);
	
	String reply_write(Map<String, Object> map);
	
	void reply_update(Map<String, Object> map);
}
