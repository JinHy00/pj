package com.example.pj.mapper;

import com.example.pj.dto.OrderDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderDTO> getOrderListByUserId(@Param("userId") String userId);
    OrderDTO getOrderDetail(@Param("orderCode") int orderCode);
    void createOrder(OrderDTO order);
    void updateOrderState(@Param("orderCode") int orderCode, @Param("orderState") int orderState);
}
