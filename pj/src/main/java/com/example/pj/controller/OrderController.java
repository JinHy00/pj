package com.example.pj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pj.dto.OrderDTO;
import com.example.pj.service.OrderService;


@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // 주문 목록 조회
    @GetMapping("/list/{userId}")
    public List<OrderDTO> getOrderList(@PathVariable String userId) {
        return orderService.getOrderList(userId);
    }

    // 주문 상세 조회
    @GetMapping("/detail/{orderCode}")
    public OrderDTO getOrderDetail(@PathVariable int orderCode) {
        return orderService.getOrderDetail(orderCode);
    }

    // 주문 생성
    @Transactional
    @PostMapping("/create")
    public void createOrder(@RequestBody OrderDTO order) {
        orderService.createOrder(order);
    }

    // 주문 상태 변경
    @PostMapping("/change_status")
    public void changeOrderStatus(@RequestParam int orderCode, @RequestParam String status) {
        orderService.updateOrderStatus(orderCode, status);
    }

    // 주문 취소
    @PostMapping("/cancel")
    public void cancelOrder(@RequestParam int orderCode, @RequestParam String cancelReason) {
        orderService.cancelOrder(orderCode, cancelReason);
    }
}