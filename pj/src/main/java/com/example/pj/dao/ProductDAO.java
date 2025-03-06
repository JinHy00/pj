package com.example.pj.dao;

import java.util.List;

import com.example.pj.dto.ProductDTO;

public interface ProductDAO {
    List<ProductDTO> list(String productName);
    ProductDTO detail(int productCode);
    void update(ProductDTO dto);
    void delete(int productCode);
    void insert(ProductDTO dto);
    String filename(int productCode);
}
