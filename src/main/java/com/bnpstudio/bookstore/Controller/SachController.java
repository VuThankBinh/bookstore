package com.bnpstudio.bookstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnpstudio.bookstore.dto.SachDetailDto;
import com.bnpstudio.bookstore.entity.ResponseObject;
import com.bnpstudio.bookstore.service.SachService;

import org.springframework.web.bind.annotation.RequestBody;

import com.bnpstudio.bookstore.exception.BadRequestException;
import com.bnpstudio.bookstore.exception.NotFoundException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/sach")
public class SachController {
    @Autowired
    private SachService sachService;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @GetMapping("/getAll")
    public <T> ResponseEntity<ResponseObject<List<SachDetailDto>>> getAll() {
        return ResponseEntity.ok(
                new ResponseObject(
                        HttpStatus.OK,
                        "Get tất cả lĩnh vực thành công",
                        sachService.getAll()));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping({ "/getById/{id}", "/getById/" })
    public ResponseEntity<ResponseObject<SachDetailDto>> getById(@PathVariable(required = false) Integer id) {
        if (id == null) {
            throw new BadRequestException("id is null");
        }
        if (id < 1) {
            throw new BadRequestException("id < 1");
        }
        SachDetailDto sachDetailDto = sachService.getById(id);
        return ResponseEntity.ok(new ResponseObject(HttpStatus.OK, "Tìm thấy sách", sachDetailDto));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping("/getByName/{name}")
    ResponseEntity<ResponseObject<List<SachDetailDto>>> getByName(@PathVariable String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<SachDetailDto> sachs = sachService.findByName(pageable, name);
        if (sachs.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject(HttpStatus.OK, "query product succsessfully", sachs));
        } else {
            throw new NotFoundException("cannot found product with name= " + name); 
        }
    }


    // @PostMapping("/getByNameAndTacGia")
    // List<SachDetailDto> getByNameAndTacGia(@RequestBody SachDetailDto sach) {
    // System.out.println("phg:" + sach.getTenSach());
    // try {
    // List<SachDetailDto> sachs = sachService.findProduct(sach);
    // return sachs;

    // } catch (Exception e) {
    // throw e;
    // }
    // }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PostMapping("/insert")
    ResponseEntity<ResponseObject<SachDetailDto>> insertSach(@RequestBody SachDetailDto sach) {
        System.out.println("phg:" + sach.getTenSach());
        try {
            SachDetailDto sachs = sachService.insertProduct(sach);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseObject(HttpStatus.OK, "insert product successfully", sachs));

        } catch (Exception e) {
            throw e;
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PutMapping("/update")
    ResponseEntity<ResponseObject<SachDetailDto>> UpdateSach(@RequestBody SachDetailDto sach) {
        System.out.println("phg:" + sach.getTenSach());
        try {
            SachDetailDto sachs = sachService.updateProduct(sach);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseObject(HttpStatus.OK, "insert product successfully", sachs));

        } catch (Exception e) {
            throw e;
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @DeleteMapping("/delete/{id}")
    ResponseEntity<ResponseObject<String>> deleteSach(@PathVariable Integer id) {
        try {
            sachService.deleteProduct(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseObject(HttpStatus.OK, "Xóa sách thành công", "xóa thành công"));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseObject(HttpStatus.NOT_FOUND, e.getMessage(), "lỗi"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseObject(HttpStatus.INTERNAL_SERVER_ERROR, "Lỗi khi xóa sách: " + e.getMessage(),
                            "lỗi"));
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @GetMapping("/getSachPaging")
    public ResponseEntity<ResponseObject<List<SachDetailDto>>> getAllPaging(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Pageable paging = PageRequest.of(page, size);
            List<SachDetailDto> sachPage = sachService.getAllPaging(paging);

            return ResponseEntity.ok(new ResponseObject(
                    HttpStatus.OK,
                    "Lấy danh sách sách thành công",
                    sachPage));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseObject(
                            HttpStatus.INTERNAL_SERVER_ERROR,
                            "Lỗi khi lấy danh sách sách: " + e.getMessage(),
                            null));
        }
    }
}
