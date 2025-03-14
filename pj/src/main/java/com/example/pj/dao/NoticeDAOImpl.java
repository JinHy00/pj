package com.example.pj.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.pj.dto.NoticeCategoryDTO;
import com.example.pj.dto.NoticeDTO;

@Repository
public class NoticeDAOImpl implements NoticeDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<NoticeDTO> list(String searchkey, String search) {
		Map<String, Object> map = new HashMap<>();
		map.put("searchkey", searchkey);
		map.put("search", search);
		return sqlSession.selectList("notice.list", map);
	}

	@Override
	public String insert(Map<String, Object> map) { 
		sqlSession.insert("notice.insert", map);	
		return "";
	}

	@Override
	public NoticeDTO detail(int noticeCode) {
		return sqlSession.selectOne("notice.edit", noticeCode);
	}
	
	@Override
	public NoticeDTO edit(int noticeCode) {
		return sqlSession.selectOne("notice.detail", noticeCode);
	}

	@Override
	public void update(Map<String, Object> map) {
		sqlSession.update("notice.update", map);
	}

	@Override
	public void delete(int noticeCode) {
		sqlSession.delete("notice.delete", noticeCode);
	}

	@Override
	public String filename(int noticeCode) {
		return sqlSession.selectOne("notice.filename", noticeCode);
	}
	
	@Override
	public List<NoticeCategoryDTO> category() {
		return sqlSession.selectList("notice.category");
	}
}