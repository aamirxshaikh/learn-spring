package com.demo.SpringDataJDBC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringDataJdbcApplication {
	private static EmployeeDAO<Employee> employeeDAO;

	public SpringDataJdbcApplication(EmployeeDAO<Employee> employeeDAO) {
		SpringDataJdbcApplication.employeeDAO = employeeDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJdbcApplication.class, args);

		List<Employee> employees = employeeDAO.list();

		System.out.println("Employees");

		for (Employee employee : employees) {
			System.out.println(employee);
		}

		System.out.println("Employee");

		Optional<Employee> employee = employeeDAO.getById(1);
		System.out.println(employee);
	}
}
