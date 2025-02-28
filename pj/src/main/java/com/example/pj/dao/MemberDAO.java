package com.example.pj.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.pj.dto.MemberDTO;

@Mapper
public interface MemberDAO {
    void insertMember(MemberDTO dto);  // 회원가입
    MemberDTO loginMember(String userid, String passwd); // 로그인
}
