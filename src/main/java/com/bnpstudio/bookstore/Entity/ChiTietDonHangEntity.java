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
   
    
}
