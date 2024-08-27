package com.ohgiraffers.buillderpar.service;

import com.ohgiraffers.buillderpar.model.dto.UserDTO;
import com.ohgiraffers.buillderpar.model.entity.User;
import com.ohgiraffers.buillderpar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String registerUser(UserDTO userDTO) {
        // 기존 회원 체크
        if (userRepository.existsByName(userDTO.getName()) || userRepository.existsByPhone(userDTO.getPhone())) {
            return "기존 회원입니다";
        }

        // DTO를 엔티티로 변환
        User user = convertToEntity(userDTO);

        // 엔티티 저장
        userRepository.save(user);

        return "회원 등록이 성공적으로 완료되었습니다";
    }

    private User convertToEntity(UserDTO userDTO) {
        return new User.UserBuilder(userDTO.getName(), userDTO.getPhone())
                .age(userDTO.getAge())
                .address(userDTO.getAddress())
                .build();
    }
}
