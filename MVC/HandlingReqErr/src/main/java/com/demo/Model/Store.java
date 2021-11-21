package com.demo.Model;

import java.io.Serializable;

public class Store implements Serializable {
    public static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public Store(String name) {
        this.id = (long) Math.floor(Math.random() * 100000);
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
