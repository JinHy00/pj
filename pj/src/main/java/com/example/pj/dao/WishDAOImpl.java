package com.example.pj.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.pj.dto.WishDTO;

@Repository
public class WishDAOImpl implements WishDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<WishDTO> list(String userid) {
		return sqlSession.selectList("wish.list", userid);
	}
	
	@Override
	public void insert(Map<String, Object> map) {
		sqlSession.insert("wish.insert", map);
	}
	
	@Override
	public void delete(int wishCode) {
		sqlSession.delete("wish.delete", wishCode);
	}
	
	@Override
	public int count(int productCode, String userid) { 
		Map<String, Object> map = new HashMap<>();
		map.put("productCode", productCode);
		map.put("userid", userid);
		return sqlSession.selectOne("wish.count", map);
	}
}