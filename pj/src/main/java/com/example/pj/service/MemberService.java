package com.example.pj.service;

import java.util.List;

import com.example.pj.dto.MemberDTO;

public interface MemberService {
	List<MemberDTO> list(String searchkey, String keyword); // 회원 리스트
	
    void insertMember(MemberDTO dto);  // 회원가입
    
    String loginMember(String userid, String passwd); // 로그인
    
    MemberDTO detail(String userid); // 회원정보
    
    void delete(String userid); // 탈퇴
    
    void update(MemberDTO dto); // 정보 수정
    
    int id_check(String userid); // 아이디 중복 확인
    
    int passwd_check(String userid, String passwd); // 비밀번호 확인
    
    // 포인트 사용
    void use_point(String userid);
    
    // 포인트 적립
    void save_point(String userid);
}
