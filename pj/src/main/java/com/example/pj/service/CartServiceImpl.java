package com.example.pj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pj.dto.CartDTO;
import com.example.pj.mapper.CartMapper;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartMapper cartMapper;

    @Override
    public void addCart(CartDTO cartDTO) {
        cartMapper.addCart(cartDTO);
    }

    @Override
    public List<CartDTO> getCartList(String userId) {
        return cartMapper.getCartList(userId);
    }

    @Override
    public void removeFromCart(int cartCode) {
        cartMapper.removeFromCart(cartCode);
    }

    @Override
    public void removeAllFromCart(String userId) {
        cartMapper.removeAllFromCart(userId);
    }

    @Override
    public void updateCartAmount(CartDTO cartDTO) {
        cartMapper.updateCartAmount(cartDTO);
    }

    @Override
    public int getTotalPrice(String userId) {
        return cartMapper.getTotalPrice(userId);
    }
}