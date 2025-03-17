package com.example.pj.controller;

import com.example.pj.dto.OrderDTO;
import com.example.pj.service.OrderService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // 특정 회원의 주문 목록 조회
    @GetMapping("/user/{userId}")
    public List<OrderDTO> getOrderListByUserId(@PathVariable String userId) {
        return orderService.getOrderListByUserId(userId);
    }

    // 주문 상세 조회
    @GetMapping("/{orderCode}")
    public OrderDTO getOrderDetail(@PathVariable int orderCode) {
        return orderService.getOrderDetail(orderCode);
    }

    // 주문 생성
    @PostMapping("/create")
    public void createOrder(@RequestBody OrderDTO order) {
        orderService.createOrder(order);
    }

    // 주문 상태 변경 (관리자용)
    @PutMapping("/updateState/{orderCode}")
    public void updateOrderState(@PathVariable int orderCode, @RequestParam int orderState) {
        orderService.updateOrderState(orderCode, orderState);
    }
}
