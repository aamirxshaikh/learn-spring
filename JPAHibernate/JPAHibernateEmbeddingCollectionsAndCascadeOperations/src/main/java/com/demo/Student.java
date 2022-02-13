package com.demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

@Entity(name = "Students")
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "Courses")
    @MapKeyColumn(name = "course_id")
    @Column(name = "course_name")
    private Map<Integer, String> courseMap;

    public Student() {
    }

    public Student(String name, Map<Integer, String> courseMap) {
        this.name = name;
        this.courseMap = courseMap;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, String> getCourseMap() {
        return courseMap;
    }

    public void setCourseMap(Map<Integer, String> courseMap) {
        this.courseMap = courseMap;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courseMap=" + courseMap +
                '}';
    }
}
