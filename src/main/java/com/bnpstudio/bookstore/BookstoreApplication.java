package com.bnpstudio.bookstore;

import java.sql.CallableStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.bnpstudio.bookstore.Entity.SachEntity;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// String sql = "select * from Sach";
		// List<Book> books = jdbcTemplate.query(sql,
		// 	BeanPropertyRowMapper.newInstance(Sach.class)
		// );
		// books.forEach(System.out::println);

		// List<Book> books2 = jdbcTemplate.query(connection -> {
		// 	CallableStatement callableStatement = connection.prepareCall("{call GetBookById(?)}");
		// 	callableStatement.setInt("id", 1);
		// 	return callableStatement;
		// }, BeanPropertyRowMapper.newInstance(Book.class));
		// books2.forEach(System.out::println);
	}
}
