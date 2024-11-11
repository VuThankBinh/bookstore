package com.bnpstudio.bookstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DonHang")
public class DonHangEntity {
    @Id
    @Column(name = "IdDonHang")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDonHang;
    @Column(name = "IDNguoiDung")
    private Integer idNguoiDung;
    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;
    @Column(name = "SoDienThoai")
    private String soDienThoai;
    @Column(name = "ThongHoaDon")
    private Float tongHoaDon;
    @Column(name = "DiaChi")
    private String diaChi;
}
