package com.bnpstudio.bookstore.entity;

import com.bnpstudio.bookstore.dto.LinhVucDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "LinhVuc")
public class LinhVucEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdLinhVuc")
    private Integer idLinhVuc;

    @Column(name = "TenLinhVuc")
    private String tenLinhVuc;

    @Column(name = "MoTa")
    private String moTa;

    public LinhVucEntity() {
    }

    public LinhVucEntity(Integer idLinhVuc, String tenLinhVuc, String moTa) {
        this.idLinhVuc = idLinhVuc;
        this.tenLinhVuc = tenLinhVuc;
        this.moTa = moTa;
    }

    public LinhVucEntity(LinhVucDto linhVuc) {
        this.idLinhVuc = (linhVuc.getIdLinhVuc() != null) ? linhVuc.getIdLinhVuc() : -1;
        this.tenLinhVuc = linhVuc.getTenLinhVuc();
        this.moTa = linhVuc.getMoTa();
    }

    public Integer getIdLinhVuc() {
        return idLinhVuc;
    }

    public void setIdLinhVuc(Integer idLinhVuc) {
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
        return "LinhVucEntity [idLinhVuc=" + idLinhVuc + ", tenLinhVuc=" + tenLinhVuc + ", moTa=" + moTa + "]";
    }
}
