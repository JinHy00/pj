package com.example.pj.dao;

import java.util.List;
import java.util.Map;

import com.example.pj.dto.ReviewDTO;

public interface ReviewDAO {
	
	List<ReviewDTO> list();
	
	String insert(Map<String, Object> map);
	
	void update(Map<String, Object> map);
}
