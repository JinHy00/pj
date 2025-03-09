package com.example.pj.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.pj.dto.BrandDTO;
import com.example.pj.dto.ProductDTO;
import com.example.pj.service.ProductService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

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
    
    @GetMapping("edit/{productCode}")
    public ProductDTO edit(@PathVariable(name = "productCode") int productCode) {
        return productService.edit(productCode);
    }
    
    
    @GetMapping("/brand_list")
    public List<BrandDTO> getBrands() {
        return productService.getAllBrands();
    }

    // 상품 등록
    @Transactional
    @PostMapping("insert")
    public Map<String, Object> insert(ProductDTO dto, @RequestParam(name = "mainImg") MultipartFile mainImg,
                                       @RequestParam(name = "detailImg") MultipartFile detailImg, HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();
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
        dto.setBrandName(request.getParameter("brandName"));

        try {
            productService.insert(dto);
            response.put("success", true);  // 상품 등록 성공
        } catch (Exception e) {
            response.put("success", false);  // 상품 등록 실패
            e.printStackTrace();
        }

        return response;
    }

    // 상품 수정
    @Transactional
    @PostMapping("update/{productCode}")
    public Map<String, Object> update(@PathVariable("productCode") int productCode, ProductDTO dto,
                                      @RequestParam(name = "mainImg", required = false) MultipartFile mainImg,
                                      @RequestParam(name = "detailImg", required = false) MultipartFile detailImg,
                                      HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();
        try {
            // 기존 이미지 경로 (기존 값을 사용)
            String mainImage = dto.getMainImage();  // 기존 이미지
            String detailImage = dto.getDetailImage();  // 기존 이미지

            // mainImg 파일 업로드 처리
            if (mainImg != null && !mainImg.isEmpty()) {
                mainImage = UUID.randomUUID().toString() + "_" + mainImg.getOriginalFilename();
                String path = request.getServletContext().getRealPath("/images/");
                File directory = new File(path);
                if (!directory.exists()) {
                    directory.mkdirs(); // 디렉토리가 없으면 생성
                }
                mainImg.transferTo(new File(path + File.separator + mainImage));
            }

            // detailImg 파일 업로드 처리
            if (detailImg != null && !detailImg.isEmpty()) {
                detailImage = UUID.randomUUID().toString() + "_" + detailImg.getOriginalFilename();
                String path = request.getServletContext().getRealPath("/images/");
                File directory = new File(path);
                if (!directory.exists()) {
                    directory.mkdirs(); // 디렉토리가 없으면 생성
                }
                detailImg.transferTo(new File(path + File.separator + detailImage));
            }

            // 파일 경로를 DTO에 세팅
            dto.setMainImage(mainImage);  // mainImage가 null이 아닌 값으로 설정됨
            dto.setDetailImage(detailImage);  // detailImage도 null이 아닌 값으로 설정됨

            // 상품 수정 서비스 호출
            productService.update(dto);

            // 성공 응답 반환
            response.put("success", true);
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            // 실패 응답 반환
            response.put("success", false);
            response.put("message", "상품 수정 중 오류가 발생했습니다.");
            return response;
        }
    }


    // 상품 삭제
    @DeleteMapping("delete/{productCode}")
    public void delete(@PathVariable("productCode") int productCode, HttpServletRequest request) {
        ProductDTO dto = productService.detail(productCode);
        String mainImage = dto.getMainImage();
        String detailImage = dto.getDetailImage();

        // 이미지 파일 삭제
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

        // 데이터베이스에서 상품 삭제
        productService.delete(productCode);
    }

}
