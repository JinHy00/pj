package com.example.pj.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pj.dto.OrderDTO;
import com.example.pj.dto.ProductDTO;
import com.example.pj.service.CartService;
import com.example.pj.service.CouponDetailService;
import com.example.pj.service.MemberService;
import com.example.pj.service.OrderService;
import com.example.pj.service.ProductService;


@RestController
@RequestMapping("/order/*")
public class OrderController {

    @Autowired
    OrderService orderService;
    
    @Autowired
    ProductService productService;
    
    @Autowired
    CartService cartService;
    
    @Autowired
    CouponDetailService couponDetailService;
    
    @Autowired
    MemberService memberService;
    
    // insert 
    @RequestMapping( value = "orderedProduct", method= {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> orderedProduct(@RequestParam(name = "productCode") int[] productCode, @RequestParam(name = "orderAmount") int[] orderAmount) {
       System.out.println("==ordered==");
       System.out.println("code: "+productCode);
       System.out.println("amount: "+orderAmount);
       Map<String, Object> map = new HashMap<>();
       List<ProductDTO> productList = new ArrayList<>();
       List<Integer> orderAmountList = new ArrayList<>();
       for (int i=0;i < productCode.length; i++) {
          ProductDTO product = productService.detail(productCode[i]);
          if(product != null) {
             productList.add(product);
             orderAmountList.add(orderAmount[i]);
          }
       }
       System.out.println("plist"+productList);
       System.out.println("alist"+orderAmountList);
       map.put("productList", productList);
       map.put("orderAmountList", orderAmountList);
        return map;
    }
    
    
    @Transactional
    @RequestMapping( value = "insert", method= {RequestMethod.GET, RequestMethod.POST})
    public void insert(OrderDTO dto, @RequestParam(name = "productCode") int[] productCode, @RequestParam(name = "orderAmount") int[] orderAmount, @RequestParam(name = "couponid") int couponid, @RequestParam(name = "usePoint") int usePoint, @RequestParam(name = "userid") String userid, @RequestParam(name = "savePoint") int savePoint) {
       System.out.println("==insert==");
       System.out.println("==insert=="+productCode);
       System.out.println("==insert==2"+orderAmount);
       System.out.println("==insert=="+couponid);
       System.out.println("usePoint: "+usePoint);
       System.out.println("saves: "+savePoint);
        System.out.println("userid"+userid);
       
        for (int i=0;i < productCode.length;i++) {
           // OrderDTO orderDTO = new OrderDTO();
           dto.setProductCode(productCode[i]);
           dto.setOrderAdmount(orderAmount[i]);
           orderService.insertOrder(dto);
           orderService.downAmount(productCode[i], orderAmount[i]);
        }
        couponDetailService.useCoupon(couponid);
        memberService.use_point(userid, usePoint);
        memberService.save_point(userid, savePoint);
    }
    
    @RequestMapping(value = "orderList/{userid}", method= {RequestMethod.GET, RequestMethod.POST})
    public List<OrderDTO> orderList(@PathVariable(name = "userid") String userid) {
       return orderService.orderList(userid);
    }
    
    @PostMapping("state")
    public void orderState(@RequestParam(name = "orderCode") int orderCode, @RequestParam(name = "orderState") int orderState) {
        orderService.updateOrderState(orderCode, orderState);
    }
 
}