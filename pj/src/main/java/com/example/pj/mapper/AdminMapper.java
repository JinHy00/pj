package com.example.pj.mapper;


import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
   // 로그인
   String loginAdmin(Map<String, Object> map);

   // 비밀번호 확인
   int passwdCheck(String adminid, String passwd);
}
