package com.bnpstudio.bookstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnpstudio.bookstore.entity.LinhVucEntity;

@Repository
public interface LinhVucRepository extends JpaRepository<LinhVucEntity, Integer> {
    List<LinhVucEntity> findAll();
    Optional<LinhVucEntity> findById(Integer id);
    Optional<LinhVucEntity> findByTenLinhVucIgnoreCase(String tenLinhVuc);
}
