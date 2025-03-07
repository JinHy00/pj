package com.example.pj.service;

import java.util.List;

import com.example.pj.dto.BrandDTO;
import com.example.pj.dto.ProductDTO;

public interface ProductService {
    // 상품리스트
    List<ProductDTO> list(String searchkey, String keyword);
    
    // 브랜드 상품리스트
    List<ProductDTO> brandList(int brandCode, String keyword);
    
    // 카테고리(성별) 상품리스트
    List<ProductDTO> genderList(String gender, String searchkey, String keyword);
    
    List<BrandDTO> getAllBrands();

    // 상품정보
    ProductDTO detail(int productCode);
    
    ProductDTO edit(int productCode);
    
    // 상품등록
    void insert(ProductDTO dto);
    
    // 상품수정
    void update(ProductDTO dto);
    
    // 상품삭제
    void delete(int productCode);
    
    // 추가 안할 수도 
    // 이미지1
    String mainImg(int productCode);
    
    // 이미지2
    String detailImg(int productCode); 
}
