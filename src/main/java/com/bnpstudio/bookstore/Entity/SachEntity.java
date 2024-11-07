package com.bnpstudio.bookstore.Entity;

@Entity
@Table(name = "Sach")
public class SachEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sach;
    private int id_danhMuc;
    private String ten_sach;
    private int gia_ban;
    private String tac_gia;
    private int so_luong;
    private String anh_bia;
    private String ghi_chu;
    private String nha_cung_cap;
    public SachEntity() {
    }
    public SachEntity(int id_sach, int id_danhMuc, String ten_sach, int gia_ban, String tac_gia, int so_luong, String anh_bia, String ghi_chu, String nha_cung_cap) {
        this.id_sach = id_sach;
        this.id_danhMuc = id_danhMuc;
        this.ten_sach = ten_sach;
        this.gia_ban = gia_ban;
        this.tac_gia = tac_gia;
        this.so_luong = so_luong;
        this.anh_bia = anh_bia;
        this.ghi_chu = ghi_chu;
        this.nha_cung_cap = nha_cung_cap;
    }
    public int getId_sach() {
        return id_sach;
    }
    public int getId_danhMuc() {
        return id_danhMuc;
    }
    public String getTen_sach() {
        return ten_sach;
    }
    public int getGia_ban() {
        return gia_ban;
    }
    public String getTac_gia() {
        return tac_gia;
    }
    public int getSo_luong() {
        return so_luong;
    }
    public String getAnh_bia() {
        return anh_bia;
    }
    public String getGhi_chu() {
        return ghi_chu;
    }
    public String getNha_cung_cap() {
        return nha_cung_cap;
    }
    public void setId_sach(int id_sach) {
        this.id_sach = id_sach;
    }
    public void setId_danhMuc(int id_danhMuc) {
        this.id_danhMuc = id_danhMuc;
    }
    public void setTen_sach(String ten_sach) {
        this.ten_sach = ten_sach;
    }
    public void setGia_ban(int gia_ban) {
        this.gia_ban = gia_ban;
    }
    public void setTac_gia(String tac_gia) {
        this.tac_gia = tac_gia;
    }
    public void setSo_luong(int so_luong) {
        this.so_luong = so_luong;
    }
    public void setAnh_bia(String anh_bia) {
        this.anh_bia = anh_bia;
    }
    public void setGhi_chu(String ghi_chu) {
        this.ghi_chu = ghi_chu;
    }
    public void setNha_cung_cap(String nha_cung_cap) {
        this.nha_cung_cap = nha_cung_cap;
    }
}
