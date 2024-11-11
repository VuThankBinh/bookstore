package com.bnpstudio.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonHangDto {
    private Integer idDonHang;
    private Integer idNguoiDung;
    private String tenNguoiNhan;
    private String soDienThoai;
    private Float tongHoaDon;
    private String diaChi;
}
