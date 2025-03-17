package com.example.pj.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.pj.dto.MemberDTO;

@Mapper
public interface MemberMapper {
   List<MemberDTO> list(); // 회원 리스트
   
    void insertMember(MemberDTO dto);  // 회원가입
    
    String loginMember(Map<String, Object> map); // 로그인
    
    MemberDTO detail(String userid); // 회원정보
    
    void delete(String userid); // 탈퇴
    
    void update(MemberDTO dto); // 정보 수정
    
    int id_check(String userid); // 아이디 중복 확인
    
    int passwd_check(Map<String, Object> map); // 비밀번호 확인
    
    // 포인트 사용
    void use_point(@Param(value = "userid") String userid, @Param(value = "usePoint") int usePoint);
    
    // 포인트 적립
    void save_point(@Param(value = "userid") String userid, @Param(value = "savePoint") int savePoint);
}
