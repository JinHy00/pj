package com.example.pj.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.pj.dto.QnACategoryDTO;
import com.example.pj.dto.QnADTO;

@Repository
public class QnADAOImpl implements QnADAO {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<QnADTO> list(String searchkey, String search) {
		Map<String, Object> map = new HashMap<>();
		map.put("searchkey", searchkey);
		map.put("search", search);
		return sqlSession.selectList("qna.list", map);
	}
	
	@Override
	public String insert(Map<String, Object> map) {
		sqlSession.insert("qna.insert", map);
		return "";	
	}

	@Override
	public QnADTO detail(int qnaCode) {
		return sqlSession.selectOne("qna.detail", qnaCode);
	}

	@Override
	public QnADTO edit(int qnaCode) {
		return sqlSession.selectOne("qna.edit", qnaCode);
	}

	@Override
	public void update(Map<String, Object> map) {
		sqlSession.update("qna.update", map);
	}

	@Override
	public void delete(int qnaCode) {
		sqlSession.delete("qna.delete", qnaCode);
	}

	@Override
	public String filename(int qnaCode) {
		return sqlSession.selectOne("qna.filename", qnaCode);
	}

	@Override
	public List<QnACategoryDTO> category() {
		return sqlSession.selectList("qna.categoty");
	}
}