package com.demo;

import javax.persistence.*;

public class EmployeeListener {
    @PrePersist
    public void onPrePersist(Employee employee) {
        System.out.println("pre persist employee: " + employee.getName());
    }

    @PostPersist
    public void onPostPersist(Employee employee) {
        System.out.println("post persist employee: " + employee.getName());
    }

    @PostLoad
    public void onPostLoad(Employee employee) {
        System.out.println("post load employee: " + employee.getName());
    }

    @PreUpdate
    public void onPreUpdate(Employee employee) {
        System.out.println("pre update employee: " + employee.getName());
    }

    @PostUpdate
    public void onPostUpdate(Employee employee) {
        System.out.println("post update employee: " + employee.getName());
    }

    @PreRemove
    public void onPreRemove(Employee employee) {
        System.out.println("pre remove employee: " + employee.getName());
    }

    @PostRemove
    public void onPostRemove(Employee employee) {
        System.out.println("post remove employee: " + employee.getName());
    }
}
