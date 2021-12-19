package com.demo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class EmployeeCheckinComposite implements Serializable {
    private int employeeId;
    private LocalDate checkinDate;

    public EmployeeCheckinComposite() {
    }

    public EmployeeCheckinComposite(int employeeId, LocalDate checkinDate) {
        this.employeeId = employeeId;
        this.checkinDate = checkinDate;
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

    @Override
    public String toString() {
        return "EmployeeCheckinComposite{" +
                "employeeId=" + employeeId +
                ", checkinDate=" + checkinDate +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(! (obj instanceof EmployeeCheckinComposite)) {
            return false;
        }

        EmployeeCheckinComposite checkinId = (EmployeeCheckinComposite) obj;

        return ((checkinId.getEmployeeId() == this.getEmployeeId()) &&
                (checkinId.getCheckinDate().equals(this.getCheckinDate())));
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, checkinDate);
    }
}
