package com.bnpstudio.bookstore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpstudio.bookstore.repository.LinhVucRepository;
import com.bnpstudio.bookstore.dto.LinhVucDto;
import com.bnpstudio.bookstore.entity.LinhVucEntity;

@Service
public class LinhVucService {
    @Autowired
    private LinhVucRepository linhVucRepository;

    public List<LinhVucDto> getAll() {
        List<LinhVucEntity> linhVucs = linhVucRepository.findAll();
        return linhVucs.stream()
                .map(LinhVucDto::new)
                .collect(Collectors.toList());
    }
}
