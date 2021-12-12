package com.demo.springdatajdbccrudrepository.Student;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    @Query("SELECT * FROM students")
    List<Student> findAll();

    @Query("SELECT * FROM students WHERE id = :id")
    List<Student> findById(@Param("id") int id);

    @Query("SELECT * FROM students WHERE age = :age")
    List<Student> findByAge(@Param("age") int age);

    @Query("SELECT * FROM students WHERE name = :name")
    List<Student> findByName(@Param("name") String name);

    @Query("SELECT * FROM students WHERE email = :email")
    List<Student> findByEmail(@Param("email") String email);

    @Query("SELECT * FROM students WHERE major = :major")
    List<Student> findByMajor(@Param("major") int major);
}
