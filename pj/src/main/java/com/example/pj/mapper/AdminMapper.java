package com.example.pj.mapper;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
	// 로그인
	String loginAdmin(String adminid, String passwd);

	// 비밀번호 확인
	int passwdCheck(String adminid, String passwd);
}
