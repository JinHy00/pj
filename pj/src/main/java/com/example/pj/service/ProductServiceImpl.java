package com.example.pj.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pj.dto.ProductDTO;
import com.example.pj.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
   @Autowired
   ProductMapper productMapper;
   
   
   @Override
   public List<ProductDTO> list(String searchkey, String keyword) {
      Map<String, Object> map = new HashMap<>();
      map.put("searchkey", searchkey);
      map.put("keyword", keyword);
      return productMapper.list(map);
   }
   
   @Override
   public List<ProductDTO> brand_list(int brandCode, String keyword) {
      Map<String, Object> map = new HashMap<>();
      map.put("keyword", keyword);
      map.put("brandCode", brandCode);
      return productMapper.brand_list(map);
   }
   
   @Override
   public List<ProductDTO> gender_list(String gender,  String searchkey, String keyword) {
      Map<String, Object> map = new HashMap<>();
      map.put("searchkey", searchkey);
      map.put("keyword", keyword);
      map.put("gender", gender);
      return productMapper.gender_list(map);
   }

   @Override
   public ProductDTO detail(int productCode) {
      return productMapper.detail(productCode);
   }

   @Override
   public void insert(ProductDTO dto) {
      productMapper.insert(dto);
      
      
   }

   @Override
   public void update(ProductDTO dto) {
      productMapper.update(dto);

   }

   @Override
   public void delete(int ProductCode) {
      productMapper.delete(ProductCode);
   }

}
