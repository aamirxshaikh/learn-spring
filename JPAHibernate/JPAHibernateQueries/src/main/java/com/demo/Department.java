package com.demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Departments")
public class Department implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Set<Employee> employees;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    @PrePersist
    public void onPrePersist() {
        System.out.println("pre persist department: " + name);
    }

    @PostPersist
    public void onPostPersist() {
        System.out.println("post persist department: " + name);
    }

    @PostLoad
    public void onPostLoad() {
        System.out.println("post load department: " + name);
    }

    @PreUpdate
    public void onPreUpdate() {
        System.out.println("pre update department: " + name);
    }

    @PostUpdate
    public void onPostUpdate() {
        System.out.println("post update department: " + name);
    }

    @PreRemove
    public void onPreRemove() {
        System.out.println("pre remove department: " + name);
    }

    @PostRemove
    public void onPostRemove() {
        System.out.println("post remove department: " + name);
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

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        if (employees == null) {
            employees = new HashSet<>();
        }

        employees.add(employee);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employees=" + employees +
                '}';
    }
}