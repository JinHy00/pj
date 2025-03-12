package com.example.pj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pj.dto.OrderDTO;

@Service
public interface OrderService {
    List<OrderDTO> getOrderList(String userId); // 주문 목록 가져오기
    OrderDTO getOrderDetail(int orderCode); // 주문 상세 정보 가져오기
    void createOrder(OrderDTO order); // 주문 생성
    void updateOrderStatus(int orderCode, String status); // 주문 상태 변경
    void cancelOrder(int orderCode, String cancelReason); // 주문 취소
}
