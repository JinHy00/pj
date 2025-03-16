package com.example.pj.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.pj.dto.ReviewDTO;

@Repository
public class ReviewDAOImpl implements ReviewDAO {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<ReviewDTO> list(int productCode) {
		return sqlSession.selectList("review.list", productCode);
	}

	@Override
	public String insert(Map<String, Object> map) {
		sqlSession.insert("review.insert", map);
		return "";
	}

	@Override
	public void update(Map<String, Object> map) {
		sqlSession.update("review.update", map);
		
	}

	@Override
	public void delete(int reviewCode) {
		sqlSession.delete("review.delete", reviewCode);
	}

	@Override
	public ReviewDTO detail(int reviewCode) {
		return sqlSession.selectOne("review.detail", reviewCode);
	}

	@Override
	public ReviewDTO edit(int reviewCode) {
		return sqlSession.selectOne("review.edit", reviewCode);
	}

	@Override
	public String filename(int reviewCode) {
		return sqlSession.selectOne("review.filename", reviewCode);
	}

	@Override
	public List<ReviewDTO> my_review(String userid) {
		return sqlSession.selectList("review.my_review", userid);
	}
}
