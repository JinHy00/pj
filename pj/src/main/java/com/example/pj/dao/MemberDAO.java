package com.example.pj.dao;

import java.util.List;
import com.example.pj.dto.MemberDTO;

public interface MemberDAO {
    List<MemberDTO> list();
    void insert(MemberDTO dto);
    MemberDTO detail(String userid);
    void delete(String userid);
    void update(MemberDTO dto);
    int checkPasswd(String userid, String passwd); // boolean -> int로 변경
}
