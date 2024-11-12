package com.bnpstudio.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bnpstudio.bookstore.entity.ChiTietDonHangEntity;

@Repository
public interface ChiTietDonHangRepository extends JpaRepository<ChiTietDonHangEntity,Integer> {
    List<ChiTietDonHangEntity> findByIdSach(Integer idSach);
    List<ChiTietDonHangEntity> findByIdDonHang(Integer idDonHang);
}
