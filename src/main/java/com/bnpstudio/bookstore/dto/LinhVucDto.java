package com.bnpstudio.bookstore.dto;

import com.bnpstudio.bookstore.entity.LinhVucEntity;

public class LinhVucDto {
    private int idLinhVuc;
    private String tenLinhVuc;
    private String moTa;

    public LinhVucDto() {
    }

    public LinhVucDto(int idLinhVuc, String tenLinhVuc, String moTa) {
        this.idLinhVuc = idLinhVuc;
        this.tenLinhVuc = tenLinhVuc;
        this.moTa = moTa;
    }

    public LinhVucDto(LinhVucEntity linhVucEntity) {
        this.idLinhVuc = linhVucEntity.getIdLinhVuc();
        this.tenLinhVuc = linhVucEntity.getTenLinhVuc();
        this.moTa = linhVucEntity.getMoTa();
    }

    public int getIdLinhVuc() {
        return idLinhVuc;
    }

    public void setIdLinhVuc(int idLinhVuc) {
        this.idLinhVuc = idLinhVuc;
    }

    public String getTenLinhVuc() {
        return tenLinhVuc;
    }

    public void setTenLinhVuc(String tenLinhVuc) {
        this.tenLinhVuc = tenLinhVuc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "LinVucDetailDto [idLinhVuc=" + idLinhVuc + ", tenLinhVuc=" + tenLinhVuc + ", moTa=" + moTa + "]";
    }
}
