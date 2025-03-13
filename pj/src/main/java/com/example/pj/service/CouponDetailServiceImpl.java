package com.example.pj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pj.dto.CouponDetailDTO;
import com.example.pj.mapper.CouponDetailMapper;

@Service
public class CouponDetailServiceImpl implements CouponDetailService {
	@Autowired
	CouponDetailMapper couponDetailMapper;
	
	@Override
	public void downloadCoupon(int couponCode, String userid) {
		couponDetailMapper.downloadCoupon(couponCode, userid);
	}
	
	@Override
	public List<CouponDetailDTO> downloadList(String userid) {
		return couponDetailMapper.downloadList(userid);
	}
	
	// 따로 안만들고 전체리스트에서 if 로 couponState로 구분 해도 될 듯 
	@Override
	public List<CouponDetailDTO> unusedList(String userid) {
		return couponDetailMapper.unusedList(userid);
	}

	@Override
	public List<CouponDetailDTO> useList(String userid) {
		return couponDetailMapper.useList(userid);
	}

	@Override
	public void useCoupon(int couponid) {
		couponDetailMapper.useCoupon(couponid);
	}
	
	@Override
	public void downCouponDelete(int couponCode) {
		couponDetailMapper.downCouponDelete(couponCode);
		
	}

}
