package com.example.pj.service;

import java.util.List;

import com.example.pj.dto.CartDTO;

public interface CartService {
	List<CartDTO> cart_money();
	
	void insert(CartDTO dto);
	
	List<CartDTO> list(String userid);
	
	void delete(int cart_id);
	
	void delete_all(String userid);
	
	int sum_money(String userid);
	
	void modify(CartDTO dto);
}
