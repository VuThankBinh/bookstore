package com.bnpstudio.bookstore.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpstudio.bookstore.dto.SachDetailDto;
import com.bnpstudio.bookstore.entity.SachEntity;
import com.bnpstudio.bookstore.entity.ChiTietDonHangEntity;
import com.bnpstudio.bookstore.exception.NotFoundException;
import com.bnpstudio.bookstore.exception.NotImplementedException;
import com.bnpstudio.bookstore.repository.ChiTietDonHangRepository;
import com.bnpstudio.bookstore.repository.SachRepository;

@Service
public class SachService {
    @Autowired
    private SachRepository sachRepository;
    @Autowired
    private ChiTietDonHangRepository chiTietDonHangRepository;

    private SachEntity normalizeData(SachEntity sach) {
        if (sach == null)
            return sach;
            SachEntity sachNormalized = new SachEntity();
        sachNormalized.setIdSach(sach.getIdSach());
        sachNormalized.setTenSach(sach.getTenSach() != null ? sach.getTenSach().trim() : null);
        sachNormalized.setTacGia(sach.getTacGia() != null ? sach.getTacGia().trim() : null);
        sachNormalized.setAnhBia(sach.getAnhBia() != null ? sach.getAnhBia().trim() : null);
        sachNormalized.setGhiChu(sach.getGhiChu() != null ? sach.getGhiChu().trim() : null);
        sachNormalized.setNhaCungCap(sach.getNhaCungCap() != null ? sach.getNhaCungCap().trim() : null);
        sachNormalized.setGiaBan(sach.getGiaBan());
        sachNormalized.setSoLuong(sach.getSoLuong());
        sachNormalized.setIdDanhMuc(sach.getIdDanhMuc());
        return sachNormalized;
    }

    public List<SachDetailDto> getAll() {
        List<SachEntity> sachs = sachRepository.findAll();
        return sachs.stream()
                .map(SachDetailDto::new)
                .collect(Collectors.toList());
    }

    public SachDetailDto getById(int id) {
        System.out.println("id sach: " + id);
        SachEntity sach = sachRepository.findById(id);
        if (sach == null)
            throw new NotFoundException("Sách không tồn tại");
        return new SachDetailDto(sach);
    }

    public List<SachDetailDto> findByName(String name) {
        List<SachEntity> sachs = sachRepository.findByTenSachContainingIgnoreCase(name);
        if (sachs.size() == 0) {
            throw new NotFoundException("Không tìm thấy sách có tên: " + name);
        }
        return sachs.stream().map(SachDetailDto::new).collect(Collectors.toList());
    }

    public List<SachDetailDto> findProduct(SachEntity sach) {
        System.out.println(sach);

        List<SachEntity> foundProducts = sachRepository
                .findByTenSachIgnoreCaseAndTacGiaIgnoreCase(sach.getTenSach(), sach.getTacGia());
        if (foundProducts.size() > 0) {
            return foundProducts.stream().map(SachDetailDto::new).collect(Collectors.toList());
        }
        throw new NotFoundException("not found products");
    }

    public SachDetailDto insertProduct(SachEntity sach) {
        sach = normalizeData(sach);
        // System.out.println(sach);
        if (sach.getAnhBia().isEmpty()) {
            throw new NotImplementedException("Ảnh bìa không được để trống");
        }
        if (sach.getGhiChu().isEmpty()) {
            throw new NotImplementedException("Ghi chú không được để trống");
        }
        if (sach.getGiaBan() == null) {
            throw new NotImplementedException("Giá bán không được để trống");
        }
        if (sach.getSoLuong() == null) {
            throw new NotImplementedException("Số lượng không được để trống");
        }
        if (sach.getIdDanhMuc() == null) {
            throw new NotImplementedException("Danh mục không được để trống");
        }
        if (sach.getNhaCungCap().isEmpty()) {
            throw new NotImplementedException("Nhà cung cấp không được để trống");
        }
        if (sach.getTacGia().isEmpty()) {
            throw new NotImplementedException("Tác giả không được để trống");
        }
        if (sach.getTenSach().isEmpty()) {
            throw new NotImplementedException("Tên sách không được để trống");
        }
        List<SachEntity> foundProducts = sachRepository
                .findByTenSachIgnoreCaseAndTacGiaIgnoreCase(sach.getTenSach(), sach.getTacGia());
        if (foundProducts.size() > 0) {
            throw new NotImplementedException("Product already taken");
        }
        sach.setIdSach(null);
        sachRepository.save(sach);
        return new SachDetailDto(sach);
    }

    public SachDetailDto UpdateProduct(SachEntity sach) {
        sach = normalizeData(sach);
        // System.out.println(sach);
        if (sach.getIdSach() == null) {
            throw new NotImplementedException("Giá sản phẩm không được để trống");
        }
        if (sach.getAnhBia().isEmpty()) {
            throw new NotImplementedException("Ảnh bìa không được để trống");
        }
        if (sach.getGhiChu().isEmpty()) {
            throw new NotImplementedException("Ghi chú không được để trống");
        }
        if (sach.getGiaBan() == null) {
            throw new NotImplementedException("Giá bán không được để trống");
        }
        if (sach.getSoLuong() == null) {
            throw new NotImplementedException("Số lượng không được để trống");
        }
        if (sach.getIdDanhMuc() == null) {
            throw new NotImplementedException("Danh mục không được để trống");
        }
        if (sach.getNhaCungCap().isEmpty()) {
            throw new NotImplementedException("Nhà cung cấp không được để trống");
        }
        if (sach.getTacGia().isEmpty()) {
            throw new NotImplementedException("Tác giả không được để trống");
        }
        if (sach.getTenSach().isEmpty()) {
            throw new NotImplementedException("Tên sách không được để trống");
        }
        List<SachEntity> foundProducts = sachRepository
                .findByTenSachIgnoreCaseAndTacGiaIgnoreCase(sach.getTenSach(), sach.getTacGia());
        if (foundProducts.size() > 0) {
            throw new NotImplementedException("Product already taken");
        }
        sachRepository.save(sach);
        return new SachDetailDto(sach);
    }

    public void deleteProduct(Integer id) {
        Optional<SachEntity> sach = sachRepository.findById(id);
        if (sach.isEmpty()) {
            throw new NotFoundException("Không tìm thấy sách cần xóa");
        }
        // Lấy và cập nhật các chi tiết liên quan
        List<ChiTietDonHangEntity> chiTiets = chiTietDonHangRepository.findByIdSach(sach.get().getIdSach());
        System.out.println("DSSP: " + chiTiets);
        for (ChiTietDonHangEntity chiTiet : chiTiets) {
            chiTiet.setIdSach(0);
            chiTietDonHangRepository.save(chiTiet);
        }
        sachRepository.deleteById(sach.get().getIdSach());
    }
}
