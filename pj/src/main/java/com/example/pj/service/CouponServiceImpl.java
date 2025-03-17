package com.example.pj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pj.dto.CouponDTO;
import com.example.pj.mapper.CouponMapper;

@Service
public class CouponServiceImpl implements CouponService {
   @Autowired
   CouponMapper couponMapper;
   
   @Override
   public List<CouponDTO> couponList() {
      return couponMapper.couponList();
   }

   @Override
   public int count(int couponCode) {
      return couponMapper.count(couponCode);
   }

   @Override
   public void downCount(int couponCode) {
      couponMapper.downCount(couponCode);

   }

   @Override
   public void insert(CouponDTO dto) {
      couponMapper.insert(dto);

   }

   @Override
   public void delete(int CouponCode) {
      couponMapper.delete(CouponCode);
   }
}
