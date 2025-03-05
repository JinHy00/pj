package com.example.pj.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pj.dao.FAQDAO;
import com.example.pj.dto.FAQCategoryDTO;
import com.example.pj.dto.FAQDTO;

@Service
public class FAQServiceImpl implements FAQService {
	
	@Autowired
	FAQDAO faqDao;
	
	@Override
	public List<FAQDTO> list(String searchkey, String search) {
		return faqDao.list(searchkey, search);
	}
	
	@Transactional
	@Override
	public String insert(Map<String, Object> map) {
		return faqDao.insert(map);
	}
	
	@Override
	public FAQDTO detail(int faqCode) {
		return faqDao.detail(faqCode);
	}
	
	@Override
	public FAQDTO edit(int faqCode) {
		return faqDao.edit(faqCode);
	}
	
	@Transactional
	@Override
	public void update(Map<String, Object> map) {
		faqDao.update(map);
	}
	
	@Override
	public void delete(int faqCode) {
		faqDao.delete(faqCode);
	}
	
	@Override
	public List<FAQCategoryDTO> category() {
		return faqDao.category();
	}
}