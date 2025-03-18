package com.example.pj.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.pj.dto.OrderDTO;
import com.example.pj.dto.OrderItemDTO;
import com.example.pj.dto.ProductDTO;

@Mapper
public interface OrderMapper {
    
    // 상품 정보
    List<ProductDTO> getProductInfo(int productCode); // 안쓸듯
    
    // 주문 테이블 등록
    void insertOrder(OrderDTO dto);
    
    // 각 상품 주문아이템 테이블 등록
    void insertOrderItem(OrderItemDTO dto);
    
    // 상품 수량 감소
    void downAmount(@Param(value = "productCode") int productCode, @Param(value = "orderAmount") int orderAmount);
    
    // 주문 상태 변경
    void updateOrderState(@Param(value = "orderCode") int orderCode, @Param(value = "orderState") int orderState);
    
    // 주문 내역
    List<OrderDTO> orderList(String userid);

	OrderDTO orderDetail(int orderCode);
	
	int countProduct(int productCode);
    
    // 주문 상품 상세 정보 => orderDate로 할 수도
    
    
    
    
}