package com.demo.AspectConfigAnnotation;

import com.demo.AspectConfigAnnotation.Pointcuts.Product;
import com.demo.AspectConfigAnnotation.Pointcuts.ProductList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextAnnotation.xml");

        Product product1 = (Product) applicationContext.getBean("product1");
        Product product2 = (Product) applicationContext.getBean("product2");

        ProductList productList = (ProductList) applicationContext.getBean("productList");

        product1.getProductDetails();
        product2.getProductDetails();

        productList.getNumberOfProducts();
        productList.getProductList();
    }
}
