package com.example.pj.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pj.dto.BrandDTO;
import com.example.pj.service.AdminService;
import com.example.pj.service.BrandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;




@RestController
@RequestMapping("/brand/*")
public class BrandController {
   @Autowired
   BrandService brandService;
   
   @Autowired
   AdminService adminService;
   
   // 브랜드 정보 null 인 경우 "정보없음"으로 처리 
   @PostMapping("insert")
   public void insert(BrandDTO dto, @RequestParam(name = "brandInfo") String brandInfo) {
      brandService.insert(dto);
   }
   
   @GetMapping("list")
   public List<BrandDTO> list() {
      return brandService.list();
   }
   
   @RequestMapping(value = "detail/{brandCode}", method= {RequestMethod.GET, RequestMethod.POST})
   public BrandDTO detail(@PathVariable(name = "brandCode") int brandCode) {
      System.out.println("detail");
      System.out.println("detailcode: "+brandCode);
      return brandService.detail(brandCode);
   }
   
   @PostMapping("update")
   public void update(BrandDTO dto) {
      System.out.println("update");
      brandService.update(dto);


   }
   
   @PostMapping("delete/{brandCode}")
   public void delete(@PathVariable(name = "brandCode") int brandCode) {
	   System.out.println("brnad");
	   System.out.println("brass"+brandCode);
      brandService.delete(brandCode);
   }
   
   
   
   
}
