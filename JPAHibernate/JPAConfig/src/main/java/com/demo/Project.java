package com.demo;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    private String projectName;
    private String projectDomain;
    private LocalDate projectDeadline;

    @ManyToMany(mappedBy = "projects", fetch = FetchType.LAZY)
    private Set<Employee> employeeSet;

    public Project() {
    }

    public Project(Long projectId, String projectName, String projectDomain, LocalDate projectDeadline, Set<Employee> employeeSet) {
        this.projectDomain = projectDomain;
        this.projectDeadline = projectDeadline;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDomain() {
        return projectDomain;
    }

    public void setProjectDomain(String projectDomain) {
        this.projectDomain = projectDomain;
    }

    public LocalDate getProjectDeadline() {
        return projectDeadline;
    }

    public void setProjectDeadline(LocalDate projectDeadline) {
        this.projectDeadline = projectDeadline;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", projectDomain='" + projectDomain + '\'' +
                ", projectDeadline=" + projectDeadline +
                '}';
    }
}
