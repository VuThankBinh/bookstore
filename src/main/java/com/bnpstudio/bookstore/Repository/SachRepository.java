package com.bnpstudio.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bnpstudio.bookstore.entity.SachEntity;

@Repository
public interface SachRepository extends JpaRepository<SachEntity, Integer> {
    @SuppressWarnings("null")
    List<SachEntity> findAll();
    SachEntity findById(int id);
    List<SachEntity> findByTenSachContainingIgnoreCase(String tenSach);

    List<SachEntity> findByTenSachIgnoreCaseAndTacGiaIgnoreCase(String tenSach,String tacGia);
    
}
