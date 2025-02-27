package com.example.pj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.pj.dao.MemberDAO;
import com.example.pj.dto.MemberDTO;

@RestController
@RequestMapping("/api/member")
public class MemberController {
    @Autowired
    MemberDAO memberDao;

    // 회원 목록 조회
    @GetMapping("/list")
    public List<MemberDTO> memberList() {
        return memberDao.list();
    }

    // 회원가입
    @PostMapping("/join")
    public Map<String, Object> register(@RequestBody MemberDTO dto) {
        Map<String, Object> response = new HashMap<>();
        try {
            memberDao.insert(dto);
            response.put("message", "success");
        } catch (Exception e) {
            response.put("message", "error");
            response.put("detail", e.getMessage()); // 오류 메시지 반환
        }
        return response;
    }

    // 회원 상세 조회
    @GetMapping("/detail/{userid}")
    public MemberDTO memberDetail(@PathVariable String userid) {
        return memberDao.detail(userid);
    }

    // 회원 정보 수정
    @PutMapping("/update")
    public Map<String, Object> update(@RequestBody MemberDTO dto) {
        Map<String, Object> response = new HashMap<>();
        int result = memberDao.checkPasswd(dto.getUserid(), dto.getPasswd());

        if (result == 1) {
            memberDao.update(dto);
            response.put("message", "success");
        } else {
            response.put("message", "error");
            response.put("detail", "비밀번호가 일치하지 않습니다.");
        }
        return response;
    }

    // 회원 삭제 
    @DeleteMapping("/delete")
    public Map<String, Object> delete(@RequestBody Map<String, String> requestData) {
        Map<String, Object> response = new HashMap<>();
        String userid = requestData.get("userid");
        String passwd = requestData.get("passwd");

        int result = memberDao.checkPasswd(userid, passwd);

        if (result == 1) {
            memberDao.delete(userid);
            response.put("message", "success");
        } else {
            response.put("message", "error");
            response.put("detail", "비밀번호가 일치하지 않습니다.");
        }
        return response;
    }

    // 로그인
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> loginData) {
        Map<String, Object> response = new HashMap<>();
        String userid = loginData.get("userid");
        String passwd = loginData.get("passwd");

        int isValid = memberDao.checkPasswd(userid, passwd);
        if (isValid == 1) {
            MemberDTO member = memberDao.detail(userid);
            response.put("message", "success");
            response.put("userid", member.getUserid());
            response.put("name", member.getName());
            response.put("level", "user");
        } else {
            response.put("message", "error");
        }
        return response;
    }
}
