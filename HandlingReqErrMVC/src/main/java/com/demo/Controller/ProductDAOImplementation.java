package com.demo.Controller;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAOImplementation implements ProductDAO {
    @Override
    public List<Product> getProducts() {
        List<Product> productList = new ArrayList<>();

        productList.add(new Product("Product 1", "Electronics"));
        productList.add(new Product("Product 2", "Electronics"));
        productList.add(new Product("Product 3", "Electronics"));

        return productList;
    }
}
