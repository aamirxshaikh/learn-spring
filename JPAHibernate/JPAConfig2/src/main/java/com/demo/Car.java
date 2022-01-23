package com.demo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(value = CarCompositeKey.class)
public class Car {
    @Id
    private Integer nameHash;

    @Id
    private Integer modelHash;

    @Id
    @Column(precision = 7, scale = 4)
    private Float price;

    @Column(nullable = false, name = "car_name", columnDefinition = "VARCHAR(50)")
    private String name;

    @Column(nullable = false, unique = true, name = "car_model", length = 55)
    private String model;

    @Column(name = "car_owner", columnDefinition = "VARCHAR(50)")
    private String owner;

    @Transient
    private boolean isAvailable;

    public Car() {
    }

    public Car(String name, String model, String owner, Float price) {
        this.name = name;
        this.model = model;
        this.owner = owner;
        this.nameHash = Objects.hash(name);
        this.modelHash = Objects.hash(model);
        this.price = price;
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
