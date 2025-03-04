package com.example.pj.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.example.pj.dto.ProductDTO;

// MAPPER => DAO 대신 사용, DAO 구현하는 DAOImpl 생성 안하고 mybatis 랑 연결

@Mapper
public interface ProductMapper {
      // 상품리스트, 파라미터로 두개 이상 받으면 새 DTO 또는 map 사용
      List<ProductDTO> list(Map<String, Object> map);
      
      // 브랜드 상품리스트
      List<ProductDTO> brand_list(Map<String, Object> map);
      
      // 카테고리(성별) 상품리스트
      List<ProductDTO> gender_list(Map<String, Object> map);
      
      // 상품정보
      ProductDTO detail(int productCode);
      
      // 상품등록
      void insert(ProductDTO dto);
      
      // 상품수정
      void update(ProductDTO dto);
      
      // 상품삭제
      void delete(int ProductCode);
}

