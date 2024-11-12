package com.bnpstudio.bookstore.dto;


import com.bnpstudio.bookstore.entity.ChiTietDonHangEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietDonHangDetailDto {
  
    private Integer idDonHang;
    private Integer	idSach;
    private String tenSach;	    
    private Integer soLuong;
    private Float donGia;
    public ChiTietDonHangDetailDto(ChiTietDonHangEntity chiTietDonHangEntity) {
        this.idDonHang = chiTietDonHangEntity.getIdDonHang();
        this.idSach = chiTietDonHangEntity.getIdSach();
        this.tenSach = chiTietDonHangEntity.getTenSach();
        this.soLuong = chiTietDonHangEntity.getSoLuong();
        this.donGia =chiTietDonHangEntity.getDonGia();
    }
    
       
}
