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

        productList.printNumberOfProducts();
        productList.displayProductList();

        product1.printProductDetails();
        product2.printProductDetails();

        System.out.println("Calling setter");

        product1.setProductQuantity(10);
    }
}
