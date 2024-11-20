package com.bnpstudio.bookstore.service;

import java.util.stream.Collectors;
import jakarta.validation.Validator;
import jakarta.validation.ConstraintViolation;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.bnpstudio.bookstore.repository.UserRepository;

import com.bnpstudio.bookstore.entity.UserEntity;
import com.bnpstudio.bookstore.exception.*;
import com.bnpstudio.bookstore.dto.UserDetailDto;
import com.bnpstudio.bookstore.dto.ChangePasswordDto;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Validator validator;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    public UserEntity register(UserDetailDto userDto) {
        System.out.println("hahaha:" + userRepository.findByEmail(userDto.getEmail()));
        System.out.println("hahaha:" + userRepository.existsByEmail(userDto.getEmail()));
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new EmailExistsException("Email đã tồn tại");
        }
        
        UserEntity user = new UserEntity();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setSoDienThoai(userDto.getSoDienThoai());
        // Validate entity
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        if (!violations.isEmpty()) {
            String errorMessages = violations.stream()
            .map(ConstraintViolation::getMessage)
            .collect(Collectors.joining(", "));
            throw new ValidationException(errorMessages);
        }
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(user);
    }
    
    public UserEntity changePassword(String email, ChangePasswordDto passwordDto) {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("Không tìm thấy người dùng");
        }
        
        // Validate mật khẩu cũ
        if (!passwordEncoder.matches(passwordDto.getOldPassword(), user.getPassword())) {
            throw new ValidationException("Mật khẩu cũ không đúng");
        }
        
        // Validate DTO
        Set<ConstraintViolation<ChangePasswordDto>> dtoViolations = validator.validate(passwordDto);
        if (!dtoViolations.isEmpty()) {
            String errorMessages = dtoViolations.stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", "));
            throw new ValidationException(errorMessages);
        }
        
        // Cập nhật mật khẩu mới
        
        // Validate entity
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        if (!violations.isEmpty()) {
            String errorMessages = violations.stream()
            .map(ConstraintViolation::getMessage)
            .collect(Collectors.joining(", "));
            throw new ValidationException(errorMessages);
        }
        if(passwordEncoder.matches(passwordDto.getNewPassword(), user.getPassword())) {
            throw new ValidationException("Mật khẩu mới không được giống mật khẩu cũ");
        }
        user.setPassword(passwordEncoder.encode(passwordDto.getNewPassword()));

        
        return userRepository.save(user);
    }
    
    public UserEntity updateProfile(String email, UserDetailDto userDto) {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("Không tìm thấy người dùng");
        }
        
        user.setName(userDto.getName());
        user.setSoDienThoai(userDto.getSoDienThoai());
        // Validate entity
        Set<ConstraintViolation<UserEntity>> violations = validator.validate(user);
        if (!violations.isEmpty()) {
            String errorMessages = violations.stream()
                .filter(violation -> !violation.getPropertyPath().toString().equals("password"))
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", "));
            if (!errorMessages.isEmpty()) {
                throw new ValidationException(errorMessages);
            }
        }
        return userRepository.save(user);
    }
}
