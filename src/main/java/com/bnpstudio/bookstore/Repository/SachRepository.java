package com.bnpstudio.bookstore.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bnpstudio.bookstore.Entity.Sach;

@Repository
public class SachRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Sach> getAllSach() {
        String sql = "SELECT * FROM Sach";
        List<Sach> sachs = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Sach.class));
        return sachs;
    }
}
