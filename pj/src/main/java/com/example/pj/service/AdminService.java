package com.example.pj.service;

import java.util.Map;

public interface AdminService {
	// 로그인
	String loginAdmin(String userid, String passwd);

	// 비밀번호 확인
	int passwdCheck(String userid, String passwd);
}
