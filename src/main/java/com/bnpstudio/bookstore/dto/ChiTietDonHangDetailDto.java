package com.bnpstudio.bookstore.dto;

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
   
       
}
