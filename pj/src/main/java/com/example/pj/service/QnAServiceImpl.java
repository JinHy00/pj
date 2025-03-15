package com.example.pj.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pj.dao.QnADAO;
import com.example.pj.dto.QnADTO;
import com.example.pj.dto.QnAReplyDTO;
import com.example.pj.dto.QnACategoryDTO;

@Service
public class QnAServiceImpl implements QnAService {

    @Autowired
    QnADAO qnaDao;

    @Override
	public List<QnADTO> list(String searchkey, String search) {
		return qnaDao.list(searchkey, search);
	}
    
    @Override
    public List<QnADTO> my_list(String userid) {
    	return qnaDao.my_list(userid);
    }
	
	@Transactional
	@Override
	public String insert(Map<String, Object> map) {
		return qnaDao.insert(map);
	}
	
	@Override
	public QnADTO detail(int qnaCode) {
		return qnaDao.detail(qnaCode);
	}
	
	@Override
	public QnADTO edit(int qnaCode) {
		return qnaDao.edit(qnaCode);
	}
	
	@Transactional
	@Override
	public void update(Map<String, Object> map) {
		qnaDao.update(map);
	}
	
	@Override
	public void delete(int qnaCode) {
		qnaDao.delete(qnaCode);
	}
	
	@Override
	public String filename(int qnaCode) {
		return qnaDao.filename(qnaCode);
	}
	
	@Override
	public List<QnACategoryDTO> category() {
		return qnaDao.category();
	}
	
	@Override
	public List<QnAReplyDTO> reply_list(int qnaCode) {
		return qnaDao.reply_list(qnaCode);
	}
	
	@Override
	public String reply_write(Map<String, Object> map) {
		return qnaDao.reply_write(map);
	}
	
	@Transactional
	@Override
	public void reply_update(Map<String, Object> map) {
		qnaDao.reply_update(map);
	}
}
