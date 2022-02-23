package com.demo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity(name = "ContractEmployees")
public class ContractEmployee extends Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer hourlyPay;

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

    @Override
    public String toString() {
        return "ContractEmployee{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", hourlyPay=" + hourlyPay +
                '}';
    }
}
