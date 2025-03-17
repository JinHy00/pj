package com.example.pj.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.pj.dto.ReviewDTO;
import com.example.pj.service.ReviewService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/review")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	@RequestMapping("/list")
	public List<ReviewDTO> list(@RequestParam(name = "productCode") int productCode) {
		return reviewService.list(productCode);
	}
	
	@RequestMapping("/my_review")
	public List<ReviewDTO> my_review(@RequestParam(name = "userid") String userid) {
		return reviewService.my_review(userid);
	}
	
	@PostMapping("/insert")
	public String insert(ReviewDTO dto, @RequestParam(name = "img", required = false) MultipartFile img, HttpServletRequest request) {
		String filename = "-";
		if (img != null && !img.isEmpty()) {
			filename = img.getOriginalFilename();
			try {
				ServletContext application = request.getSession().getServletContext();
				String path = application.getRealPath("/images/");
				img.transferTo(new File(path + filename));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Map<String, Object> map = new HashMap<>();
		map.put("reviewCode", dto.getReviewCode());
		map.put("productCode", dto.getProductCode());
		map.put("userid", dto.getUserid());
		map.put("reviewContent", dto.getReviewContent());
		map.put("reviewScore", dto.getReviewScore());
		map.put("reviewFile", filename);
		return reviewService.insert(map);
	}
	
	@GetMapping("/detail/{reviewCode}")
	public ReviewDTO detail(@PathVariable(name = "reviewCode") int reviewCode) {
		return reviewService.detail(reviewCode);
	}
	
	@GetMapping("/edit/{reviewCode}")
	public ReviewDTO edit(@PathVariable(name = "reviewCode") int reviewCode) {
		return reviewService.edit(reviewCode);
	}
	
	@PostMapping("/update")
	public void update(ReviewDTO dto, @RequestParam(name = "img", required = false) MultipartFile img, HttpServletRequest request) {
		String filename = "-";
		if (img != null && !img.isEmpty()) {
			filename = img.getOriginalFilename();
			try {
				ServletContext application = request.getSession().getServletContext();
				String path = application.getRealPath("/images/");
				img.transferTo(new File(path + filename));
			} catch (Exception e) {
				e.printStackTrace();
			} 
		} else {
			int reviewCode = dto.getReviewCode();
			ReviewDTO review = reviewService.detail(reviewCode);
			filename = review.getReviewFile();
		}
		Map<String, Object> map = new HashMap<>();
		map.put("reviewCode", dto.getReviewCode());
		map.put("productCode", dto.getProductCode());
		map.put("userid", dto.getUserid());
		map.put("reviewContent", dto.getReviewContent());
		map.put("reviewScore", dto.getReviewScore());
		map.put("reviewFile", filename);
		reviewService.update(map);
	}
	
	@GetMapping("/delete/{reviewCode}")
	public void delete(ReviewDTO dto, HttpServletRequest request) {
		String filename = dto.getReviewFile();
		if (filename != null && !filename.equals("-")) {
			String path = request.getSession().getServletContext().getRealPath("/images/");
			File f = new File(path + filename);
			if (f.exists()) {
				f.delete();
			}
		}
		int reviewCode = dto.getReviewCode();
		reviewService.delete(reviewCode);
	}
	
}
