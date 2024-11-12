package com.bnpstudio.bookstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnpstudio.bookstore.repository.DonHangRepository;

@Service
public class DonHangService {
    @Autowired
    DonHangRepository donHangRepository;
    
}
