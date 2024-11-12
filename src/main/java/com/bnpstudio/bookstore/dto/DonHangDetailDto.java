package com.bnpstudio.bookstore.dto;

import java.sql.Date;
import java.util.List;

import com.bnpstudio.bookstore.entity.DonHangEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonHangDetailDto {
    private Integer idDonHang;
    private Integer idNguoiDung;
    private String tenNguoiNhan;
    private String soDienThoai;
    private Float tongHoaDon;
    private String diaChi;
    private Date ngayTao;
    private Date ngayNhan;
    private String trangThai;
    private Float phiVanChuyen;
    private String phuongThucThanhToan;
    private String maGiamGia;
    private String ghiChu;
    private List<ChiTietDonHangDetailDto> ct;

    public DonHangDetailDto(DonHangEntity donHangEntity) {
        this.idDonHang = donHangEntity.getIdDonHang();
        this.idNguoiDung = donHangEntity.getIdNguoiDung();
        this.tenNguoiNhan = donHangEntity.getTenNguoiNhan();
        this.soDienThoai = donHangEntity.getSoDienThoai();
        this.tongHoaDon = donHangEntity.getTongHoaDon();
        this.diaChi = donHangEntity.getDiaChi();
        this.ngayTao = donHangEntity.getNgayTao();
        this.ngayNhan = donHangEntity.getNgayNhan();
        this.trangThai = donHangEntity.getTrangThai();
        this.phiVanChuyen = donHangEntity.getPhiVanChuyen();
        this.phuongThucThanhToan = donHangEntity.getPhuongThucThanhToan();
        this.maGiamGia = donHangEntity.getMaGiamGia();
        this.ghiChu = donHangEntity.getGhiChu();
    }
}
