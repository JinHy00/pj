package com.example.pj.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pj.dao.WishDAO;
import com.example.pj.dto.WishDTO;

@Service
public class WishServiceImpl implements WishService {
   
   @Autowired
   WishDAO wishDao;
   
   @Override
   public List<WishDTO> list(String userid) {
      return wishDao.list(userid);
   }
   
   @Transactional
   @Override
   public void insert(Map<String, Object> map) {
      wishDao.insert(map);
   }
      
   @Override
   public void delete(int wishCode) {
      wishDao.delete(wishCode);
   }
   
   @Override
   public boolean count(int productCode, String userid) {
      int count = wishDao.count(productCode, userid);
      return count > 0;
   }
}