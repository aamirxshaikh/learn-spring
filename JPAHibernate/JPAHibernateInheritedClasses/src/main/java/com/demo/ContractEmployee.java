package com.demo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity(name = "ContractEmployees")
public class ContractEmployee extends Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer hourlyPay;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    public ContractEmployee() {
    }

    public ContractEmployee(String name, Integer hourlyPay) {
        super(name);
        this.hourlyPay = hourlyPay;
    }

    public Integer getHourlyPay() {
        return hourlyPay;
    }

    public void setHourlyPay(Integer hourlyPay) {
        this.hourlyPay = hourlyPay;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "ContractEmployee{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", hourlyPay=" + hourlyPay +
                '}';
    }
}
