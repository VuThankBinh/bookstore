package com.bnpstudio.bookstore.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
// ... existing imports ...
import com.bnpstudio.bookstore.service.SachService;
import com.bnpstudio.bookstore.dto.SachDetailDto;
import com.bnpstudio.bookstore.entity.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookImageController {
    
    @Autowired
    private SachService sachService;
    
    @Value("${file.upload-dir}")
    private String uploadDir;
    
    @PostMapping("/{bookId}/image")
    public ResponseEntity<ResponseObject<SachDetailDto>> uploadBookImage(
            @PathVariable Integer bookId,
            @RequestParam("file") MultipartFile[] files) {
        try {
            // Kiểm tra số lượng file
            if (files.length > 1) {
                return ResponseEntity.badRequest().body(
                    new ResponseObject<>(HttpStatus.BAD_REQUEST, "Chỉ được phép upload 1 file ảnh", null)
                );
            }

            MultipartFile file = files[0];
            
            // Kiểm tra null
            if (file == null) {
                return ResponseEntity.badRequest().body(
                    new ResponseObject<>(HttpStatus.BAD_REQUEST, "Vui lòng chọn file", null)
                );
            }

            // Kiểm tra file rỗng
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body(
                    new ResponseObject<>(HttpStatus.BAD_REQUEST, "File không được để trống", null)
                );
            }

            // Kiểm tra định dạng file
            if (!isImageFile(file)) {
                return ResponseEntity.badRequest().body(
                    new ResponseObject<>(HttpStatus.BAD_REQUEST, 
                        "Chỉ chấp nhận file ảnh có định dạng: jpg, jpeg, png, gif, bmp, webp", null)
                );
            }
            System.out.println("123: " + file.getSize());
            // Log thông tin file để debug
            double fileSizeInMB = file.getSize() / (1024.0 * 1024.0);
            System.out.println("=== File Information ===");
            System.out.println("File name: " + file.getOriginalFilename());
            System.out.println("File size (bytes): " + file.getSize());
            System.out.println("File size (MB): " + String.format("%.2f", fileSizeInMB));
            System.out.println("Content type: " + file.getContentType());

            // Kiểm tra kích thước file (10MB = 10 * 1024 * 1024 bytes)
            long TEN_MB = 10L * 1024 * 1024; // 10MB in bytes
            if (file.getSize() > TEN_MB) {
                String message = String.format(
                    "Kích thước file không được vượt quá 10MB (File hiện tại: %.2f MB)",
                    fileSizeInMB
                );
                System.out.println("Size validation failed: " + message);
                return ResponseEntity.badRequest().body(
                    new ResponseObject<>(HttpStatus.BAD_REQUEST, message, null)
                );
            }

            // Tạo tên file unique
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            
            // Tạo đường dẫn
            Path uploadPath = Paths.get(uploadDir);
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            
            // Lưu file
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            
            // Tạo đường dẫn file
            String fileUrl = "/images/" + fileName;

            // Cập nhật database
            SachDetailDto sach = sachService.getById(bookId);
            sach.setAnhBia(fileUrl);
            sachService.updateProduct(sach);
            
            return ResponseEntity.ok(
                new ResponseObject<>(HttpStatus.OK, "Upload file thành công", sach)
            );
            
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseObject<>(HttpStatus.INTERNAL_SERVER_ERROR, 
                    "Không thể upload file: " + e.getMessage(), null));
        }
    }

    private boolean isImageFile(MultipartFile file) {
        // Kiểm tra contentType
        String contentType = file.getContentType();
        if (contentType == null) return false;
        
        // Kiểm tra extension của file
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null) return false;
        
        // Danh sách các định dạng file cho phép
        List<String> allowedExtensions = Arrays.asList(
            "jpg", "jpeg", "png", "gif", "bmp", "webp"
        );
        
        // Lấy extension từ tên file
        String extension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();
        
        // Kiểm tra cả contentType và extension
        return contentType.startsWith("image/") && allowedExtensions.contains(extension);
    }
} 