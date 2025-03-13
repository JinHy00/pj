package com.example.pj.service;

import java.util.List;

import com.example.pj.dto.CouponDTO;

public interface CouponService {
	//쿠폰 리스트
	List<CouponDTO> couponList();
	
	// 쿠폰 수량
	int count(int couponCode);
	
	// 쿠폰 다운로드 => 수량 감소
	void downCount(int couponCode);
	
	// 관리자
	// 쿠폰 등록
	void insert(CouponDTO dto);
	
	// 쿠폰 삭제
	void delete(int CouponCode);
}
