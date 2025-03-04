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

import com.example.pj.dto.FAQCategoryDTO;
import com.example.pj.dto.FAQDTO;
import com.example.pj.service.FAQService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/faq")
public class FAQController {
	@Autowired
	FAQService faqService;
	
	@RequestMapping("/list") //
	public List<FAQDTO> Faq_list(@RequestParam(name = "searchkey", defaultValue = "title") String searchkey, @RequestParam(name = "search", defaultValue = "") String search) {
		return faqService.list(searchkey, search);
	}
	
	@PostMapping("/insert")
	public String faq_insert(FAQDTO dto, @RequestParam(name = "img", required = false) MultipartFile img, HttpServletRequest request) {
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
		map.put("faqCode", dto.getFaqCode());
		map.put("faqTitle", dto.getFaqTitle());
		map.put("faqContent", dto.getFaqContent());
		map.put("f_categoryCode", dto.getF_categoryCode());
		map.put("faqFile", filename);
		return faqService.insert(map);
	}
	
	@GetMapping("/detail/{faqCode}")
	public FAQDTO faq_detail(@PathVariable(name = "faqCode") int faqCode) {
		return faqService.detail(faqCode);	
	}
	
	@GetMapping("/edit/{faqCode}")
	public FAQDTO faq_edit(@PathVariable(name = "faqCode") int faqCode) {
		return faqService.edit(faqCode);	
	}
	
	@PostMapping("/update")
	public void faq_update(FAQDTO dto, @RequestParam(name = "img", required = false) MultipartFile img, HttpServletRequest request) {
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
			int faqCode = dto.getFaqCode();
	        FAQDTO faq = faqService.detail(faqCode);
	        filename = faq.getFaqFile(); 
		}
		Map<String, Object> map = new HashMap<>();
		map.put("faqCode", dto.getFaqCode());
		map.put("faqTitle", dto.getFaqTitle());
		map.put("faqContent", dto.getFaqContent());
		map.put("f_categoryCode", dto.getF_categoryCode());
		map.put("faqFile", filename);
		faqService.update(map);
	}
	
	@GetMapping("/delete/{faqCode}")
	public void delete(FAQDTO dto, HttpServletRequest request) {
		String filename = dto.getFaqFile();
		if (filename != null && !filename.equals("-")) {
			String path = request.getSession().getServletContext().getRealPath("/images/");
			File f = new File(path + filename);
			if (f.exists()) {
				f.delete();
			}
		}
		int faqCode = dto.getFaqCode();
		faqService.delete(faqCode);
	}
	
	@RequestMapping("/category")
	public List<FAQCategoryDTO> category() {
		return faqService.category();
	}
}