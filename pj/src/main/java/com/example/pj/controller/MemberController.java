package com.example.pj.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.pj.dto.MemberDTO;
import com.example.pj.service.MemberService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/member/*")
public class MemberController {
    
    @Autowired
    MemberService memberService;
    
    
    @PostMapping("join")
    public void join(MemberDTO dto) {
        memberService.insertMember(dto);
    }
    
    // String 으로 값 전달 안되면 Map 으로 변경 ( 변경 )
    @PostMapping("id_check")
    public Map<String, Object> id_check(@RequestParam(name = "userid") String userid) {
        int result = memberService.id_check(userid);
        Map<String, Object> map = new HashMap<>();
        if(result == 0) {
           map.put("message", "able");
        } else {
         map.put("message", "disable");
      }
        return map;
    }
    
    // session 을 map 에 저장해야 할 수도
    @PostMapping("login")
    public Map<String, Object> login(@RequestParam(name = "userid") String userid, @RequestParam(name = "passwd") String passwd) {
        String name = memberService.loginMember(userid, passwd);
        System.out.println("name"+ name);
        Map<String, Object> map = new HashMap<>();
        // 로그인 성공
        if(name != null) {
           map.put("name", name);
           map.put("message", "success");
        } else {
           map.put("message", "error");
      }
        return map;
    }
    
    // 세션으로 저장해놓은 값
    // 나중에 null 처리 해야할 수도
//    @GetMapping("login_info")
//    public ResponseEntity<Map<String, Object>> login_info(HttpSession session) {
//       String userid = (String) session.getAttribute("userid");
//       System.out.println("userid"+ userid);
//       String name = (String) session.getAttribute("name");
//       Map<String, Object> map = new HashMap<>();
//       map.put("userid", userid);
//       map.put("name", name);
//        return ResponseEntity.ok(map);
//    }
    
//    @RequestMapping(value = "logout", method = {RequestMethod.POST, RequestMethod.GET})
//    public void logout(HttpSession session) {
//       session.invalidate();
//    }
//    
    
    @GetMapping("detail")
    public MemberDTO detail(@RequestParam(name = "userid") String userid) {
       MemberDTO dto = memberService.detail(userid);
       return dto;
    }
    
    @PostMapping("update")
    public void update(MemberDTO dto) {
       memberService.update(dto);
    }
    
    @PostMapping("passwd_check")
    public Map<String, Object> passwd_check(@RequestParam(name = "passwd") String passwd, @RequestParam(name = "userid") String userid) {
        Map<String, Object> map = new HashMap<>();
        int result = memberService.passwd_check(userid, passwd);
        // 비밀번호 불일치
        if(result == 0) {
           map.put("message", "error");
        } else {
         map.put("message", "success");
      }
        return map;
    }
    
    // 경로에 userid 넣을 지 
    @RequestMapping(value = "delete", method = {RequestMethod.POST, RequestMethod.GET})
    public void delete(@RequestParam(name = "userid") String userid) {
       memberService.delete(userid);
    }
}
