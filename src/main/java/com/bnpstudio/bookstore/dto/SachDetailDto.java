package com.bnpstudio.bookstore.dto;

import com.bnpstudio.bookstore.entity.SachEntity;

public class SachDetailDto {
    private int IdSach;
    private int IdDanhMuc;
    private String tenSach;
    private float GiaBan;
    private String tacGia;
    private int SoLuong;
    private String AnhBia;
    private String GhiChu;
    private String NhaCungCap;

    public SachDetailDto() {
    }

    public SachDetailDto(int idSach, int idDanhMuc, String tenSach, float giaBan, String tacGia, int soLuong,
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

    public int getIdSach() {
        return IdSach;
    }

    public int getIdDanhMuc() {
        return IdDanhMuc;
    }

    public String getTenSach() {
        return tenSach;
    }

    public float getGiaBan() {
        return GiaBan;
    }

    public String getTacGia() {
        return tacGia;
    }

    public int getSoLuong() {
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

    public void setIdSach(int idSach) {
        this.IdSach = idSach;
    }

    public void setIdDanhMuc(int idDanhMuc) {
        this.IdDanhMuc = idDanhMuc;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public void setGiaBan(float giaBan) {
        this.GiaBan = giaBan;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public void setSoLuong(int soLuong) {
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
