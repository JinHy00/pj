package com.example.pj.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pj.dao.ReviewDAO;
import com.example.pj.dto.ReviewDTO;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	ReviewDAO reviewDao;

	@Override
	public List<ReviewDTO> list(int productCode) {
		return reviewDao.list(productCode);
	}

	@Override
	public String insert(Map<String, Object> map) {
		return reviewDao.insert(map);
	}

	@Override
	public void update(Map<String, Object> map) {
		reviewDao.update(map);
	}

	@Override
	public void delete(int reviewCode) {
		reviewDao.delete(reviewCode);
		
	}

	@Override
	public ReviewDTO detail(int reviewCode) {
		return reviewDao.detail(reviewCode);
	}

	@Override
	public ReviewDTO edit(int reviewCode) {
		return reviewDao.edit(reviewCode);
	}

	@Override
	public String filename(int reviewCode) {
		return reviewDao.filename(reviewCode);
	}

	@Override
	public List<ReviewDTO> my_review(String userid) {
		return reviewDao.my_review(userid);
	}
}
