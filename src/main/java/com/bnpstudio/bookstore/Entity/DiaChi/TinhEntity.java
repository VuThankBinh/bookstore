package com.bnpstudio.bookstore.entity.DiaChi;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TinhEntity {
    @JsonProperty("Id")
    private String id;
    
    @JsonProperty("Name")
    private String name;
    
    @JsonProperty("Districts")
    private List<HuyenEntity> districts;
} 