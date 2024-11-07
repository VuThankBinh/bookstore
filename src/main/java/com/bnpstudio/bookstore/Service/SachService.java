package com.bnpstudio.bookstore.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpstudio.bookstore.Entity.SachEntity;
import com.bnpstudio.bookstore.Repository.SachRepository;
import com.bnpstudio.bookstore.dto.SachDetailDto;

@Service
public class SachService {
    @Autowired
    private SachRepository sachRepository;


    public List<SachDetailDto> getAllSach() {
        List<SachEntity> sachs = sachRepository.getAllSach();
        List<SachDetailDto> sachModels = sachs.stream()
            .map(SachDetailDto::new)
            .collect(Collectors.toList());
        return sachModels;
    }
}
