package com.example.pj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.pj.dto.MemberDTO;
import com.example.pj.service.MemberService;

@RestController
@RequestMapping("/api/member")
public class MemberController {
    
    @Autowired
    private MemberService memberService;

    @PostMapping("/register")
    public boolean register(@RequestBody MemberDTO member) {
        return memberService.registerMember(member);
    }

    @PostMapping("/login")
    public MemberDTO login(@RequestBody MemberDTO member) {
        return memberService.login(member.getUserid(), member.getPasswd());
    }
}
