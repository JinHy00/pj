package com.example.pj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pj.dto.CartDTO;
import com.example.pj.service.CartService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    // 장바구니 추가
    @PostMapping("/add")
    public void addToCart(@RequestBody CartDTO cartDTO) {
        cartService.addCart(cartDTO);
    }

    @GetMapping("/list")
    public List<CartDTO> getCartList(@RequestParam(name = "userId") String userId) {
        return cartService.getCartList(userId);
    }

    // 장바구니 항목 삭제
    @DeleteMapping("/remove/{cartCode}")
    public void removeFromCart(@PathVariable(name = "cartCode") int cartCode) {
        cartService.removeFromCart(cartCode);
    }

    // 장바구니 전체 삭제
    @DeleteMapping("/remove/all")
    public void removeAllFromCart(@RequestParam(name = "userId") String userId) {
        cartService.removeAllFromCart(userId);
    }


    // 장바구니 수량 수정
    @PutMapping("/update")
    public Map<String, Object> updateCartAmount(@RequestBody CartDTO cartDTO) {
        Map<String, Object> response = new HashMap<>();
        try {
            // 수량 업데이트 수행
            cartService.updateCartAmount(cartDTO);
            response.put("success", true);
        } catch (Exception e) {
            response.put("success", false);
        }
        return response;  // 직접 반환
    }


    // 장바구니 총 금액 계산
    @GetMapping("/total")
    public int getTotalPrice(@RequestParam String userId) {
        return cartService.getTotalPrice(userId);
    }
}
