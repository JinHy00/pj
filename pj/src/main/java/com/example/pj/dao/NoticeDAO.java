package com.example.pj.dao;

import java.util.List;

import com.example.pj.dto.NoticeDTO;

public interface NoticeDAO {
	List<NoticeDTO> list(int start, int end, String search_option, String keyword);
	
	void insert(NoticeDTO dto);
	
	NoticeDTO detail(int noticeCode);
	
	void increase_hit(int noticeCode);
	
	void update(NoticeDTO dto);
	
	void delete(int noticeCode);
	
	int count(String search_option, String keyword);
	
	List<String> list_attach(int idx);
	
	void insert_attach(String file_name);
	
	void update_attach(String file_name, int noticeCode); 
	
	void delete_attach(String file_name);
}