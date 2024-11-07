package com.bnpstudio.bookstore.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnpstudio.bookstore.Service.SachService;
import com.bnpstudio.bookstore.dto.SachDetailDto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/sach")
public class SachController {
    @Autowired
    private SachService sachService;

    @GetMapping("/getAll")
    public ResponseEntity<List<SachDetailDto>> getAllSach() {
        return ResponseEntity.ok(sachService.getAllSach());
    }

}
