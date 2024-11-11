package com.bnpstudio.bookstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "ChiTietDonHang")
// @IdClass(ChiTietDonHangId.class) 
public class ChiTietDonHangEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")  
    private Integer id;
    
    @Column(name = "IdDonHang")
    private Integer idDonHang;
    @Column(name = "IdSach")
    private Integer	idSach;
    @Column(name = "TenSach")
    private String tenSach;	    
    @Column(name = "SoLuong")
    private Integer soLuong;
    @Column(name = "DonGia")
    private Float donGia;
    public ChiTietDonHangEntity() {
    }
    public ChiTietDonHangEntity(Integer idDonHang, String tenSach, Integer idSach, Integer soLuong, Float donGia) {
        this.idDonHang = idDonHang;
        this.tenSach = tenSach;
        this.idSach = idSach;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
    public Integer getIdDonHang() {
        return idDonHang;
    }
    public void setIdDonHang(Integer idDonHang) {
        this.idDonHang = idDonHang;
    }
    public String getTenSach() {
        return tenSach;
    }
    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }
    public Integer getIdSach() {
        return idSach;
    }
    public void setIdSach(Integer idSach) {
        this.idSach = idSach;
    }
    public Integer getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }
    public Float getDonGia() {
        return donGia;
    }
    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }
    @Override
    public String toString() {
        return "ChiTietDonHang [idDonHang=" + idDonHang + ", tenSach=" + tenSach + ", idSach=" + idSach + ", soLuong="
                + soLuong + ", donGia=" + donGia + "]";
    }
    
}
