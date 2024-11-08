package com.bnpstudio.bookstore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpstudio.bookstore.dto.SachDetailDto;
import com.bnpstudio.bookstore.entity.SachEntity;
import com.bnpstudio.bookstore.exception.NotFoundException;
import com.bnpstudio.bookstore.exception.NotImplementedException;
import com.bnpstudio.bookstore.repository.SachRepository;

@Service
public class SachService {
    @Autowired
    private SachRepository sachRepository;

    public List<SachDetailDto> getAll() {
        List<SachEntity> sachs = sachRepository.findAll();
        return sachs.stream()
                .map(SachDetailDto::new)
                .collect(Collectors.toList());
    }

    public SachDetailDto getById(int id) {
        SachEntity sach = sachRepository.findById(id);
        if (sach == null) throw new NotFoundException("Sách không tồn tại");
        return new SachDetailDto(sach);
    }
    public List<SachDetailDto> findByName(String name){
        List<SachEntity> sachs= sachRepository.findByTenSachContainingIgnoreCase(name);
        if(sachs.size()==0){
            throw new NotFoundException("Không tìm thấy sách có tên: "+name);
        }
        return sachs.stream().map(SachDetailDto::new).collect(Collectors.toList());
    }
    public SachDetailDto insertProduct(SachEntity sach) {
        System.out.println(sach);
        @SuppressWarnings("unchecked")
        List<SachEntity> foundProducts = (List<SachEntity>) sachRepository.findByTenSachIgnoreCaseAndTacGiaIgnoreCase(sach.getTenSach().trim(),sach.getTacGia().trim());
        if (foundProducts.size() > 0) {
            throw new NotImplementedException("Product already taken");
        }
        sachRepository.save(sach);
        return new SachDetailDto(sach);
    }
    public List<SachDetailDto> findProduct(SachEntity sach) {
        System.out.println(sach);
        List<SachEntity> foundProducts =sachRepository.findByTenSachIgnoreCaseAndTacGiaIgnoreCase(sach.getTenSach().trim(),sach.getTacGia().trim());
        if (foundProducts.size() > 0) {
            return foundProducts.stream().map(SachDetailDto::new).collect(Collectors.toList());
        }
        throw new NotFoundException("not found products");
    }

}
