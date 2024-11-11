package com.bnpstudio.bookstore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bnpstudio.bookstore.dto.DonHangDetailDto;
import com.bnpstudio.bookstore.entity.DonHangEntity;
import com.bnpstudio.bookstore.exception.NotFoundException;
import com.bnpstudio.bookstore.repository.DonHangRepository;

@Service
public class DonHangService {
    @Autowired
    DonHangRepository donHangRepository;

    public List<DonHangDetailDto> getAll() {
        List<DonHangEntity> donHangs = donHangRepository.findAll();
        System.out.println("donhangs: " + donHangs);
        return donHangs.stream()
                .map(DonHangDetailDto::new)
                .collect(Collectors.toList());
    }

    public List<DonHangDetailDto> getDonHangByTrangThai(Pageable pageable ,String trangThai) {
        Page<DonHangEntity> donHangs = donHangRepository.findByTrangThaiIgnoreCase(trangThai.trim(),pageable);
        System.out.println("donhangs: " + donHangs);
        return donHangs.stream()
                .map(DonHangDetailDto::new)
                .collect(Collectors.toList());
    }
    public DonHangDetailDto updateTrangThaiDonHang(int id, String trangThai){

        
        if (trangThai == null || trangThai.trim().isEmpty()) {
            throw new IllegalArgumentException("Trạng thái đơn hàng không được để trống");
        }
        
        DonHangEntity dh = donHangRepository.findById(id);
        if(dh == null) {
            throw new NotFoundException("Không tồn tại đơn hàng có mã là: " + id);
        }
        
        dh.setTrangThai(trangThai);
        donHangRepository.save(dh);
        return new DonHangDetailDto(dh);
    
    }
}
