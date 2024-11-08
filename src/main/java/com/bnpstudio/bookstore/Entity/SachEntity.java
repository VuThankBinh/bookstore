package com.bnpstudio.bookstore.entity;

import com.bnpstudio.bookstore.dto.SachDetailDto;

import jakarta.persistence.*;

@Entity
@Table(name = "Sach")
public class SachEntity {
    @Id
    @Column(name = "IdSach")
    private int IdSach;

    @Column(name = "IdDanhMuc")
    private int IdDanhMuc;

    @Column(name = "TenSach")
    private String TenSach;

    @Column(name = "GiaBan")
    private float GiaBan;

    @Column(name = "TacGia")
    private String TacGia;

    @Column(name = "SoLuong")
    private int SoLuong;

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
        this.TenSach = tenSach;
        this.GiaBan = giaBan;
        this.TacGia = tacGia;
        this.SoLuong = soLuong;
        this.AnhBia = anhBia;
        this.GhiChu = ghiChu;
        this.NhaCungCap = nhaCungCap;
    }

    public SachEntity(SachDetailDto sachDetail) {
        this.IdSach = sachDetail.getIdSach();
        this.IdDanhMuc = sachDetail.getIdDanhMuc();
        this.TenSach = sachDetail.getTenSach();
        this.GiaBan = sachDetail.getGiaBan();
        this.TacGia = sachDetail.getTacGia();
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
        return TenSach;
    }

    public void setTenSach(String tenSach) {
        this.TenSach = tenSach;
    }

    public float getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(float giaBan) {
        this.GiaBan = giaBan;
    }

    public String getTacGia() {
        return TacGia;
    }

    public void setTacGia(String tacGia) {
        this.TacGia = tacGia;
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