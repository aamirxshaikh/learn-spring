package com.demo.CoreAOP.AspectConfigAnnotation;

import com.demo.CoreAOP.AspectConfigAnnotation.Pointcuts.Product;
import com.demo.CoreAOP.AspectConfigAnnotation.Pointcuts.ProductList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("CoreAOP/applicationContextAnnotation.xml");

        Product product1 = (Product) applicationContext.getBean("product1");
        Product product2 = (Product) applicationContext.getBean("product2");

        ProductList productList = (ProductList) applicationContext.getBean("productList");

        productList.printNumberOfProducts();
        productList.displayProductList();

        product1.printProductDetails();
        product2.printProductDetails();
    }
}
