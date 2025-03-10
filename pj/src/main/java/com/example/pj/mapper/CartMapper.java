package com.example.pj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.pj.dto.CartDTO;

@Mapper
public interface CartMapper {
	void addCart(CartDTO cartDTO);  // 장바구니에 추가
    List<CartDTO> getCartList(String userId);  // 장바구니 목록 조회
    void removeFromCart(int cartCode);  // 장바구니에서 삭제
    void removeAllFromCart(String userId);  // 장바구니 전체 삭제
    void updateCartAmount(CartDTO cartDTO);  // 장바구니 수량 수정
    int getTotalPrice(String userId);  // 장바구니 총 금액 계산
}
