package com.example.pj.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.pj.dto.ProductDTO;
import com.example.pj.service.ProductService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/product/*")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "list", method= {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> list(@RequestParam(name = "searchkey", defaultValue = "all") String searchkey, @RequestParam(name = "keyword", defaultValue = "") String keyword) {
		Map<String, Object> map = new HashMap<>();
		List<ProductDTO> list = productService.list(searchkey, keyword);
		// list == null 또는 list.size == 0
		if(list == null) {
			map.put("message", "등록된 상품이 없습니다.");
		} else {
			map.put("list", list);
		}
		map.put("keyword", keyword);
		return map;
	}
	
	@RequestMapping(value = "list/{brandCode}", method= {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> list_brand(@RequestParam(name = "keyword") String keyword, @PathVariable(name = "brandCode") int brandCode) {
		Map<String, Object> map = new HashMap<>();
		List<ProductDTO> list = productService.brand_list(brandCode, keyword);
		// list == null 또는 list.size == 0
		if(list == null) {
			map.put("message", "등록된 상품이 없습니다.");
		} else {
			map.put("list", list);
		}
		map.put("keyword", keyword);
		return map;
	}
	
	@RequestMapping(value = "list/{gender}", method= {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> list_gender(@RequestParam(name = "searchkey", defaultValue = "all") String searchkey, @RequestParam(name = "keyword", defaultValue = "") String keyword, @PathVariable(name = "gender") String gender) {
		Map<String, Object> map = new HashMap<>();
		List<ProductDTO> list = productService.gender_list(gender, searchkey, keyword);
		// list == null 또는 list.size == 0
		if(list == null) {
			map.put("message", "등록된 상품이 없습니다.");
		} else {
			map.put("list", list);
		}
		map.put("keyword", keyword);
		return map;
	}
	
	@GetMapping("detail/{productCode}")
	public ProductDTO detail(@PathVariable(name = "productCode") int productCode) {
		ProductDTO dto = productService.detail(productCode);
		return dto;
	}
	
	// 파일 업로드 배열로 하는 방법 찾아보기
	@PostMapping("insert")
	public void insert(ProductDTO dto, @RequestParam(name = "mainImg") MultipartFile mainImg, @RequestParam(name = "detailImg") MultipartFile detailImg, HttpServletRequest request) {
		String mainImage = "";
		String detailImage = "";
		if(mainImg != null && detailImg != null) {
			mainImage = mainImg.getOriginalFilename();
			detailImage = detailImg.getOriginalFilename();
			try {
				ServletContext application = request.getSession().getServletContext();
				String path = application.getRealPath("/images/");
				// String uid = UUID.randomUUID().toString();
				mainImg.transferTo(new File(path + mainImage));
				detailImg.transferTo(new File(path+ detailImage));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		dto.setMainImage(mainImage);
		dto.setDetailImage(detailImage);
		productService.insert(dto);
	}
	
	@PostMapping("update")
	public void update(ProductDTO dto,  @RequestParam(name = "mainImg") MultipartFile mainImg, @RequestParam(name = "detailImg") MultipartFile detailImg, HttpServletRequest request) {
		String mainImage =	dto.getMainImage();
		String detailImage = dto.getDetailImage();
		if(mainImg != null) {
			mainImage = mainImg.getOriginalFilename();
			try {
				ServletContext application = request.getSession().getServletContext();
				String path = application.getRealPath("/images/");
				// String uid = UUID.randomUUID().toString();
				mainImg.transferTo(new File(path + mainImage));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			dto.setMainImage(mainImage);
		}
		if(detailImg != null) {
			detailImage = detailImg.getOriginalFilename();
			try {
				ServletContext application = request.getSession().getServletContext();
				String path = application.getRealPath("/images/");
				// String uid = UUID.randomUUID().toString();
				detailImg.transferTo(new File(path + detailImage));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			dto.setDetailImage(detailImage);
		}
		productService.update(dto);
	}
	
	@PostMapping("delete")
	public void delete(@RequestParam(name = "productCode") int productCode, HttpServletRequest request) {
		ProductDTO dto = productService.detail(productCode);
		String mainImage = dto.getMainImage();
		String detailImage = dto.getDetailImage();
		
		ServletContext appication = request.getSession().getServletContext();
		String path = appication.getRealPath("/images/");
		File mf = new File(path+mainImage);
		if(mf.exists()) {
			mf.delete();
		}
		File df = new File(path+detailImage);
		if(df.exists()) {
			df.delete();
		}
		productService.delete(productCode);
	}
	
	
	
	
}
