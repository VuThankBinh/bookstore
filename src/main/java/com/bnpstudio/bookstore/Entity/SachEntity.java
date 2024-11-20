package com.bnpstudio.bookstore.entity;

import com.bnpstudio.bookstore.dto.SachDetailDto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Sach")
public class SachEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdSach")
    private Integer IdSach;

    @Column(name = "IdDanhMuc")
    private Integer IdDanhMuc;

    @Column(name = "TenSach")
    private String tenSach;

    @Column(name = "GiaBan")
    private Float GiaBan;

    @Column(name = "TacGia")
    private String tacGia;

    @Column(name = "SoLuong")
    private Integer SoLuong;

    @Column(name = "AnhBia")
    private String AnhBia;

    @Column(name = "GhiChu")
    private String GhiChu;

    @Column(name = "NhaCungCap")
    private String NhaCungCap;

    

    public SachEntity(SachDetailDto sachDetail) {
        this.IdSach = sachDetail.getIdSach();
        this.IdDanhMuc = sachDetail.getIdDanhMuc();
        this.tenSach = sachDetail.getTenSach();
        this.GiaBan = sachDetail.getGiaBan();
        this.tacGia = sachDetail.getTacGia();
        this.SoLuong = sachDetail.getSoLuong();
        this.AnhBia = sachDetail.getAnhBia();
        this.GhiChu = sachDetail.getGhiChu();
        this.NhaCungCap = sachDetail.getNhaCungCap();
    }
    
   
}