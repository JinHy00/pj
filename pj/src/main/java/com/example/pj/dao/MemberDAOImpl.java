package com.example.pj.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.pj.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {
    @Autowired
    SqlSession sqlSession;

    @Override
    public List<MemberDTO> list() {
        return sqlSession.selectList("member.list");
    }

    @Override
    public void insert(MemberDTO dto) {
        sqlSession.insert("member.insert", dto);
    }

    @Override
    public MemberDTO detail(String userid) {
        return sqlSession.selectOne("member.detail", userid);
    }

    @Override
    public void delete(String userid) {
        sqlSession.delete("member.delete", userid);
    }

    @Override
    public void update(MemberDTO dto) {
        sqlSession.update("member.update", dto);
    }

    @Override
    public int checkPasswd(String userid, String passwd) { // ✅ 최적화
        Map<String, Object> map = new HashMap<>();
        map.put("userid", userid);
        map.put("passwd", passwd);
        return sqlSession.selectOne("member.check_passwd", map);
    }
}
