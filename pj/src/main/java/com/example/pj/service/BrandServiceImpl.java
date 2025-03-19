package com.example.pj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pj.dto.BrandDTO;
import com.example.pj.mapper.BrandMapper;

@Service
public class BrandServiceImpl implements BrandService {
   @Autowired
   BrandMapper brandMapper;

   @Override
   public List<BrandDTO> list() {
      return brandMapper.list();
   }

   @Override
   public void insert(BrandDTO dto) {
      brandMapper.insert(dto);
   }

   @Override
   public BrandDTO detail(int brandCode) {
      return brandMapper.detail(brandCode);
   }

   @Override
   public void update(BrandDTO dto) {
      brandMapper.update(dto);
   }

   @Override
   public void delete(int brandCode) {
      brandMapper.delete(brandCode);
   }

}
