package com.demo.AspectConfigAnnotation.Pointcuts;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
    private int productId;
    private String productName;
    private float productPrice;
    private int productQuantity;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                '}';
    }

//    concern/join point
    public void printProductDetails() {
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy - HH:mm:ss");
        Date date = new Date();

        System.out.format("Product details : \n Product : %s \n At : %s \n %s \n", getProductName(), formatter.format((date)), toString());
    }
}
