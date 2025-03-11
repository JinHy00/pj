package com.example.pj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.pj.dto.OrderDTO;
import com.example.pj.dto.OrderDetailDTO;

@Mapper
public interface OrderMapper {

    // 주문 목록 조회
    List<OrderDTO> getOrderList(String userId);

    // 주문 상세 조회
    OrderDTO getOrderDetail(int orderCode);

    // 주문 생성    
    void createOrder(OrderDTO orderDTO);

    // 주문 취소
    void cancelOrder(int orderCode, String cancelReason);

    // 주문 상태 변경
    void changeOrderStatus(int orderCode, String status);

    // 주문 상세 정보 조회
    List<OrderDetailDTO> getOrderDetails(int orderCode);
}