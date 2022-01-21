package com.demo;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    private CarCompositeKey carCompositeKey;

    private String name;
    private String model;
    private String owner;

    public Car() {
    }

    public Car(String name, String model, String owner, Float price) {
        this.carCompositeKey = new CarCompositeKey(name, model, price);
        this.name = name;
        this.model = model;
        this.owner = owner;
    }

    public CarCompositeKey getCarCompositeKey() {
        return carCompositeKey;
    }

    public void setCarCompositeKey(CarCompositeKey carCompositeKey) {
        this.carCompositeKey = carCompositeKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
