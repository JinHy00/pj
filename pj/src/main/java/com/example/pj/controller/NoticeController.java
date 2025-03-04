package com.example.pj.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.pj.dto.NoticeCategoryDTO;
import com.example.pj.dto.NoticeDTO;
import com.example.pj.service.NoticeService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/notice")
public class NoticeController {
	@Autowired
	NoticeService noticeService;
	
	@RequestMapping("/list")
	public List<NoticeDTO> notice_list(@RequestParam(name = "searchkey", defaultValue = "title") String searchkey, @RequestParam(name = "search", defaultValue = "") String search) {
		return noticeService.list(searchkey, search);
	}
	
	@PostMapping("/insert")
	public String notice_insert(NoticeDTO dto, @RequestParam(name = "img", required = false) MultipartFile img, HttpServletRequest request) {
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
		map.put("noticeCode", dto.getNoticeCode());
		map.put("noticeTitle", dto.getNoticeTitle());
		map.put("noticeContent", dto.getNoticeContent());
		map.put("n_categoryCode", dto.getN_categoryCode());
		map.put("noticeFile", filename);
		return noticeService.insert(map);
	}
	
	@GetMapping("/detail/{noticeCode}")
	public NoticeDTO notice_detail(@PathVariable(name = "noticeCode") int noticeCode) {
		return noticeService.detail(noticeCode);	
	}
	
	@GetMapping("/edit/{noticeCode}")
	public NoticeDTO notice_edit(@PathVariable(name = "noticeCode") int noticeCode) {
		return noticeService.edit(noticeCode);	
	}
	
	@PostMapping("/update")
	public void notice_update(NoticeDTO dto, @RequestParam(name = "img", required = false) MultipartFile img, HttpServletRequest request) {
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
			int noticeCode = dto.getNoticeCode();
	        NoticeDTO notice = noticeService.detail(noticeCode);
	        filename = notice.getNoticeFile(); 
		}
		Map<String, Object> map = new HashMap<>();
		map.put("noticeCode", dto.getNoticeCode());
		map.put("noticeTitle", dto.getNoticeTitle());
		map.put("noticeContent", dto.getNoticeContent());
		map.put("n_categoryCode", dto.getN_categoryCode());
		map.put("noticeFile", filename);
		noticeService.update(map);
	}
	
	@GetMapping("/delete/{noticeCode}")
	public void delete(NoticeDTO dto, HttpServletRequest request) {
		String filename = dto.getNoticeFile();
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
	
	@RequestMapping("/category")
	public List<NoticeCategoryDTO> category() {
		return noticeService.category();
	}
}