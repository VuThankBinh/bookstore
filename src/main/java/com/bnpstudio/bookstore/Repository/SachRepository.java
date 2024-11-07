package com.bnpstudio.bookstore.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bnpstudio.bookstore.Entity.SachEntity;

@Repository
public interface SachRepository extends CrudRepository<SachEntity, Integer> {

    public List<SachEntity> getAllSach() {
        String sql = "SELECT * FROM Sach";
        List<SachEntity> sachs = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(SachEntity.class));
        return sachs;
    }
}
