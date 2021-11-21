package com.demo.Service;

import com.demo.DAO.ProductDAO;
import com.demo.Model.Product;
import com.demo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {
    @Autowired
    ProductDAO productDAO;

    @Override
    public List<Product> getProducts() {
        return productDAO.getProducts();
    }
}
