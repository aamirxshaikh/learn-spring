package com.demo.SpringDataJDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDAOImpl implements EmployeeDAO<Employee> {
    private final JdbcTemplate jdbcTemplate;

    public EmployeeDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<Employee> rowMap = (resultSet, rowNum) -> {
        Employee employees = new Employee();

        employees.setId(resultSet.getInt("id"));
        employees.setFirstName(resultSet.getString("first_name"));
        employees.setLastName(resultSet.getString("last_name"));
        employees.setEmail(resultSet.getString("email"));

        return employees;
    };

    @Override
    public List<Employee> list() {
        String sql = "SELECT * FROM employees";

        return jdbcTemplate.query(sql, rowMap);
    }
}
