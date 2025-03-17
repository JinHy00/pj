package com.example.pj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pj.dto.OrderDTO;
import com.example.pj.dto.OrderDetailDTO;
import com.example.pj.mapper.OrderMapper;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<OrderDTO> getOrderList(String userId) {
        return orderMapper.getOrderList(userId);
    }

    @Override
    public OrderDTO getOrderDetail(int orderCode) {
        return orderMapper.getOrderDetail(orderCode);
    }

    @Override
    public void createOrder(OrderDTO order) {
        orderMapper.createOrder(order);
    }

    @Override
    public void updateOrderStatus(int orderCode, String status) {
        orderMapper.updateOrderStatus(orderCode, status);
    }

    @Override
    public void cancelOrder(int orderCode, String cancelReason) {
        orderMapper.cancelOrder(orderCode, cancelReason);
    }
    
}
