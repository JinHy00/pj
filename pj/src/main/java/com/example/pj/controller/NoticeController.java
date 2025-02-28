package com.example.pj.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.pj.dto.NoticeCategoryDTO;
import com.example.pj.dto.NoticeDTO;
import com.example.pj.service.NoticeService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/notice/*")
public class NoticeController {
	@Autowired
	NoticeService noticeService;
	
	@RequestMapping("list")
	public List<NoticeDTO> notice_list(@RequestParam(name = "searchkey", defaultValue = "title") String searchkey, @RequestParam(name = "search", defaultValue = "") String search) {
		return noticeService.list(searchkey, search);
	}
	
	@PostMapping("insert")
	public String notice_insert(NoticeDTO dto, HttpServletRequest request) {
		String filename = "-";
		if (dto.getImg() != null && !dto.getImg().isEmpty()) {
			filename = dto.getImg().getOriginalFilename();
			try {
				String path = request.getSession().getServletContext().getRealPath("/images/");
				new File(path).mkdir();
				dto.getImg().transferTo(new File(path + filename));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Map<String, Object> map = new HashMap<>();
		map.put("filename", filename);
		map.put("dto", dto);
		return noticeService.insert(map);
	}
	
	@GetMapping("detail/{noticeCode}")
	public Map<String, Object> notice_detail(@PathVariable(name = "noticeCode") int noticeCode) {
		return noticeService.detail(noticeCode);	
	}
	
	@PostMapping("update")
	public String notice_update(NoticeDTO dto, HttpServletRequest request) {
		String filename = "-";
		if (dto.getImg() != null && !dto.getImg().isEmpty()) {
			filename = dto.getImg().getOriginalFilename();
			try {
				String path = request.getSession().getServletContext().getRealPath("/images/");
				new File(path).mkdir();
				dto.getImg().transferTo(new File(path + filename));
			} catch (Exception e) {
				e.printStackTrace();
			} 
		} else {
			int noticeCode = dto.getNoticeCode();
			Map<String, Object> map2 = noticeService.detail(noticeCode);
			filename = map2.get("filename").toString();
		}
		Map<String, Object> map = new HashMap<>();
		map.put("filename", filename);
		map.put("dto", dto);
		return noticeService.update(map);
	}
	
	@GetMapping("delete/{noticeCode}")
	public void delete(NoticeDTO dto, HttpServletRequest request) {
		String filename = dto.getFilename();
		if (filename != null && !filename.equals("-")) {
			String path = request.getSession().getServletContext().getRealPath("/images/");
			File f = new File(path + filename);
			if (f.exists()) {
				f.delete();
			}
		}
		int noticeCode = dto.getNoticeCode();
		noticeService.delete(noticeCode);
	}
	
	@RequestMapping("category")
	public List<NoticeCategoryDTO> category() {
		return noticeService.category();
	}
}