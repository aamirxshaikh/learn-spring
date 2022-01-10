package com.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {
    @Id
    private int id;
    private String name;
    private String model;

    public Car() {
    }

    public Car(int id, String name, String model) {
        this.id = id;
        this.name = name;
        this.model = model;
    }
}
