package com.example.pj.service;

import java.util.List;
import java.util.Map;

import com.example.pj.dto.WishDTO;

public interface WishService {

	List<WishDTO> list(String userid);
	
	int count(String userid, int productCode);
	
	// String insert(WishDTO dto);
	
	void delete(int wishCode, String userid);
}
