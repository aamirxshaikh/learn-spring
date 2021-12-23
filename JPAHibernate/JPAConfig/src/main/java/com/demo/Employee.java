package com.demo;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String job;
    private Double salary;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "departmentId", nullable = false)
    private Department department;

    public Employee() {
    }

    public Employee(String firstName, String lastName, String job, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        if (account == null) {
            if (this.account != null) {
                this.account.setEmployee(null);
            }
        } else {
            account.setEmployee(this);
        }

        this.account = account;
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
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                ", account=" + account +
                ", department=" + department +
                '}';
    }
}
