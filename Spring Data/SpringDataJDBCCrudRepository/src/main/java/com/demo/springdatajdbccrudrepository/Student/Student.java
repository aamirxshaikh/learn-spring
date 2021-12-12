package com.demo.springdatajdbccrudrepository.Student;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("students")
public class Student {
    @Id
    @Column("id")
    private Integer id;

    @Column("age")
    private Integer age;

    @Column("name")
    private String name;

    @Column("email")
    private String email;

    @Column("major")
    private int major;

    public Student() {
    }

    public Student(Integer id, Integer age, String name, String email, int major) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.email = email;
        this.major = major;
    }

    public static Student create(Integer id,  Integer age, String name, String email, int major) {
        return new Student(id, age, name, email, major);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", major=" + major +
                '}';
    }
}