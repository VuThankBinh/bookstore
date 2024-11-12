package com.bnpstudio.bookstore.entity;

import java.sql.Date;

import com.bnpstudio.bookstore.dto.DonHangDetailDto;

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

    @Column(name = "TongHoaDon")
    private Float tongHoaDon;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "NgayTao")
    private Date ngayTao;
    
    @Column(name = "NgayNhan")
    private Date ngayNhan;
    
    @Column(name = "TrangThai")
    private String trangThai;
    
    @Column(name = "PhiVanChuyen") 
    private Float phiVanChuyen;
    
    @Column(name = "PhuongThucThanhToan")
    private String phuongThucThanhToan;
    
    @Column(name = "MaGiamGia")
    private String maGiamGia;
    
    @Column(name = "GhiChu")
    private String ghiChu;

    public DonHangEntity(DonHangDetailDto detailDto) {
        this.idDonHang = detailDto.getIdDonHang();
        this.idNguoiDung = detailDto.getIdNguoiDung();
        this.tenNguoiNhan = detailDto.getTenNguoiNhan();
        this.soDienThoai = detailDto.getSoDienThoai();
        this.tongHoaDon = detailDto.getTongHoaDon();
        this.diaChi = detailDto.getDiaChi();
        this.ngayTao = detailDto.getNgayTao();
        this.ngayNhan = detailDto.getNgayNhan();
        this.trangThai = detailDto.getTrangThai();
        this.phiVanChuyen = detailDto.getPhiVanChuyen();
        this.phuongThucThanhToan = detailDto.getPhuongThucThanhToan();
        this.maGiamGia = detailDto.getMaGiamGia();
        this.ghiChu = detailDto.getGhiChu();
    }

    
}
