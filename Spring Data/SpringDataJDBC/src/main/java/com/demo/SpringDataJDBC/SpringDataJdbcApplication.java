package com.demo.SpringDataJDBC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringDataJdbcApplication {
	private static EmployeeDAO<Employee> employeeDAO;

	public SpringDataJdbcApplication(EmployeeDAO<Employee> employeeDAO) {
		SpringDataJdbcApplication.employeeDAO = employeeDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJdbcApplication.class, args);

		List<Employee> employees = employeeDAO.list();

		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}
}
