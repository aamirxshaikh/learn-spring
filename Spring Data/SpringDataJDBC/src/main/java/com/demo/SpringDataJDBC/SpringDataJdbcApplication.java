package com.demo.SpringDataJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class SpringDataJdbcApplication implements CommandLineRunner {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		create

//		String sql = "CREATE TABLE IF NOT EXISTS employees (id int PRIMARY KEY, first_name varchar(100), last_name varchar(100), email varchar(100))";
//
//		jdbcTemplate.execute(sql);

//		insert

//		String sql = "INSERT INTO employees VALUES (?, ?, ?, ?)";
//
//		jdbcTemplate.update(sql, 1, "John", "Doe", "jdoe@test.com");
//		jdbcTemplate.update(sql, 2, "Jane", "Doe", "janedoe@test.com");

//		update

//		String sql = "UPDATE employees SET email = ? WHERE id = ?";
//
//		jdbcTemplate.update(sql, "johndoe@test.com", 1);

//		select

//		String sql = "SELECT * FROM employees";
//
//		List employees = jdbcTemplate.queryForList(sql);
//
//		for (Object employee : employees) {
//			System.out.println(employee);
//		}

//		delete

		String sql = "DELETE FROM employees WHERE id = ?";

		jdbcTemplate.update(sql, 1);

		sql = "SELECT * FROM employees";

		List employees = jdbcTemplate.queryForList(sql);

		for (Object employee : employees) {
			System.out.println(employee);
		}
	}
}
