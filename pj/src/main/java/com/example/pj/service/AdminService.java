package com.example.pj.service;


public interface AdminService {
   // 로그인
   String loginAdmin(String adminid, String passwd);

   // 비밀번호 확인
   int passwdCheck(String adminid, String passwd);
}

