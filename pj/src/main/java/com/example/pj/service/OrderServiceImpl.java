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
    private OrderMapper orderMapper;

    @Override
    public List<OrderDTO> getOrderList(String userId) {
        return orderMapper.getOrderList(userId);
    }

    @Override
    public OrderDTO getOrderDetail(int orderCode) {
        return orderMapper.getOrderDetail(orderCode);
    }

    @Override
    public void createOrder(OrderDTO orderDTO) {
        orderMapper.createOrder(orderDTO);
    }

    @Override
    public void cancelOrder(int orderCode, String cancelReason) {
        orderMapper.cancelOrder(orderCode, cancelReason);
    }

    @Override
    public void changeOrderStatus(int orderCode, String status) {
        orderMapper.changeOrderStatus(orderCode, status);
    }

    @Override
    public List<OrderDetailDTO> getOrderDetails(int orderCode) {
        return orderMapper.getOrderDetails(orderCode);
    }
}
