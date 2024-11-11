package com.bnpstudio.bookstore.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpstudio.bookstore.repository.LinhVucRepository;
import com.bnpstudio.bookstore.dto.LinhVucDto;
import com.bnpstudio.bookstore.entity.LinhVucEntity;
import com.bnpstudio.bookstore.exception.NotFoundException;
import com.bnpstudio.bookstore.exception.NotImplementedException;

@Service
public class LinhVucService {
    @Autowired
    private LinhVucRepository linhVucRepository;

    public List<LinhVucDto> getAll() {
        List<LinhVucEntity> linhVucs = linhVucRepository.findAll();
        if (linhVucs.isEmpty()) throw new NotFoundException("Không tìm thấy lĩnh vực nào");
        return linhVucs.stream()
                .map(LinhVucDto::new)
                .collect(Collectors.toList());
    }

    public Optional<LinhVucEntity> getById(Integer id) {
        Optional<LinhVucEntity> linhVuc = linhVucRepository.findById(id);
        if(linhVuc.isEmpty()) throw new NotFoundException("Không tìm thấy lĩnh vực nào với id = " + id);
        return linhVuc;
    }

    public LinhVucDto insertLinhVuc(LinhVucDto linhVuc) {
        LinhVucEntity linhVucSaved = linhVucRepository.save(new LinhVucEntity(linhVuc));
        return new LinhVucDto(linhVucSaved);
    }
}
