package com.example.pj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.pj.dto.BrandDTO;

@Mapper
public interface BrandMapper {
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