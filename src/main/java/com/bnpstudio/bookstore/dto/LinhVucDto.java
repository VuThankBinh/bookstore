package com.bnpstudio.bookstore.dto;

import com.bnpstudio.bookstore.entity.LinhVucEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinhVucDto {
    private Integer idLinhVuc;
    private String tenLinhVuc;
    private String moTa;

    public LinhVucDto(LinhVucEntity linhVucEntity) {
        this.idLinhVuc = linhVucEntity.getIdLinhVuc();
        this.tenLinhVuc = linhVucEntity.getTenLinhVuc();
        this.moTa = linhVucEntity.getMoTa();
    }
}
