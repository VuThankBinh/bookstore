package com.bnpstudio.bookstore.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnpstudio.bookstore.entity.DanhMucEntity;

@Repository
public interface DanhMucRepository extends JpaRepository<DanhMucEntity, Integer> {
    List<DanhMucEntity> findByIdLinhVuc(Integer idLinhVuc);
    Optional<DanhMucEntity> findByTenDanhMuc(String tenDanhMuc);
}