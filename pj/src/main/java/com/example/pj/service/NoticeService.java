package com.example.pj.service;

import java.util.List;
import java.util.Map;

import com.example.pj.dto.NoticeCategoryDTO;
import com.example.pj.dto.NoticeDTO;

public interface NoticeService {
	
	List<NoticeDTO> list(String searchkey, String search);
	
	String insert(Map<String, Object> map);
	
	NoticeDTO detail(int noticeCode);

	NoticeDTO edit(int noticeCode);
	
	String update(Map<String, Object> map);
	
	void delete(int noticeCode);
	
	String filename(int noticeCode);
	
	List<NoticeCategoryDTO> category();
}