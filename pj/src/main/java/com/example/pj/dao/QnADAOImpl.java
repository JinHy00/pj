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
	public List<QnADTO> list(String searchkey, String search) {
		Map<String, Object> map = new HashMap<>();
		map.put("searchkey", searchkey);
		map.put("search", search);
		return sqlSession.selectList("qna.list", map);
	}
	
	@Override
	public List<QnADTO> my_list(String userid) {
		return sqlSession.selectList("qna.my_list", userid);
	}

	@Override
	public String insert(Map<String, Object> map) { 
		sqlSession.insert("qna.insert", map);	
		return "";
	}

	@Override
	public QnADTO detail(int qnaCode) {
		QnADTO result = sqlSession.selectOne("qna.detail", qnaCode);
		System.out.println("========userid============");
		System.out.println(result.getUserid());
		return result;
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
		return sqlSession.selectList("qna.category");
	}
	
	@Override
	public List<QnAReplyDTO> reply_list(int qnaCode) {
		return sqlSession.selectList("qna.reply_list", qnaCode);
	}
	
	@Override
	public String reply_write(Map<String, Object> map) {
		sqlSession.insert("qna.reply_write", map);	
		return "";
	}
	
	@Override
	public void reply_update(Map<String, Object> map) {
		sqlSession.update("qna.reply_update", map);
	}
}