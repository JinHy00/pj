package com.example.pj.controller;


import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pj.service.AdminService;


import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/admin/*")
public class AdminController {
   @Autowired
   AdminService adminService;
   
   @PostMapping("login")
   public Map<String, Object> login(@RequestParam(name = "adminid") String adminid, @RequestParam(name = "passwd") String passwd) {
      String adminName = adminService.loginAdmin(adminid, passwd);
      System.out.println("adminname: "+adminName);
      Map<String, Object> map = new HashMap<>();
      // 로그인 성공
      if(adminName != null) {
         map.put("adminName", adminName);
         map.put("message", "success");
         
      } else {
         map.put("message", "error");
      }
      return map;
   }
//   
//   @GetMapping("login_info")
//   public Map<String, Object> login_info(HttpSession session) {
//      Map<String, Object> map = new HashMap<>();
//      String adminid = (String) session.getAttribute("adminid");
//      map.put("adminid", adminid);
//      return map;
//   }
//   
//       @PostMapping("login")
//       public ResponseEntity<?> login(@RequestBody Map<String, String> request, HttpSession session) {
//           String userId = request.get("userid");
//           String name = adminService.loginAdmin(userId, passwd);
//           session.setAttribute("userid", userId); // 세션에 userid 저장
//
//           return ResponseEntity.ok(Collections.singletonMap("userid", userId));
//       }
/*
       @GetMapping("admin_info")
       public ResponseEntity<?> admin_info(HttpSession session) {
          System.out.println("== admin_info ==");
           String adminid = (String) session.getAttribute("adminid");
           String adminName = (String) session.getAttribute("adminName");
           System.out.println("adminName = "+ adminName);
           System.out.println("adminid = "+ adminid);
           if (adminid == null) {
               return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 필요");
           }
           Map<String,Object> map = new HashMap<>();
           map.put("adminid", adminid);
           map.put("adminName", adminName);
           return ResponseEntity.ok(map);
       }
*/
//    @GetMapping("admin_info")
//    public ResponseEntity<?> admin_info(HttpSession session) {
//       System.out.println("== admin_info ==");
//        String adminid = (String) session.getAttribute("adminid");
//        String adminName = (String) session.getAttribute("adminName");
//        System.out.println("adminName = "+ adminName);
//        System.out.println("adminid = "+ adminid);
//        if (adminid == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 필요");
//        }
//        Map<String,Object> map = new HashMap<>();
//        map.put("adminid", adminid);
//        map.put("adminName", adminName);
//        return ResponseEntity.ok(map);
//    }   

   
   
   @PostMapping("passwd_check")
   public Map<String, Object> passwd_check(@RequestParam(name = "passwd") String passwd, @RequestParam(name = "adminid") String adminid) {
      int result = adminService.passwdCheck(adminid, passwd);
      Map<String, Object> map = new HashMap<>();
      // 비밀번호 불일치
      if(result == 0) {
         map.put("message", "error");
      } else {
         map.put("message", "success");
      }
      return map;
   }
   
}
