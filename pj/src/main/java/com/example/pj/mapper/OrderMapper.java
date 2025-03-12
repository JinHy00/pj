package com.example.pj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.pj.dto.OrderDTO;

@Mapper
public interface OrderMapper {

List<OrderDTO> getOrderList(String userId); // 주문 목록 가져오기
    OrderDTO getOrderDetail(int orderCode); // 주문 상세 정보 가져오기
    void createOrder(OrderDTO order); // 주문 생성
    void updateOrderStatus(int orderCode, String status); // 주문 상태 변경
    void cancelOrder(int orderCode, String cancelReason); // 주문 취소

}