package com.bnpstudio.bookstore.entity;

import com.bnpstudio.bookstore.dto.SachDetailDto;

import jakarta.persistence.*;

@Entity
@Table(name = "Sach")
public class SachEntity {
    @Id
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

    public SachEntity() {
    }

    public SachEntity(int idSach, int idDanhMuc, String tenSach, float giaBan, String tacGia, int soLuong,
            String anhBia, String ghiChu, String nhaCungCap) {
        this.IdSach = idSach;
        this.IdDanhMuc = idDanhMuc;
        this.tenSach = tenSach;
        this.GiaBan = giaBan;
        this.tacGia = tacGia;
        this.SoLuong = soLuong;
        this.AnhBia = anhBia;
        this.GhiChu = ghiChu;
        this.NhaCungCap = nhaCungCap;
    }

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

    public String getAnhBia() {
        return AnhBia;
    }

    public void setAnhBia(String anhBia) {
        this.AnhBia = anhBia;
    }

    public int getIdSach() {
        return IdSach;
    }

    public void setIdSach(int idSach) {
        this.IdSach = idSach;
    }

    public int getIdDanhMuc() {
        return IdDanhMuc;
    }

    public void setIdDanhMuc(int idDanhMuc) {
        this.IdDanhMuc = idDanhMuc;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public float getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(float giaBan) {
        this.GiaBan = giaBan;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        this.SoLuong = soLuong;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.GhiChu = ghiChu;
    }

    public String getNhaCungCap() {
        return NhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.NhaCungCap = nhaCungCap;
    }
}