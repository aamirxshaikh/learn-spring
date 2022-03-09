package com.demo;

public class CategoryAveragePrice {
    private String name;
    private Double averagePrice;

    public CategoryAveragePrice() {
    }

    public CategoryAveragePrice(String name, Double averagePrice) {
        this.name = name;
        this.averagePrice = averagePrice;
    }

    @Override
    public String toString() {
        return "CategoryAveragePrice{" +
                "name='" + name + '\'' +
                ", averagePrice=" + averagePrice +
                '}';
    }
}
