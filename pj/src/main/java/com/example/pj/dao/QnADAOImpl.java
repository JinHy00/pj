package com.example.pj.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.pj.dto.QnACategoryDTO;
import com.example.pj.dto.QnADTO;
import com.example.pj.dto.QnAReplyDTO;

@Repository
public class QnADAOImpl implements QnADAO {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<QnADTO> qna_list(String searchkey, String search) {
		Map<String, Object> map = new HashMap<>();
		map.put("searchkey", searchkey);
		map.put("search", search);
		return sqlSession.selectList("qna.qna_list", map);
	}
	
	@Override
	public List<QnAReplyDTO> reply_list(String searchkey, String search) {
		Map<String, Object> map = new HashMap<>();
		map.put("searchkey", searchkey);
		map.put("search", search);
		return sqlSession.selectList("qna.reply_list", map);
	}
	
	@Override
	public String qna_insert(Map<String, Object> map) {
		sqlSession.insert("qna.qna_insert", map);
		return "";	
	}
	
	@Override
	public String reply_insert(Map<String, Object> map) {
		sqlSession.insert("qna.reply_insert", map);
		return "";	
	}

	@Override
	public QnADTO qna_detail(int qnaCode) {
		return sqlSession.selectOne("qna.qna_detail", qnaCode);
	}
	
	@Override
	public QnAReplyDTO reply_detail(int qnaReplyCode) {
		return sqlSession.selectOne("qna.reply_detail", qnaReplyCode);
	}

	@Override
	public QnADTO qna_edit(int qnaCode) {
		return sqlSession.selectOne("qna.qna_edit", qnaCode);
	}
	
	@Override
	public QnAReplyDTO reply_edit(int qnaReplyCode) {
		return sqlSession.selectOne("qna.reply_edit", qnaReplyCode);
	}

	@Override
	public void qna_update(Map<String, Object> map) {
		sqlSession.update("qna.qna_update", map);
	}
	
	@Override
	public void reply_update(Map<String, Object> map) {
		sqlSession.update("qna.reply_update", map);
	}

	@Override
	public void qna_delete(int qnaCode) {
		sqlSession.delete("qna.qna_delete", qnaCode);
	}
	
	@Override
	public void reply_delete(int qnaReplyCode) {
		sqlSession.delete("qna.reply_delete", qnaReplyCode);
	}

	@Override
	public String filename(int qnaCode) {
		return sqlSession.selectOne("qna.filename", qnaCode);
	}

	@Override
	public List<QnACategoryDTO> category() {
		return sqlSession.selectList("qna.category");
	}
}