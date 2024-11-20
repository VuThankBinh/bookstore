package com.bnpstudio.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bnpstudio.bookstore.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    boolean existsByEmail(String email);
    UserEntity findByEmail(String email);
}
