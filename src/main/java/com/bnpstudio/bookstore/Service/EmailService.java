package com.bnpstudio.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;

@Service
@Slf4j
public class EmailService {
    
    @Autowired
    private JavaMailSender mailSender;
    
    public void sendOtpEmail(String email, String otp) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            
            helper.setFrom("your-email@gmail.com");
            helper.setTo(email);
            helper.setSubject("Mã xác nhận OTP");
            
            String content = String.format("""
                <div>
                    <h1>Xác nhận email của bạn</h1>
                    <h2 style="color: #4CAF50; font-size: 24px;">${otp}</h2>
                    <p>Mã này sẽ hết hạn trong 1 phút.</p>
                </div>
                """);
            
            helper.setText(content, true);
            mailSender.send(message);
            
        } catch (Exception e) {
            log.error("Lỗi khi gửi email: ", e);
            throw new RuntimeException("Không thể gửi email");
        }
    }
} 