package com.bnpstudio.bookstore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpstudio.bookstore.dto.SachDetailDto;
import com.bnpstudio.bookstore.entity.SachEntity;
import com.bnpstudio.bookstore.exception.NotFoundException;
import com.bnpstudio.bookstore.repository.SachRepository;

@Service
public class SachService {
    @Autowired
    private SachRepository sachRepository;

    public List<SachDetailDto> getAll() {
        List<SachEntity> sachs = sachRepository.findAll();
        System.out.println("Số lượng sách tìm được: " + sachs.size());
        sachs.forEach(sach -> System.out.println("Sách: " + sach.getTenSach()));
        return sachs.stream()
                .map(SachDetailDto::new)
                .collect(Collectors.toList());
    }

    public SachDetailDto getById(int id) {
        SachEntity sach = sachRepository.findById(id);
        if (sach == null) throw new NotFoundException("Sách không tồn tại");
        return new SachDetailDto(sach);
    }
}
