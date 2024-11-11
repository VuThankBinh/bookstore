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

@Service
public class LinhVucService {
    @Autowired
    private LinhVucRepository linhVucRepository;

    private LinhVucDto normalizeData(LinhVucDto linhVuc) {
        if (linhVuc == null)
            return linhVuc;
        LinhVucDto linhVucNormalized = new LinhVucDto();
        linhVucNormalized.setIdLinhVuc(linhVuc.getIdLinhVuc());
        linhVucNormalized.setTenLinhVuc(
                linhVuc.getTenLinhVuc() != null ? linhVuc.getTenLinhVuc().trim() : null);
        linhVucNormalized.setMoTa(
                linhVuc.getMoTa() != null ? linhVuc.getMoTa().trim() : null);
        return linhVucNormalized;
    }

    private Boolean validateInsertLinhVuc(LinhVucDto linhVuc) {
        if(linhVuc == null) throw new IllegalArgumentException("s");
        if(linhVuc.getTenLinhVuc() == null || linhVuc.getTenLinhVuc().trim().isEmpty()) throw new IllegalArgumentException("se");
        return true;
    }

    public List<LinhVucDto> getAll() {
        List<LinhVucEntity> linhVucs = linhVucRepository.findAll();
        if (linhVucs.isEmpty())
            throw new NotFoundException("Không tìm thấy lĩnh vực nào");
        return linhVucs.stream()
                .map(LinhVucDto::new)
                .collect(Collectors.toList());
    }

    public LinhVucDto getById(Integer id) {
        Optional<LinhVucEntity> linhVuc = linhVucRepository.findById(id);
        if (linhVuc.isEmpty())
            throw new NotFoundException("Không tìm thấy lĩnh vực nào với id = " + id);
        return new LinhVucDto(linhVuc.get());
    }

    public LinhVucDto insertLinhVuc(LinhVucDto linhVuc) {
        linhVuc = normalizeData(linhVuc);
        validateInsertLinhVuc(linhVuc);
        LinhVucEntity linhVucEntity = new LinhVucEntity(linhVuc);
        linhVucEntity.setIdLinhVuc(null);
        linhVucRepository.save(linhVucEntity);
        return new LinhVucDto(linhVucEntity);
    }
}
