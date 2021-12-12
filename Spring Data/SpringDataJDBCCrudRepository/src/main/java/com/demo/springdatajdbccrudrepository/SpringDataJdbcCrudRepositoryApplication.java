package com.demo.springdatajdbccrudrepository;

import com.demo.springdatajdbccrudrepository.Major.Major;
import com.demo.springdatajdbccrudrepository.Major.MajorRepository;
import com.demo.springdatajdbccrudrepository.Student.Student;
import com.demo.springdatajdbccrudrepository.Student.StudentRepository;
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
    ApplicationRunner applicationRunner(StudentRepository studentRepository, MajorRepository majorRepository) {
        return args -> {
//            Student

            Student student1 = new Student(null, 18, "John", "john@gmail.com", 1);
            Student student2 = new Student(null, 20, "Jane", "jane@gmail.com", 2);

//            insert

//            System.out.println(studentRepository.save(student1));
//            System.out.println(studentRepository.save(student2));

//            select/find all

            System.out.println(studentRepository.findAll());

//            find by

            System.out.println(studentRepository.findById(1));
            System.out.println(studentRepository.findByAge(18));
            System.out.println(studentRepository.findByName("John"));
            System.out.println(studentRepository.findByEmail("john@gmail.com"));
            System.out.println(studentRepository.findByMajor(1));

//            Major

            Major major1 = Major.addMajor(null, "History");
            Major major2 = Major.addMajor(null, "Psychology");

//            insert

//            System.out.println(majorRepository.save(major1));
//            System.out.println(majorRepository.save(major2));

//            select/find all

            System.out.println(majorRepository.findAll());

//            find by

            System.out.println(majorRepository.findById(2L));
            System.out.println(majorRepository.findByName("History"));
        };
    }
}
