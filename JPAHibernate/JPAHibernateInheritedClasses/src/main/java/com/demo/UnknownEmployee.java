package com.demo;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("not null")
public class UnknownEmployee extends Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    public UnknownEmployee() {
    }

    public UnknownEmployee(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "UnknownEmployee{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                '}';
    }
}
