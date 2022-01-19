package com.demo;

import javax.persistence.*;

@Entity
public class Car {
    @Id
//    auto sequence generator
//    @GeneratedValue(strategy = GenerationType.AUTO)

//    database AUTO_INCREMENT
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

//    manual sequence generator
//    @SequenceGenerator(name = "seq", sequenceName = "SEQ")
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")

//    table generator
    @TableGenerator(name = "generator",
        table = "Seq",
        pkColumnName = "gen_name",
            pkColumnValue = "car_id",
            valueColumnName = "gen_val",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "generator")
    private Integer id;
    private String name;
    private String model;
    private String owner;

    public Car() {
    }

    public Car(String name, String model, String owner) {
        this.name = name;
        this.model = model;
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
