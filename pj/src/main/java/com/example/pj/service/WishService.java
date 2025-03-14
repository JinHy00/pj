package com.example.pj.service;

import java.util.List;
import java.util.Map;

import com.example.pj.dto.WishDTO;

public interface WishService {

   List<WishDTO> list(String userid);
   
   void insert(Map<String, Object> map);
   
   void delete(int wishCode);
   
   boolean count(int productCode, String userid);
}