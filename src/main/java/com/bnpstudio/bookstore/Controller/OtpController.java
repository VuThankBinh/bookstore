package com.bnpstudio.bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.bnpstudio.bookstore.dto.OtpRequest;
import org.springframework.http.ResponseEntity;
import com.bnpstudio.bookstore.service.OtpService;
import com.bnpstudio.bookstore.entity.ResponseObject;
import com.bnpstudio.bookstore.dto.OtpValidationRequest;

// import java.util.Map;

@RestController
@RequestMapping("/api/otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @PostMapping("/send")
    public ResponseEntity<ResponseObject<String>> sendOtp(@RequestBody OtpRequest request) {
        try {
            otpService.generateAndSendOtp(request.getEmail());
            return ResponseEntity.ok(
                    new ResponseObject(
                            HttpStatus.OK,
                            "OTP đã được gửi đến email của bạn",
                            ""));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(
                            new ResponseObject(
                                    HttpStatus.INTERNAL_SERVER_ERROR,
                                    "Không thể gửi OTP",
                                    ""));
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @PostMapping("/verify")
    public ResponseEntity<ResponseObject<String>> verifyOtp(@RequestBody OtpValidationRequest request) {
        boolean isValid = otpService.validateOtp(request.getEmail(), request.getOtp());

        if (isValid) {
            return ResponseEntity.ok(
                    new ResponseObject(
                            HttpStatus.OK,
                            "Xác thực OTP thành công",
                            ""));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseObject(
                            HttpStatus.BAD_REQUEST,
                            "OTP không hợp lệ hoặc đã hết hạn",
                            ""));
        }
    }
}