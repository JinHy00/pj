package com.example.pj.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminService adminService;
		
	@Override
	public String loginAdmin(String userid, String passwd) {
		String name = adminService.loginAdmin(userid, passwd);
			return name;
	}

	@Override
	public int passwdCheck(String userid, String passwd) {
		int result = adminService.passwdCheck(userid, passwd);
		return result;
	}

}
