package com.example.pj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pj.dto.WishDTO;
import com.example.pj.service.WishService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/api/wish")
public class WishController {
	@Autowired
	WishService wishService;
	
	@RequestMapping("/list")
	public List<WishDTO> list(@RequestParam(name = "userid") String userid) {
		return wishService.list(userid);
	}
	
//	@PostMapping("/insert")
//	public String insert(WishDTO dto) {
//		Map<String, Object> map = new HashMap<>();
//		map.put("wishCode", dto.getWishCode());
//		map.put("userid", dto.getUserid());
//		map.put("productCode", dto.getProductCode());
//		return wishService.insert(map);
//	}
	
	@GetMapping("/delete/{wishCode}")
	public void delete(WishDTO dto) {
		int wishCode = dto.getWishCode();
		String userid = dto.getUserid();
		wishService.delete(wishCode, userid);
	}
}