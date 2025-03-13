package com.example.pj.service;

import java.util.List;

import com.example.pj.dto.CouponDetailDTO;

public interface CouponDetailService {
	// 쿠폰 다운로드
	void downloadCoupon(int couponCode, String userid);
	
	// 쿠폰 전체 리스트 ( 이걸로 되면 밑에 두개 삭제 )
	List<CouponDetailDTO> downloadList(String userid);
	
	// 다운 받은 쿠폰 리스트 ( 미사용 )
	List<CouponDetailDTO> unusedList(String userid);
	

	// 다운 받은 쿠폰 리스트 ( 사용 )
	List<CouponDetailDTO> useList(String userid);
	
	
	// 쿠폰 사용 ( 0 -> 1)
	void useCoupon(int couponid);
	
	// 전체 쿠폰 삭제 될 경우 같이 삭제
		void downCouponDelete(int couponCode);
}
