package com.example.pj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.pj.dto.CouponDTO;

@Mapper
public interface CouponMapper {
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
	
	// 수정은 따로 안만들고 그냥 삭제하도록
	
	// 다운로드 받으면 다운 받지 못하도록 리액트에서 하세여
}
