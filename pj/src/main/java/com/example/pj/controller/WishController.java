package com.example.pj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pj.dto.WishDTO;
import com.example.pj.service.WishService;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/wish")
public class WishController {
   
   @Autowired
   WishService wishService;
   
   @RequestMapping("/list")
   public List<WishDTO> list(@RequestParam(name = "userid") String userid) {
      return wishService.list(userid);
   }
   
   @PostMapping("/insert")
   public void insert(@RequestBody WishDTO dto, HttpServletResponse response) {
       try {
           int productCode = dto.getProductCode();
           String userid = dto.getUserid();
           boolean count = wishService.count(productCode, userid);
           
           if (count) {
              // 이미 찜 목록에 있는 상품일 경우 409 상태 코드 반환
               response.setStatus(HttpServletResponse.SC_CONFLICT);  
               return;
           }
           Map<String, Object> map = new HashMap<>();
           map.put("wishCode", dto.getWishCode());
           map.put("userid", dto.getUserid());
           map.put("productCode", dto.getProductCode());
           wishService.insert(map);
       } catch (Exception e) {
           e.printStackTrace();
       }
   }

   
   @GetMapping("/delete/{wishCode}")
   public void delete(@PathVariable(name = "wishCode") int wishCode) {
      wishService.delete(wishCode);
   }
}