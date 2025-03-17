package com.example.pj.service;

import com.example.pj.dto.OrderDTO;
import java.util.List;

public interface OrderService {
    List<OrderDTO> getOrderListByUserId(String userId); // 특정 회원의 주문 목록 조회
    OrderDTO getOrderDetail(int orderCode); // 주문 상세 조회
    void createOrder(OrderDTO order); // 주문 생성
    void updateOrderState(int orderCode, int orderState); // 주문 상태 변경
}
