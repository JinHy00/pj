package com.example.pj.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.pj.dto.NoticeDTO;

@Repository
public class NoticeDAOImpl implements NoticeDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<NoticeDTO> list(int start, int end, String search_option, String keyword) {
		Map<String, Object> map = new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList("notice.list", map);
	}

	@Override
	public void insert(NoticeDTO dto) {
		sqlSession.insert("notice.insert", dto);
		
	}

	@Override
	public NoticeDTO detail(int noticeCode) {
		increase_hit(noticeCode);
		return sqlSession.selectOne("notice.detail", noticeCode);
	}

	@Override
	public void increase_hit(int noticeCode) {
		sqlSession.update("notice.increase_hit", noticeCode);
	}

	@Override
	public void update(NoticeDTO dto) {
		sqlSession.update("notice.update", dto);
	}

	@Override
	public void delete(int noticeCode) {
		sqlSession.delete("notice.delete", noticeCode);
	}

	@Override
	public int count(String search_option, String keyword) {
		Map<String, Object> map = new HashMap<>();
		map.put("search_option", search_option);
		map.put("keyword", keyword);
		return sqlSession.selectOne("notice.count", map);
	}

	@Override
	public List<String> list_attach(int noticeCode) {
		return sqlSession.selectList("notice.list_attach", noticeCode);
	}

	@Override
	public void insert_attach(String file_name) {
		sqlSession.insert("notice.insert_attach", file_name);
	}

	@Override
	public void update_attach(String file_name, int noticeCode) {
		Map<String, Object> map = new HashMap<>();
		map.put("file_name", file_name);
		map.put("noticeCode", noticeCode);
		sqlSession.insert("notice.update_attach", map);
	}

	@Override
	public void delete_attach(String file_name) {
		sqlSession.delete("notice.delete_attach", file_name);
	}
}