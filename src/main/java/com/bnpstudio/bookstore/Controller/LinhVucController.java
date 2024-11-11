package com.bnpstudio.bookstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnpstudio.bookstore.dto.LinhVucDto;
import com.bnpstudio.bookstore.entity.ResponseObject;
import com.bnpstudio.bookstore.service.LinhVucService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/linhVuc")
public class LinhVucController {
    @Autowired
    private LinhVucService linhVucService;

    @GetMapping("/getAll")
    public ResponseEntity<ResponseObject> getAll() {
        return ResponseEntity.ok(
                new ResponseObject(
                        HttpStatus.OK,
                        "Get tất cả lĩnh vực thành công",
                        linhVucService.getAll()));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseObject> getById(@PathVariable int id) {
        return ResponseEntity.ok(
                new ResponseObject(
                        HttpStatus.OK,
                        "Get lĩnh vực có id = " + id + " thành công",
                        linhVucService.getById(id)));
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> insertLinhVuc(@RequestBody LinhVucDto linhVuc) {
        return ResponseEntity.ok(
                new ResponseObject(
                        HttpStatus.OK,
                        "Thêm lĩnh vực thành công",
                        linhVucService.insertLinhVuc(linhVuc)));
    }

}
