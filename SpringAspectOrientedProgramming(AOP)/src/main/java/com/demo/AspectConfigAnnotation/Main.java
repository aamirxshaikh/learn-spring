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

        Product product3 = new Product();

        product3.setProductId(3);
        product3.setProductName("Product 3");
        product3.setProductPrice(159.99F);
        product3.setProductQuantity(2);

        Product product4 = new Product();

        product4.setProductId(4);
        product4.setProductName("Product 4");
        product4.setProductPrice(1559.99F);
        product4.setProductQuantity(1);

        productList.addProductToList(product3);
        System.out.println();
        productList.addProductToListAtIndex(0, product4);
        System.out.println();
        productList.getProductList();
    }
}
