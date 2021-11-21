package com.demo.DAO;

import com.demo.DAO.ProductDAO;
import com.demo.Model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAOImplementation implements ProductDAO {
    @Override
    public List<Product> getProducts() {
        List<Product> productList = new ArrayList<>();

        productList.add(new Product("Product1", "Electronics"));
        productList.add(new Product("Product2", "Electronics"));
        productList.add(new Product("Product3", "Electronics"));

        return productList;
    }
}
