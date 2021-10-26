package com.demo.AspectConfigAnnotation.Pointcuts;

import java.util.List;

public class ProductList {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

//    concern/join point
    public void getNumberOfProducts() {
        System.out.println("getNumberOfProducts()");

        System.out.println("Number of products : " + products.size());
    }

//    concern/join point
    public void getProductList() {
        System.out.println("getProductList()");

        System.out.println("ID " + " Name" + " Price" + " Quantity");

        for (Product product : products) {
            System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getProductPrice() + " " + product.getProductQuantity());
        }
    }
}
