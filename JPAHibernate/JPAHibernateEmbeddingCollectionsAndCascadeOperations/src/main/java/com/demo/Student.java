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
    private Map<Integer, Course> courseMap;

    public Student() {
    }

    public Student(String name, Map<Integer, Course> courseMap) {
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

    public Map<Integer, Course> getCourseMap() {
        return courseMap;
    }

    public void setCourseMap(Map<Integer, Course> courseMap) {
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
