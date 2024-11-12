package com.bnpstudio.bookstore.entity;

import com.bnpstudio.bookstore.dto.SachDetailDto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Sach")
public class SachEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdSach")
    private Integer IdSach;

    @Column(name = "IdDanhMuc")
    @NotNull(message = "ID danh mục không được để trống")
    private Integer IdDanhMuc;

    @Column(name = "TenSach")
    @NotBlank(message = "Tên sách không được để trống")
    private String tenSach;

    @Column(name = "GiaBan")
    @NotNull(message = "Giá bán không được để trống")
    @Min(value = 0, message = "Giá bán phải lớn hơn hoặc bằng 0")
    private Float GiaBan;

    @Column(name = "TacGia")
    @NotBlank(message = "Tên tác giả không được để trống")
    private String tacGia;

    @Column(name = "SoLuong")
    @NotNull(message = "Số lượng không được để trống")
    @Min(value = 0, message = "Số lượng phải lớn hơn hoặc bằng 0")
    private Integer SoLuong;

    @Column(name = "AnhBia")
    @NotBlank(message = "Ảnh bìa không được để trống")
    private String AnhBia;

    @Column(name = "GhiChu")
    private String GhiChu;

    @Column(name = "NhaCungCap")
    @NotBlank(message = "Nhà cung cấp không được để trống")
    private String NhaCungCap;

    

    public SachEntity(SachDetailDto sachDetail) {
        this.IdSach = sachDetail.getIdSach();
        this.IdDanhMuc = sachDetail.getIdDanhMuc();
        this.tenSach = sachDetail.getTenSach();
        this.GiaBan = sachDetail.getGiaBan();
        this.tacGia = sachDetail.getTacGia();
        this.SoLuong = sachDetail.getSoLuong();
        this.AnhBia = sachDetail.getAnhBia();
        this.GhiChu = sachDetail.getGhiChu();
        this.NhaCungCap = sachDetail.getNhaCungCap();
    }
    
   
}