package com.example.pj.service;

import java.util.List;
import java.util.Map;

import com.example.pj.dto.FAQCategoryDTO;
import com.example.pj.dto.FAQDTO;

public interface FAQService {
	
	List<FAQDTO> list(String searchkey, String search);
	
	String insert(Map<String, Object> map);
	
	FAQDTO detail(int faqCode);

	FAQDTO edit(int faqCode);
	
	void update(Map<String, Object> map);
	
	void delete(int faqCode);
		
	List<FAQCategoryDTO> category();
}