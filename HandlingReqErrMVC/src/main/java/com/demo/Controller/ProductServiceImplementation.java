package com.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService{
    @Autowired
    ProductDAO productDAO;

    @Override
    public List<Product> getProducts() {
        return productDAO.getProducts();
    }
}
