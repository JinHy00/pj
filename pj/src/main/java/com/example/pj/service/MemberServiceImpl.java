package com.example.pj.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pj.dto.MemberDTO;
import com.example.pj.mapper.MemberMapper;



@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public List<MemberDTO> list() {
		return memberMapper.list();
	}

	@Override
	public void insertMember(MemberDTO dto) {
		memberMapper.insertMember(dto);

	}

	@Override
	public String loginMember(String userid, String passwd) {
		Map<String, Object> map = new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		return memberMapper.loginMember(map);
	}

	@Override
	public MemberDTO detail(String userid) {
		return memberMapper.detail(userid);
	}

	@Override
	public void delete(String userid) {
		memberMapper.delete(userid);

	}

	@Override
	public void update(MemberDTO dto) {
		memberMapper.update(dto);
	}

	@Override
	public int id_check(String userid) {
		return memberMapper.id_check(userid);
	}

	@Override
	public int passwd_check(String userid, String passwd) {
		Map<String, Object> map = new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		return memberMapper.passwd_check(map);
	}
	
	@Override
	public void use_point(String userid) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void save_point(String userid) {
		// TODO Auto-generated method stub
		
	}

}
