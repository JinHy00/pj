package com.example.pj.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pj.dao.WishDAO;
import com.example.pj.dto.WishDTO;

@Service
public class WishServiceImpl implements WishService {
	
	@Autowired
	WishDAO wishDao;
	
	@Override
	public List<WishDTO> list(String userid) {
		return wishDao.list(userid);
	}
	
	@Override
	public int count(String userid, int productCode) {
		return wishDao.count(userid, productCode);
	}
	
	@Transactional
	@Override
	public String insert(Map<String, Object> map) {
		return wishDao.insert(map);
	}
		
	@Override
	public void delete(int wishCode, String userid) {
		wishDao.delete(wishCode, userid);
	}
}