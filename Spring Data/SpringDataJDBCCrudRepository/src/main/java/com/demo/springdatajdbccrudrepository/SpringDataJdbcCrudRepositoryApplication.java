package com.demo.springdatajdbccrudrepository;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJdbcCrudRepositoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJdbcCrudRepositoryApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(StudentRepository studentRepository) {
        return args -> {
            Student student1 = new Student(null, 18, "John", "john@gmail.com");
            Student student2 = new Student(null, 20, "Jane", "jane@gmail.com");

            System.out.println(studentRepository.save(student1));
            System.out.println(studentRepository.save(student2));
        };
    }
}
