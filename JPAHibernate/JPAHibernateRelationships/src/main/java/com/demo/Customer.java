package com.demo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "Customers")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany
    @JoinTable(name = "Customers_Products",
    joinColumns = { @JoinColumn(name = "customer_id", referencedColumnName = "id") },
    inverseJoinColumns = { @JoinColumn(name = "product_id", referencedColumnName = "id") })
    private List<Product> products;

    @OneToMany
    private List<Order> orders;

    public Customer() {
    }

    public Customer(String name, List<Product> products, List<Order> orders) {
        this.name = name;
        this.products = products;
        this.orders = orders;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products=" + products +
                ", orders=" + orders +
                '}';
    }
}
