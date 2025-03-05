package com.example.pj.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.pj.dto.FAQCategoryDTO;
import com.example.pj.dto.FAQDTO;

@Repository
public class FAQDAOImpl implements FAQDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<FAQDTO> list(String searchkey, String search) {
		Map<String, Object> map = new HashMap<>();
		map.put("searchkey", searchkey);
		map.put("search", search);
		return sqlSession.selectList("faq.list", map);
	}

	@Override
	public String insert(Map<String, Object> map) { 
		sqlSession.insert("faq.insert", map);	
		return "";
	}

	@Override
	public FAQDTO detail(int faqCode) {
		return sqlSession.selectOne("faq.detail", faqCode);
	}
	
	@Override
	public FAQDTO edit(int faqCode) {
		return sqlSession.selectOne("faq.edit", faqCode);
	}

	@Override
	public void update(Map<String, Object> map) {
		sqlSession.update("faq.update", map);
	}

	@Override
	public void delete(int faqCode) {
		sqlSession.delete("faq.delete", faqCode);
	}
	
	@Override
	public List<FAQCategoryDTO> category() {
		return sqlSession.selectList("faq.category");
	}
}