package com.example.pj.service;



import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pj.mapper.AdminMapper;

@Service
public class AdminServiceImpl implements AdminService {
   @Autowired
   AdminMapper adminMapper;
      
   @Override
   public String loginAdmin(String adminid, String passwd) {
      Map<String, Object> map = new HashMap<>();
      map.put("adminid", adminid);
      map.put("passwd", passwd);
      String adminName = adminMapper.loginAdmin(map);
      return adminName;
   }

   @Override
   public int passwdCheck(String adminid, String passwd) {
      int result = adminMapper.passwdCheck(adminid, passwd);
      return result;
   }

}
