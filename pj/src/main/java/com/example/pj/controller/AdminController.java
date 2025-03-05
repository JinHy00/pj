package com.example.pj.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pj.service.AdminService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/admin/*")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@PostMapping("login")
	public Map<String, Object> login(@RequestParam(name = "adminid") String adminid, @RequestParam(name = "passwd") String passwd, HttpSession session) {
		String adminName = adminService.loginAdmin(adminid, passwd);
		Map<String, Object> map = new HashMap<>();
		if(adminName == null) {
			map.put("msg", "아이디 또는 비밀번호를 다시 확인해주세요");
		} else {
			map.put("adminid", adminid);
			map.put("adminName", adminName);
			session.setAttribute("adminid", adminid);
		}
		return map;
	}
	
	@PostMapping("passwd_check")
	public Map<String, Object> passwd_check(@RequestParam(name = "passwd") String passwd, HttpSession session) {
		String adminid = (String) session.getAttribute("adminid");
		int result = adminService.passwdCheck(adminid, passwd);
		Map<String, Object> map = new HashMap<>();
		if(result == 0) {
			map.put("msg", "비밀번호를 다시 확인해주세요");
		} else {
			map.put("msg", "비밀번호 일치");
		}
		return map;
	}
	
}
