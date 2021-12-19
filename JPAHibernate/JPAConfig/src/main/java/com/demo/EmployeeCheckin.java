package com.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@IdClass(EmployeeCheckinComposite.class)
public class EmployeeCheckin {
    @Id
    private int employeeId;

    @Id
    private LocalDate checkinDate;

    LocalTime checkinTime;

    public EmployeeCheckin() {
    }

    public EmployeeCheckin(int employeeId, LocalDate checkinDate, LocalTime checkinTime) {
        this.employeeId = employeeId;
        this.checkinDate = checkinDate;
        this.checkinTime = checkinTime;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDate getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(LocalDate checkinDate) {
        this.checkinDate = checkinDate;
    }

    public LocalTime getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(LocalTime checkinTime) {
        this.checkinTime = checkinTime;
    }

    @Override
    public String toString() {
        return "EmployeeCheckin{" +
                "employeeId=" + employeeId +
                ", checkinDate=" + checkinDate +
                ", checkinTime=" + checkinTime +
                '}';
    }
}
