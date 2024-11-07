package com.bnpstudio.bookstore.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bnpstudio.bookstore.Entity.Sach;
import com.bnpstudio.bookstore.Model.SachModel;
import com.bnpstudio.bookstore.Repository.SachRepository;

@Service
public class SachService {
    private final SachRepository sachRepository;

    public SachService(SachRepository sachRepository) {
        this.sachRepository = sachRepository;
    }

    public List<SachModel> getAllSach() {
        List<Sach> sachs = sachRepository.getAllSach();
        List<SachModel> sachModels = sachs.stream()
            .map(SachModel::new)
            .collect(Collectors.toList());
        return sachModels;
    }
}
