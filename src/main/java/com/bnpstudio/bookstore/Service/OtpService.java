package com.bnpstudio.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OtpService {
    
    @Autowired
    private EmailService emailService;
    
    // Trong thực tế nên dùng Redis hoặc DB
    private Map<String, OtpData> otpMap = new ConcurrentHashMap<>();
    
    @Data
    @AllArgsConstructor
    private static class OtpData {
        private String otp;
        private LocalDateTime expiryTime;
    }
    
    public void generateAndSendOtp(String email) {
        String otp = generateOtp();
        otpMap.put(email, new OtpData(otp, LocalDateTime.now().plusMinutes(1)));
        emailService.sendOtpEmail(email, otp);
    }
    
    public boolean validateOtp(String email, String otp) {
        OtpData otpData = otpMap.get(email);
        
        if (otpData == null) {
            return false;
        }
        
        if (LocalDateTime.now().isAfter(otpData.getExpiryTime())) {
            otpMap.remove(email);
            return false;
        }
        
        if (!otpData.getOtp().equals(otp)) {
            return false;
        }
        
        otpMap.remove(email);
        return true;
    }
    
    private String generateOtp() {
        return String.format("%06d", new Random().nextInt(999999));
    }
} 