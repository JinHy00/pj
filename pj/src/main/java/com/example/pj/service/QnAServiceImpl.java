package com.example.pj.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pj.dao.QnADAO;
import com.example.pj.dto.QnACategoryDTO;
import com.example.pj.dto.QnADTO;

@Service
public class QnAServiceImpl implements QnAService {
	
	@Autowired
	QnADAO qnaDao;
	
	@Override
	public List<QnADTO> list(String searchkey, String search) {
		return qnaDao.qna_list(searchkey, search);
	}
	
	@Transactional
	@Override
	public String qna_insert(Map<String, Object> map) {
		return qnaDao.qna_insert(map);
	}
	
	@Transactional
	@Override
	public String reply_insert(Map<String, Object> map) {
		return qnaDao.reply_insert(map);
	}
	
	@Override
	public QnADTO detail(int qnaCode) {
		return qnaDao.qna_detail(qnaCode);
	}
	
	@Override
	public QnADTO edit(int qnaCode) {
		return qnaDao.qna_edit(qnaCode);
	}
	
	@Transactional
	@Override
	public void qna_update(Map<String, Object> map) {
		qnaDao.qna_update(map);
	}
	
	@Transactional
	@Override
	public void reply_update(Map<String, Object> map) {
		qnaDao.reply_update(map);
	}
	
	@Override
	public void delete(int qnaCode) {
		qnaDao.qna_delete(qnaCode);
	}
	
	@Override
	public String filename(int qnaCode) {
		return qnaDao.filename(qnaCode);
	}
	
	@Override
	public List<QnACategoryDTO> category() {
		return qnaDao.category();
	}
}