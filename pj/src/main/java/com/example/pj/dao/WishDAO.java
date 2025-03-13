package com.example.pj.dao;

import java.util.List;
import java.util.Map;

import com.example.pj.dto.WishDTO;

public interface WishDAO {
	
	List<WishDTO> list(String userid);
	
	void insert(Map<String, Object> map);
	
	void delete(int wishCode, String userid);
}
