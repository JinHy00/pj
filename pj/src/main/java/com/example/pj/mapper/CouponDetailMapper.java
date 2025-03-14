package com.example.pj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.pj.dto.CouponDetailDTO;

@Mapper
public interface CouponDetailMapper {
   // 쿠폰 다운로드
   void downloadCoupon(@Param("couponCode") int couponCode, @Param("userid") String userid);
   
   // 쿠폰 전체 리스트 ( 이걸로 되면 밑에 두개 삭제 )
   List<CouponDetailDTO> downloadList(String userid);
   
   // 다운 받은 쿠폰 리스트 ( 미사용 )
   List<CouponDetailDTO> unusedList(String userid);
   

   // 다운 받은 쿠폰 리스트 ( 사용 )
   List<CouponDetailDTO> useList(String userid);
   
   
   // 쿠폰 사용 ( 0 -> 1)
   void useCoupon(int couponid);
   
   // 쿠폰 취소 (1-> 0) 할지 말지
   
   // 전체 리스트의 쿠폰 삭제 될 경우 같이 삭제
   void downCouponDelete(int couponCode);
   
   // 이미 다운 받은 쿠폰
   int count(@Param("userid") String userid, @Param("couponCode") int couponCode);
}
