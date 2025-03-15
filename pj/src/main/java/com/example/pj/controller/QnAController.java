package com.example.pj.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import com.example.pj.dto.QnADTO;
import com.example.pj.dto.QnAReplyDTO;
import com.example.pj.dto.QnACategoryDTO;
import com.example.pj.service.QnAService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/qna")
public class QnAController {

    @Autowired
    QnAService qnaService;

    @RequestMapping("/list")
	public List<QnADTO> qna_list(@RequestParam(name = "searchkey", defaultValue = "title") String searchkey, @RequestParam(name = "search", defaultValue = "") String search) {
		return qnaService.list(searchkey, search);
	}
    
    @RequestMapping("/my_list")
    public List<QnADTO> my_list(@RequestParam(name = "userid") String userid) {
    	return qnaService.my_list(userid);
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
		map.put("userid", dto.getUserid());
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
		map.put("userid", dto.getUserid());
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
	
	@RequestMapping("/reply_list/{qnaCode}")
	public List<QnAReplyDTO> reply_list(@PathVariable(name = "qnaCode") int qnaCode) {
		return qnaService.reply_list(qnaCode);
	}
	
	@PostMapping("/reply_write/{qnaCode}")
	public String reply_write(@PathVariable(name = "qnaCode") int qnaCode, QnAReplyDTO dto) {
		Map<String, Object> map = new HashMap<>();
		map.put("qnaCode", qnaCode);
		map.put("adminid", dto.getAdminid());
		map.put("q_replyContent", dto.getQ_replyContent());
		map.put("q_replyCode", qnaCode);
		return qnaService.reply_write(map);
	}
	
	@PostMapping("/reply_update")
	public void reply_update(QnAReplyDTO dto) {
		Map<String, Object> map = new HashMap<>();
		map.put("qnaCode", dto.getQnaCode());
		map.put("adminid", dto.getAdminid());
		map.put("q_replyContent", dto.getQ_replyContent());
		map.put("q_replyCode", dto.getQ_replyCode());
		qnaService.reply_update(map);
	}
}