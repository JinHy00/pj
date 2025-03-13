package com.example.pj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pj.dto.CouponDTO;
import com.example.pj.dto.CouponDetailDTO;
import com.example.pj.service.CouponDetailService;
import com.example.pj.service.CouponService;
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
	public void insert(CouponDTO dto) {
		couponService.insert(dto);
	}
	
	// userid, couponCode 를 경로로 보낼지 파라미터로 보낼지
	@PostMapping("download")
	public Map<String, Object> downloadCoupon(@RequestParam(name = "userid") String userid, @RequestParam(name = "couponCode") int couponCode) {
		int count = couponService.count(couponCode);
		Map<String, Object> map = new HashMap<>();
		// 쿠폰 수량 있으면
		// 쿠폰 수량 - 1, 쿠폰 다운로드
		if(count > 0) {
			couponDetailService.downloadCoupon(couponCode, userid);
			couponService.downCount(couponCode);	
			map.put("message", "success");
		} else {
			map.put("message", "error");
		}
		return map;
	}
	
	@GetMapping("couponList")
	public Map<String, Object> couponList(Map<String, Object> map) {
		List<CouponDTO> list = couponService.couponList();
		if(list != null) {
			map.put("list", list);
			map.put("message", "success");
		} else {
			map.put("message", "error");
		}
		return map;
	}
	
	@GetMapping("downloadList/{userid}")
	public Map<String, Object> downloadList(@PathVariable(name = "userid") String userid, Map<String, Object> map) {
		List<CouponDetailDTO> downList = couponDetailService.downloadList(userid);
		if(downList != null) {
			map.put("downList", downList);
			map.put("message", "success");
		} else {
			map.put("message", "error");
		}
		return map;
	}
	
	// 쿠폰 디테일도 삭제
	@Transactional
	@PostMapping("delete/{couponCode}")
	public void delete(@PathVariable(name = "couponCode") int couponCode, Map<String, Object> map) {
		couponService.delete(couponCode);
		couponDetailService.downCouponDelete(couponCode);
	}
	
	// 결제 취소 등에 따라 달라질 수 도 
	@PostMapping("useCoupon")
	public void useCoupon(@RequestParam(name = "couponid") int couponid) {
		couponDetailService.useCoupon(couponid);
	}
	
	
}
