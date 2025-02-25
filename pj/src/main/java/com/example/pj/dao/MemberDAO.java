package com.example.pj.dao;

import java.util.List;

import com.example.pj.dto.MemberDTO;

public interface MemberDAO {
	List<MemberDTO> list();
	
	void insert(MemberDTO dto);
	
	MemberDTO detail(String userid);
	
	void delete(String userid);
	
	void update(MemberDTO dto);
	
	boolean check_passwd(String userid, String passwd);
}
