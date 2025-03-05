package com.example.pj.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminService adminService;
		
	@Override
	public String loginAdmin(String adminid, String passwd) {
		String name = adminService.loginAdmin(adminid, passwd);
			return name;
	}

	@Override
	public int passwdCheck(String adminid, String passwd) {
		int result = adminService.passwdCheck(adminid, passwd);
		return result;
	}

}
