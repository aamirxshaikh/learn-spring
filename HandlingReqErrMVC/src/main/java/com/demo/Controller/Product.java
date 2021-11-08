package com.demo.Controller;

import java.io.Serializable;

public class Product implements Serializable {
    public static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String category;

    public Product(String name, String category) {
        this.id = (long) Math.floor(Math.random() * 100000);
        this.name = name;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
