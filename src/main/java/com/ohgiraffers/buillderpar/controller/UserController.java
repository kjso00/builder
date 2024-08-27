package com.ohgiraffers.buillderpar.controller;

import com.ohgiraffers.buillderpar.model.dto.UserDTO;
import com.ohgiraffers.buillderpar.model.entity.User;
import com.ohgiraffers.buillderpar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO userDTO) {
        // Null 체크
        if (userDTO.getName() == null || userDTO.getPhone() == null ||
                userDTO.getAddress() == null || userDTO.getAge() == null) {
            return ResponseEntity.badRequest().body("입력을 다시 하세요");
        }

        // 이름과 나이 조건 체크
        if (userDTO.getName().length() != 3 || !isKorean(userDTO.getName()) || userDTO.getAge() < 20) {
            return ResponseEntity.badRequest().body("가입 조건에 부합하지 않습니다");
        }

        try {
            String result = userService.registerUser(userDTO);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private boolean isKorean(String name) {
        return name.matches("^[가-힣]{3}$");
    }
}
