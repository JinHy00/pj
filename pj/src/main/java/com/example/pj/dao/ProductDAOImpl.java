package com.example.pj.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.pj.dto.ProductDTO;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {
    @Autowired
    SqlSession sqlSession;

    @Override
    public List<ProductDTO> list(String productName) {
        return sqlSession.selectList("product.list", "%" + productName + "%");
    }

    @Override
    public void insert(ProductDTO dto) {
        sqlSession.insert("product.insert", dto);
    }

    @Override
    public ProductDTO detail(int productCode) {
        return sqlSession.selectOne("product.detail", productCode);
    }

    @Override
    public void update(ProductDTO dto) {
        sqlSession.update("product.update", dto);
    }

    @Override
    public void delete(int productCode) {
        sqlSession.delete("product.delete", productCode);
    }

    @Override
    public String filename(int productCode) {
        return sqlSession.selectOne("product.filename", productCode);
    }
}
