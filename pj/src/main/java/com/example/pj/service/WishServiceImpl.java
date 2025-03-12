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
	
//	@Transactional
//	@Override
//	public String insert(WishDTO dto) {
//		if (wishDao.count(dto.getUserid() , dto.getProductCode()) > 0) {
//			throw new RuntimeException("이미 찜한 상품입니다.");
//		}
//		return wishDao.insert(dto);
//	}
	
	
	@Override
	public void delete(int wishCode, String userid) {
		wishDao.delete(wishCode, userid);
	}
}