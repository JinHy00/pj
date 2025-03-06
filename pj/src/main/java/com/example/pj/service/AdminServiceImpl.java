package com.example.pj.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pj.mapper.AdminMapper;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminMapper adminMapper;
		
	@Override
	public String loginAdmin(String adminid, String passwd) {
		String name = adminMapper.loginAdmin(adminid, passwd);
		return name;
	}

	@Override
	public int passwdCheck(String adminid, String passwd) {
		int result = adminMapper.passwdCheck(adminid, passwd);
		return result;
	}

}
