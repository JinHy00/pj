package com.example.pj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.pj.dto.WishDTO;
import com.example.pj.service.WishService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/wish")
public class WishController {
	
	@Autowired
	WishService wishService;
	
	@RequestMapping("/list/{userid}")
	public List<WishDTO> list(@PathVariable(name = "userid") String userid) {
		return wishService.list(userid);
	}
	
	@PostMapping("/insert")
	public void insert(WishDTO dto) {
		Map<String, Object> map = new HashMap<>();
		map.put("wishCode", dto.getWishCode());
		map.put("userid", dto.getUserid());
		map.put("productCode", dto.getProductCode());
		wishService.insert(map);
	}
	
	@RequestMapping(value = "/delete/{wishCode}", method = {RequestMethod.POST, RequestMethod.GET})
	public void delete(@PathVariable(name = "wishCode") int wishCoded) {
		System.out.println("==delete==");
		System.out.println("code: "+wishCoded);
		wishService.delete(wishCoded);
	}
}