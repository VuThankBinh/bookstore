package com.bnpstudio.bookstore.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import java.io.File;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:3000")
public class BookImageController {
    
    @Autowired
    private SachService sachService;
    
    @Value("${file.upload-dir}")
    private String uploadDir;
    
    @PostMapping(value = "/image/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResponseObject<SachDetailDto>> uploadBookImage(
            @RequestParam("bookId") Integer bookId,
            @RequestParam("file") MultipartFile file) {
        try {
            // Kiểm tra sách tồn tại
            SachDetailDto sach = sachService.getById(bookId);
            if (sach == null) {
                return ResponseEntity.badRequest().body(
                    new ResponseObject<>(HttpStatus.BAD_REQUEST, "Không tìm thấy sách với ID: " + bookId, null)
                );
            }

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

            // Kiểm tra kích thước file (10MB = 10 * 1024 * 1024 bytes)
            long TEN_MB = 10L * 1024 * 1024; 
            double fileSizeInMB = file.getSize() / (1024.0 * 1024.0);
            if (file.getSize() > TEN_MB) {
                String message = String.format(
                    "Kích thước file không được vượt quá 10MB (File hiện tại: %.2f MB)",
                    fileSizeInMB
                );
                return ResponseEntity.badRequest().body(
                    new ResponseObject<>(HttpStatus.BAD_REQUEST, message, null)
                );
            }

            // Tạo tên file unique
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            
            // Tạo đường dẫn tuyệt đối đến thư mục uploads/images
            String projectRoot = System.getProperty("user.dir");
            String uploadPath = projectRoot + File.separator + "uploads" + File.separator + "images";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            
            // Kiểm tra xem file đã tồn tại hay chưa
            Path filePath = Paths.get(uploadPath + File.separator + fileName);
            // if (Files.exists(filePath)) {
            //     return ResponseEntity.badRequest().body(
            //         new ResponseObject<>(HttpStatus.BAD_REQUEST, "File đã tồn tại, vui lòng đổi tên file", null)
            //     );
            // }
            
            // Lưu file với đường dẫn tuyệt đối
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            
            // Cập nhật database
            sach.setAnhBia(fileName);
            sachService.updateProduct(sach);
            
            return ResponseEntity.ok(
                new ResponseObject<>(HttpStatus.OK, "Upload file thành công", sach)
            );
            
        } catch (IOException e) {
            e.printStackTrace(); // Thêm log để debug
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseObject<>(HttpStatus.INTERNAL_SERVER_ERROR, 
                    "Không thể upload file: " + e.getMessage(), null));
        }
    }

    @DeleteMapping("/{bookId}/image")
    public ResponseEntity<ResponseObject<SachDetailDto>> deleteBookImage(@PathVariable Integer bookId) {
        try {
            // Lấy thông tin sách
            SachDetailDto sach = sachService.getById(bookId);
            
            // Kiểm tra xem sách có ảnh không
            if (sach.getAnhBia() == null || sach.getAnhBia().isEmpty()) {
                return ResponseEntity.badRequest().body(
                    new ResponseObject<>(HttpStatus.BAD_REQUEST, "Sách không có ảnh để xóa", null)
                );
            }

            // Xóa file ảnh từ thư mục uploads/images
            String imagePath = "uploads/images/" + sach.getAnhBia();
            File imageFile = new File(imagePath);
            if (imageFile.exists()) {
                if (!imageFile.delete()) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(new ResponseObject<>(HttpStatus.INTERNAL_SERVER_ERROR, 
                            "Không thể xóa file ảnh", null));
                }
            }

            // Cập nhật database
            sach.setAnhBia(null);
            sachService.updateProduct(sach);

            return ResponseEntity.ok(
                new ResponseObject<>(HttpStatus.OK, "Xóa ảnh thành công", sach)
            );

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ResponseObject<>(HttpStatus.INTERNAL_SERVER_ERROR, 
                    "Lỗi khi xóa ảnh: " + e.getMessage(), null));
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