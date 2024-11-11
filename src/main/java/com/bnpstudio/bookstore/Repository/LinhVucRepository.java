package com.bnpstudio.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnpstudio.bookstore.entity.LinhVucEntity;

@Repository
public interface LinhVucRepository extends JpaRepository<LinhVucEntity, Integer> {
    @SuppressWarnings("null")
    List<LinhVucEntity> findAll();
}
