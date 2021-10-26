package com.demo;

import com.demo.Pointcuts.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Product product = (Product) applicationContext.getBean("product");

        product.printProductDetails();

        System.out.println(product.toString());
        System.out.println(product.getProductName());

        product.setProductQuantity(5);

        System.out.println(product.getProductQuantity());
    }
}
