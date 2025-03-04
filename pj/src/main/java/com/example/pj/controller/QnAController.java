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

import com.example.pj.dto.QnACategoryDTO;
import com.example.pj.dto.QnADTO;
import com.example.pj.service.QnAService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/qna")
public class QnAController {
	@Autowired
	QnAService qnaService;
	
	@RequestMapping("/list")
	public List<QnADTO> qna_list(@RequestParam(name = "searchkey", defaultValue = "title") String searchkey, @RequestParam(name = "search", defaultValue = "") String search) {
		return qnaService.list(searchkey, search);
	}
	
	@PostMapping("/insert")
	public String qna_insert(QnADTO dto, @RequestParam(name = "img", required = false) MultipartFile img, HttpServletRequest request) {
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
		map.put("qnaCode", dto.getQnaCode());
		map.put("qnaTitle", dto.getQnaTitle());
		map.put("qnaContent", dto.getQnaContent());
		map.put("q_categoryCode", dto.getQ_categoryCode());
		map.put("qnaFile", filename);
		return qnaService.insert(map);
	}
	
	@GetMapping("/detail/{qnaCode}")
	public QnADTO qna_detail(@PathVariable(name = "qnaCode") int qnaCode) {
		return qnaService.detail(qnaCode);	
	}
	
	@GetMapping("/edit/{qnaCode}")
	public QnADTO qna_edit(@PathVariable(name = "qnaCode") int qnaCode) {
		return qnaService.edit(qnaCode);	
	}
	
	@PostMapping("/update")
	public void qna_update(QnADTO dto, @RequestParam(name = "img", required = false) MultipartFile img, HttpServletRequest request) {
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
			int qnaCode = dto.getQnaCode();
			QnADTO qna = qnaService.detail(qnaCode);
	        filename = qna.getQnaFile(); 
		}
		Map<String, Object> map = new HashMap<>();
		map.put("qnaCode", dto.getQnaCode());
		map.put("qnaTitle", dto.getQnaTitle());
		map.put("qnaContent", dto.getQnaContent());
		map.put("q_categoryCode", dto.getQ_categoryCode());
		map.put("qnaFile", filename);
		qnaService.update(map);
	}
	
	@GetMapping("/delete/{qnaCode}")
	public void delete(QnADTO dto, HttpServletRequest request) {
		String filename = dto.getQnaFile();
		if (filename != null && !filename.equals("-")) {
			String path = request.getSession().getServletContext().getRealPath("/images/");
			File f = new File(path + filename);
			if (f.exists()) {
				f.delete();
			}
		}
		int qnaCode = dto.getQnaCode();
		qnaService.delete(qnaCode);
	}
	
	@RequestMapping("/category")
	public List<QnACategoryDTO> category() {
		return qnaService.category();
	}
}