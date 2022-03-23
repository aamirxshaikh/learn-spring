package com.demo;

import javax.persistence.*;

public class DepartmentListener {
    @PrePersist
    public void onPrePersist(Department department) {
        System.out.println("pre persist employee: " + department.getName());
    }

    @PostPersist
    public void onPostPersist(Department department) {
        System.out.println("post persist employee: " + department.getName());
    }

    @PostLoad
    public void onPostLoad(Department department) {
        System.out.println("post load employee: " + department.getName());
    }

    @PreUpdate
    public void onPreUpdate(Department department) {
        System.out.println("pre update employee: " + department.getName());
    }

    @PostUpdate
    public void onPostUpdate(Department department) {
        System.out.println("post update employee: " + department.getName());
    }

    @PreRemove
    public void onPreRemove(Department department) {
        System.out.println("pre remove employee: " + department.getName());
    }

    @PostRemove
    public void onPostRemove(Department department) {
        System.out.println("post remove employee: " + department.getName());
    }
}
