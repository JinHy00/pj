package com.example.pj.service;

import com.example.pj.dto.OrderDTO;
import com.example.pj.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    // 특정 회원의 주문 목록 조회
    @Override
    public List<OrderDTO> getOrderListByUserId(String userId) {
        return orderMapper.getOrderListByUserId(userId);
    }

    // 주문 상세 조회
    @Override
    public OrderDTO getOrderDetail(int orderCode) {
        return orderMapper.getOrderDetail(orderCode);
    }

    // 주문 생성
    @Override
    public void createOrder(OrderDTO order) {
        orderMapper.createOrder(order);
    }

    // 주문 상태 변경
    @Override
    public void updateOrderState(int orderCode, int orderState) {
        orderMapper.updateOrderState(orderCode, orderState);
    }
}
