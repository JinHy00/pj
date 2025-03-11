package com.example.pj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pj.dto.OrderDTO;
import com.example.pj.dto.OrderDetailDTO;
import com.example.pj.service.OrderService;


@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // 주문 목록 조회
    @GetMapping("/list")
    public List<OrderDTO> getOrderList(@RequestParam(name = "userId") String userId) {
        return orderService.getOrderList(userId);
    }

    // 주문 상세 조회
    @GetMapping("/detail/{orderCode}")
    public OrderDTO getOrderDetail(@PathVariable int orderCode) {
        return orderService.getOrderDetail(orderCode);
    }

    // 주문 생성
    @PostMapping("/insert")
    public void createOrder(@RequestBody OrderDTO orderDTO) {
        orderService.createOrder(orderDTO);
    }

    // 주문 취소
    @PostMapping("/cancel")
    public void cancelOrder(@RequestParam(name = "orderCode") int orderCode,
                            @RequestParam(name = "cancelReason") String cancelReason) {
        orderService.cancelOrder(orderCode, cancelReason);
    }

    // 주문 상태 변경
    @PostMapping("/changeStatus")
    public void changeOrderStatus(@RequestParam(name = "orderCode") int orderCode,
                                  @RequestParam(name = "status") String status) {
        orderService.changeOrderStatus(orderCode, status);
    }

    // 주문 상세 정보 조회
    @GetMapping("/detail/{orderCode}/details")
    public List<OrderDetailDTO> getOrderDetails(@PathVariable int orderCode) {
        return orderService.getOrderDetails(orderCode);
    }
}