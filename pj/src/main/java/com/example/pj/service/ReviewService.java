package com.example.pj.service;

import java.util.List;
import java.util.Map;

import com.example.pj.dto.ReviewDTO;

public interface ReviewService {

	List<ReviewDTO> list(int productCode);
	
	String insert(Map<String, Object> map);
	
	void update(Map<String, Object> map);
	
	void delete(int reviewCode);
	
	ReviewDTO detail(int reviewCode);
	
	ReviewDTO edit(int reviewCode);
	
	String filename(int reviewCode);
	
	List<ReviewDTO> my_review(String userid);
}
