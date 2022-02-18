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
    @CollectionTable(name = "Student_Courses")
    @MapKeyJoinColumn(name = "course_id")
    @Column(name = "course_code")
    private Map<Course, Integer> courseMap;

    public Student() {
    }

    public Student(String name, Map<Course, Integer> courseMap) {
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

    public Map<Course, Integer> getCourseMap() {
        return courseMap;
    }

    public void setCourseMap(Map<Course, Integer> courseMap) {
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
