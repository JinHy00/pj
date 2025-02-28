package com.example.pj.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pj.dao.NoticeDAO;
import com.example.pj.dto.NoticeCategoryDTO;
import com.example.pj.dto.NoticeDTO;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	NoticeDAO noticeDao;
	
	@Override
	public List<NoticeDTO> list(String searchkey, String search) {
		return noticeDao.list(searchkey, search);
	}
	
	@Transactional
	@Override
	public String insert(Map<String, Object> map) {
		return noticeDao.insert(map);
	}
	
	@Override
	public Map<String, Object> detail(int noticeCode) {
		return noticeDao.detail(noticeCode);
	}
	
	@Transactional
	@Override
	public String update(Map<String, Object> map) {
		return noticeDao.update(map);
	}
	
	@Override
	public void delete(int noticeCode) {
		noticeDao.delete(noticeCode);
	}
	
	@Override
	public String filename(int noticeCode) {
		return noticeDao.filename(noticeCode);
	}
	
	@Override
	public List<NoticeCategoryDTO> category() {
		return noticeDao.category();
	}
}