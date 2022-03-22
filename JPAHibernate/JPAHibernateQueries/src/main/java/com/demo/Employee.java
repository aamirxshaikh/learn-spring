package com.demo;

import javax.persistence.*;

@Entity(name = "Employees")
public class Employee {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    @PrePersist
    public void onPrePersist() {
        System.out.println("pre persist employee: " + name);
    }

    @PostPersist
    public void onPostPersist() {
        System.out.println("post persist employee: " + name);
    }

    @PostLoad
    public void onPostLoad() {
        System.out.println("post load employee: " + name);
    }

    @PreUpdate
    public void onPreUpdate() {
        System.out.println("pre update employee: " + name);
    }

    @PostUpdate
    public void onPostUpdate() {
        System.out.println("post update employee: " + name);
    }

    @PreRemove
    public void onPreRemove() {
        System.out.println("pre remove employee: " + name);
    }

    @PostRemove
    public void onPostRemove() {
        System.out.println("post remove employee: " + name);
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}