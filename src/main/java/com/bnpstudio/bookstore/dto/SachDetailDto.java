package com.bnpstudio.bookstore.dto;

import com.bnpstudio.bookstore.entity.SachEntity;

public class SachDetailDto {
    private Integer IdSach;
    private Integer IdDanhMuc;
    private String tenSach;
    private Float GiaBan;
    private String tacGia;
    private Integer SoLuong;
    private String AnhBia;
    private String GhiChu;
    private String NhaCungCap;

    public SachDetailDto() {
    }

    public SachDetailDto(Integer idSach, Integer idDanhMuc, String tenSach, Float giaBan, String tacGia, Integer soLuong,
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

    public SachDetailDto(SachEntity sach) {
        this.IdSach = sach.getIdSach();
        this.IdDanhMuc = sach.getIdDanhMuc();
        this.tenSach = sach.getTenSach();
        this.GiaBan = sach.getGiaBan();
        this.tacGia = sach.getTacGia();
        this.SoLuong = sach.getSoLuong();
        this.AnhBia = sach.getAnhBia();
        this.GhiChu = sach.getGhiChu();
        this.NhaCungCap = sach.getNhaCungCap();
    }

    public Integer getIdSach() {
        return IdSach;
    }

    public Integer getIdDanhMuc() {
        return IdDanhMuc;
    }

    public String getTenSach() {
        return tenSach;
    }

    public Float getGiaBan() {
        return GiaBan;
    }

    public String getTacGia() {
        return tacGia;
    }

    public Integer getSoLuong() {
        return SoLuong;
    }

    public String getAnhBia() {
        return AnhBia;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public String getNhaCungCap() {
        return NhaCungCap;
    }

    public void setIdSach(Integer idSach) {
        this.IdSach = idSach;
    }

    public void setIdDanhMuc(Integer idDanhMuc) {
        this.IdDanhMuc = idDanhMuc;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public void setGiaBan(Float giaBan) {
        this.GiaBan = giaBan;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public void setSoLuong(Integer soLuong) {
        this.SoLuong = soLuong;
    }

    public void setAnhBia(String anhBia) {
        this.AnhBia = anhBia;
    }

    public void setGhiChu(String ghiChu) {
        this.GhiChu = ghiChu;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.NhaCungCap = nhaCungCap;
    }

    @Override
    public String toString() {
        return "SachModel [IdSach=" + IdSach + ", IdDanhMuc=" + IdDanhMuc + ", TenSach=" + tenSach + ", GiaBan="
                + GiaBan + ", TacGia=" + tacGia + ", SoLuong=" + SoLuong + ", AnhBia=" + AnhBia + ", GhiChu=" + GhiChu
                + ", NhaCungCap=" + NhaCungCap + "]";
    }
}
