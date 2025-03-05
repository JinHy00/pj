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
    
    // String 으로 값 전달 안되면 Map 으로 변경
    @PostMapping("id_check")
    public String id_check(@RequestParam(name = "userid") String userid) {
        int result = memberService.id_check(userid);
        if(result == 0) {
        	return "사용 가능한 아이디입니다."; 
        } else {
			return "이미 존재하는 아이디입니다.";
		}
    }
    
    // session 을 map 에 저장해야 할 수도
    @PostMapping("login")
    public Map<String, Object> login(@RequestParam(name = "userid") String userid, @RequestParam(name = "passwd") String passwd, HttpSession session) {
        String name = memberService.loginMember(userid, passwd);
        Map<String, Object> map = new HashMap<>();
        // 로그인 성공
        if(name != null) {
        	session.setAttribute("userid", userid);
        	session.setAttribute("name", name);
        	return map;
        } else {
        	map.put("msg", "아이디 또는 비밀번호가 틀렸습니다.");
			return map;
		}
        
    }
    
    // 세션으로 저장해놓은 값
    // 나중에 null 처리 해야할 수도
    @GetMapping("login_info")
    public ResponseEntity<Map<String, Object>> login_info(HttpSession session) {
    	String userid = (String) session.getAttribute("userid");
    	String name = (String) session.getAttribute("name");
    	Map<String, Object> map = new HashMap<>();
    	map.put("userid", userid);
    	map.put("name", name);
        return ResponseEntity.ok(map);
    }
    
    @GetMapping("logout")
    public void logout(HttpSession session) {
    	session.invalidate();
    }
    
    @GetMapping("detail")
    public MemberDTO detail(HttpSession session) {
    	String userid = (String) session.getAttribute("userid");
    	MemberDTO dto = memberService.detail(userid);
    	return dto;
    }
    
    @PostMapping("update")
    public void update(MemberDTO dto) {
    	memberService.update(dto);
    }
    
    @PostMapping("passwd_check")
    public Map<String, Object> passwd_check(@RequestParam(name = "passwd") String passwd, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        String userid = (String) session.getAttribute("userid");
        int result = memberService.passwd_check(userid, passwd);
        if(result == 0) {
        	map.put("msg", "비밀번호를 확인해주세요.");
        } else {
			map.put("msg", "비밀번호 일치");
		}
        return map;
    }
    
    // 경로에 userid 넣을 지 session 으로 할지
    @GetMapping("delete")
    public void delete(HttpSession session) {
    	String userid = (String) session.getAttribute("userid");
    	memberService.delete(userid);
    }
}
