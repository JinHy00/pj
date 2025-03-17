package com.example.pj.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pj.dto.OrderDTO;
import com.example.pj.dto.OrderItemDTO;
import com.example.pj.mapper.OrderMapper;

@Service
public class OrderServiceImpl implements OrderService {
   @Autowired
   OrderMapper orderMapper;
   
   @Override
   public void insertOrder(OrderDTO dto) {
      orderMapper.insertOrder(dto);
   }

   @Override
   public void insertOrderItem(OrderItemDTO dto) {
      orderMapper.insertOrderItem(dto);

   }

   @Override
   public void downAmount(@Param(value = "productCode") int productCode, @Param(value = "orderAmount") int orderAmount) {
      orderMapper.downAmount(productCode, orderAmount);
   }

   @Override
   public void updateOrderState(@Param(value = "orderCode") int orderCode, @Param(value = "orderState") int orderState) {
      orderMapper.updateOrderState(orderCode, orderState);

   }

   @Override
   public List<OrderDTO> orderList(String userid) {
      return orderMapper.orderList(userid);
   }

}
