package com.example.pj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pj.dao.MemberDAO;
import com.example.pj.dto.MemberDTO;

@Service
public class MemberService {
    @Autowired
    private MemberDAO memberDAO;

    public boolean registerMember(MemberDTO dto) {
        try {
            memberDAO.insertMember(dto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public MemberDTO login(String userid, String passwd) {
        return memberDAO.loginMember(userid, passwd);
    }
}
