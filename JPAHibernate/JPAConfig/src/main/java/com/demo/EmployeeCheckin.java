package com.demo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class EmployeeCheckin {
    @EmbeddedId
    EmployeeCheckinComposite employeeCheckinComposite;
    LocalTime checkinTime;

    public EmployeeCheckin() {
    }

    public EmployeeCheckin(int employeeId, LocalDate checkinDate, LocalTime checkinTime) {
        this.employeeCheckinComposite = new EmployeeCheckinComposite(employeeId, checkinDate);
        this.checkinTime = checkinTime;
    }

    public EmployeeCheckinComposite getEmployeeCheckinComposite() {
        return employeeCheckinComposite;
    }

    public void setEmployeeCheckinComposite(EmployeeCheckinComposite employeeCheckinComposite) {
        this.employeeCheckinComposite = employeeCheckinComposite;
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
                "employeeCheckinComposite=" + employeeCheckinComposite +
                ", checkinTime=" + checkinTime +
                '}';
    }
}
