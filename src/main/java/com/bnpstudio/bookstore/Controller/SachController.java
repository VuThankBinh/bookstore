package com.bnpstudio.bookstore.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnpstudio.bookstore.Model.SachModel;
import com.bnpstudio.bookstore.Service.SachService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/sach")
public class SachController {
    private final SachService sachService;

    public SachController(SachService sachService) {
        this.sachService = sachService;
    }

    @GetMapping("/getAllSach")
    public ResponseEntity<List<SachModel>> getAllSach() {
        return ResponseEntity.ok(sachService.getAllSach());
    }

}
