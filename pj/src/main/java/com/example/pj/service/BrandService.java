package com.example.pj.service;

import java.util.List;

import com.example.pj.dto.BrandDTO;

public interface BrandService {
   // 전체 리스트
   List<BrandDTO> list();
   
   // 등록
   void insert(BrandDTO dto);
   
   // 정보
   BrandDTO detail(int brandCode);
   
   // 수정
   void update(BrandDTO dto);
   
   // 삭제
   void delete(int brandCode);
}