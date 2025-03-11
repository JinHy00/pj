package com.example.pj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.pj.dto.OrderDTO;
import com.example.pj.dto.OrderDetailDTO;

@Service
public interface OrderService {
	List<OrderDTO> getOrderList(String userId);
    OrderDTO getOrderDetail(int orderCode);
    void createOrder(OrderDTO orderDTO);
    void cancelOrder(int orderCode, String cancelReason);
    void changeOrderStatus(int orderCode, String status);
    List<OrderDetailDTO> getOrderDetails(int orderCode);
}
