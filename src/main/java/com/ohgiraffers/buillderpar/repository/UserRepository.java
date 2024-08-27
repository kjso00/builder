package com.ohgiraffers.buillderpar.repository;

import com.ohgiraffers.buillderpar.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByName(String name);
    boolean existsByPhone(String phone);
}
