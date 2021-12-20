package com.demo;

import javax.persistence.*;

@Entity
public class EmployeeAccount {
    @Id
    private Long id;

    private String username;
    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Employee employee;

    public EmployeeAccount() {
    }

    public EmployeeAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "EmployeeAccount{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", employee=" + employee +
                '}';
    }
}
