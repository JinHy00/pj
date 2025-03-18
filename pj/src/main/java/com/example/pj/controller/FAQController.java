package com.example.pj.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.pj.dto.FAQCategoryDTO;
import com.example.pj.dto.FAQDTO;
import com.example.pj.service.FAQService;

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
	public String faq_insert(FAQDTO dto) {
		Map<String, Object> map = new HashMap<>();
		map.put("faqCode", dto.getFaqCode());
		map.put("adminid", dto.getAdminid());
		map.put("faqTitle", dto.getFaqTitle());
		map.put("faqContent", dto.getFaqContent());
		map.put("f_categoryCode", dto.getF_categoryCode());
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
	public void faq_update(FAQDTO dto) {
		Map<String, Object> map = new HashMap<>();
		map.put("faqCode", dto.getFaqCode());
		map.put("adminid", dto.getAdminid());
		map.put("faqTitle", dto.getFaqTitle());
		map.put("faqContent", dto.getFaqContent());
		map.put("f_categoryCode", dto.getF_categoryCode());
		faqService.update(map);
	}
	
	@DeleteMapping("/delete/{faqCode}")
	public void delete(FAQDTO dto) {
		int faqCode = dto.getFaqCode();
		faqService.delete(faqCode);
	}
	
	@RequestMapping("/category")
	public List<FAQCategoryDTO> category() {
		return faqService.category();
	}
}