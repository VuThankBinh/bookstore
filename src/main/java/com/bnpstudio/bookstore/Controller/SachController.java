package com.bnpstudio.bookstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnpstudio.bookstore.dto.SachDetailDto;
import com.bnpstudio.bookstore.entity.ResponseObject;
import com.bnpstudio.bookstore.service.SachService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/sach")
public class SachController {
    @Autowired
    private SachService sachService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.ok(sachService.getAll());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseObject> getById(@PathVariable int id) {
        SachDetailDto sachDetailDto = sachService.getById(id);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK, "Tìm thấy sách", sachDetailDto));
    }
}
