package com.example.pj.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
@RequestMapping("/api/product/")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "list", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> list(@RequestParam(name = "searchkey", defaultValue = "all") String searchkey,
                                    @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        Map<String, Object> map = new HashMap<>();
        List<ProductDTO> list = productService.list(searchkey, keyword);
        if (list == null) {
            map.put("message", "등록된 상품이 없습니다.");
        } else {
            map.put("list", list);
        }
        map.put("keyword", keyword);
        return map;
    }

    @RequestMapping(value = "list/{brandCode}", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> list_brand(@RequestParam(name = "keyword") String keyword,
                                          @PathVariable(name = "brandCode") int brandCode) {
        Map<String, Object> map = new HashMap<>();
        List<ProductDTO> list = productService.brandList(brandCode, keyword);
        if (list == null) {
            map.put("message", "등록된 상품이 없습니다.");
        } else {
            map.put("list", list);
        }
        map.put("keyword", keyword);
        return map;
    }

    @RequestMapping(value = "list/{gender}", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> list_gender(@RequestParam(name = "searchkey", defaultValue = "all") String searchkey,
                                           @RequestParam(name = "keyword", defaultValue = "") String keyword,
                                           @PathVariable(name = "gender") String gender) {
        Map<String, Object> map = new HashMap<>();
        List<ProductDTO> list = productService.genderList(gender, searchkey, keyword);
        if (list == null) {
            map.put("message", "등록된 상품이 없습니다.");
        } else {
            map.put("list", list);
        }
        map.put("keyword", keyword);
        return map;
    }

    @GetMapping("detail/{productCode}")
    public ProductDTO detail(@PathVariable(name = "productCode") int productCode) {
        return productService.detail(productCode);
    }

    // 상품 등록
    @Transactional
    @PostMapping("insert")
    public void insert(ProductDTO dto, @RequestParam(name = "mainImg") MultipartFile mainImg,
                       @RequestParam(name = "detailImg") MultipartFile detailImg, HttpServletRequest request) {
        String mainImage = "";
        String detailImage = "";

        // 파일 업로드 처리
        if (mainImg != null && !mainImg.isEmpty()) {
            mainImage = UUID.randomUUID().toString() + "_" + mainImg.getOriginalFilename();
            try {
                ServletContext application = request.getSession().getServletContext();
                String path = application.getRealPath("/images/");
                File directory = new File(path);
                if (!directory.exists()) {
                    directory.mkdirs(); // 디렉토리가 없으면 생성
                }
                mainImg.transferTo(new File(path + File.separator + mainImage));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (detailImg != null && !detailImg.isEmpty()) {
            detailImage = UUID.randomUUID().toString() + "_" + detailImg.getOriginalFilename();
            try {
                ServletContext application = request.getSession().getServletContext();
                String path = application.getRealPath("/images/");
                File directory = new File(path);
                if (!directory.exists()) {
                    directory.mkdirs(); // 디렉토리가 없으면 생성
                }
                detailImg.transferTo(new File(path + File.separator + detailImage));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        dto.setMainImage(mainImage);
        dto.setDetailImage(detailImage);
        productService.insert(dto);
    }

    // 상품 수정
    @Transactional
    @PostMapping("update")
    public void update(ProductDTO dto, @RequestParam(name = "mainImg", required = false) MultipartFile mainImg,
                       @RequestParam(name = "detailImg", required = false) MultipartFile detailImg, HttpServletRequest request) {
        String mainImage = dto.getMainImage();
        String detailImage = dto.getDetailImage();

        // 파일 업로드 처리
        if (mainImg != null && !mainImg.isEmpty()) {
            mainImage = UUID.randomUUID().toString() + "_" + mainImg.getOriginalFilename();
            try {
                ServletContext application = request.getSession().getServletContext();
                String path = application.getRealPath("/images/");
                File directory = new File(path);
                if (!directory.exists()) {
                    directory.mkdirs(); // 디렉토리가 없으면 생성
                }
                mainImg.transferTo(new File(path + File.separator + mainImage));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (detailImg != null && !detailImg.isEmpty()) {
            detailImage = UUID.randomUUID().toString() + "_" + detailImg.getOriginalFilename();
            try {
                ServletContext application = request.getSession().getServletContext();
                String path = application.getRealPath("/images/");
                File directory = new File(path);
                if (!directory.exists()) {
                    directory.mkdirs(); // 디렉토리가 없으면 생성
                }
                detailImg.transferTo(new File(path + File.separator + detailImage));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        dto.setMainImage(mainImage);
        dto.setDetailImage(detailImage);
        productService.update(dto);
    }

    // 상품 삭제
    @PostMapping("delete")
    public void delete(@RequestParam(name = "productCode") int productCode, HttpServletRequest request) {
        ProductDTO dto = productService.detail(productCode);
        String mainImage = dto.getMainImage();
        String detailImage = dto.getDetailImage();

        ServletContext application = request.getSession().getServletContext();
        String path = application.getRealPath("/images/");
        File mf = new File(path + mainImage);
        if (mf.exists()) {
            mf.delete();
        }
        File df = new File(path + detailImage);
        if (df.exists()) {
            df.delete();
        }

        productService.delete(productCode);
    }
}
