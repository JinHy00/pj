package com.example.pj.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.pj.dto.CouponDTO;
import com.example.pj.dto.CouponDetailDTO;
import com.example.pj.service.CouponDetailService;
import com.example.pj.service.CouponService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/coupon/*")
public class CouponController {
   @Autowired
   CouponService couponService;
   
   @Autowired
   CouponDetailService couponDetailService;
   
   
   @PostMapping("insert")
   public Map<String, Object> insert(CouponDTO dto, @RequestParam(name = "couponImgURL") MultipartFile couponImgURL, HttpServletRequest request) {
      Map<String, Object> map = new HashMap<>();
      String couponImage = "";
      if(couponImgURL != null) {
         // couponImage = UUID.randomUUID().toString() + "_" + couponImgURL.getOriginalFilename();
         couponImage = couponImgURL.getOriginalFilename();
         try {
            ServletContext application = request.getSession().getServletContext();
            String path = application.getRealPath("/images/coupon/");
//            File directory = new File(path);
//            if(!directory.exists()) {
//               directory.mkdirs();
//            }
            couponImgURL.transferTo(new File(path + couponImage));
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      
      dto.setCouponImage(couponImage);
      try {
         couponService.insert(dto);
         map.put("message", "success");
      } catch (Exception e) {
         map.put("message", "error");
         e.printStackTrace();
      }
      return map;
   }
   
   // userid, couponCode 를 경로로 보낼지 파라미터로 보낼지
   @Transactional
   @PostMapping("download")
   public Map<String, Object> downloadCoupon( @RequestParam(name = "couponCode") int couponCode, @RequestParam(name = "userid") String userid) {
      int count = couponService.count(couponCode);
      int downCount = couponDetailService.count(userid, couponCode);
      Map<String, Object> map = new HashMap<>();
      // 이미 다운 받은 쿠폰이라면
      if(downCount > 0) {
         map.put("message", "disable");
      } else {
         // 쿠폰 수량 있으면
         // 쿠폰 수량 - 1, 쿠폰 다운로드
         if(count > 0) {
            couponDetailService.downloadCoupon(couponCode, userid);
            couponService.downCount(couponCode);   
            map.put("message", "success");
         } else {
            map.put("message", "error");
         }
      }
      return map;
   }
   
   @GetMapping("couponList")
   public List<CouponDTO> couponList() {
      List<CouponDTO> list = couponService.couponList();
      return list;
   }
   
   @RequestMapping(value = "downloadList/{userid}", method = {RequestMethod.POST, RequestMethod.GET})
   public List<CouponDetailDTO> downloadList(@PathVariable(name = "userid") String userid) {
      List<CouponDetailDTO> downList = couponDetailService.downloadList(userid);
      System.out.println("== down == ");
      System.out.println("list: " + downList);
      System.out.println("userid: " + userid);
      return downList;
   }
   
   @RequestMapping(value = "unusedList/{userid}", method = {RequestMethod.POST, RequestMethod.GET})
   public List<CouponDetailDTO> unusedList(@PathVariable(name = "userid") String userid) {
      List<CouponDetailDTO> list = couponDetailService.unusedList(userid);
      System.out.println("== down == ");
      System.out.println("list: " + list);
      System.out.println("userid: " + userid);
      return list;
   }
   
   @RequestMapping(value = "useList/{userid}", method = {RequestMethod.POST, RequestMethod.GET})
   public List<CouponDetailDTO> useList(@PathVariable(name = "userid") String userid) {
      List<CouponDetailDTO> list = couponDetailService.useList(userid);
      System.out.println("== down == ");
      System.out.println("list: " + list);
      System.out.println("userid: " + userid);
      return list;
   }
   
   // 쿠폰 디테일도 삭제
   // 이미지 경로도 삭제 시켜야 함
   @Transactional
   @RequestMapping(value = "delete/{couponCode}", method = {RequestMethod.POST, RequestMethod.GET})
   public void delete(@PathVariable(name = "couponCode") int couponCode) {
      System.out.println("==delete ==");
      couponService.delete(couponCode);
   }
   
   // 결제 취소 등에 따라 달라질 수 도 
   @PostMapping("useCoupon")
   public void useCoupon(@RequestParam(name = "couponid") int couponid) {
      couponDetailService.useCoupon(couponid);
   }
   
   
}
