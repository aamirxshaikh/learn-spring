package com.demo.AdvicesAOP.XmlConfiguration.Advices;

public class Product {
    int productId;
    String productName;
    float productPrice;
    int productQuantity;

    public Product() {
    }

    public Product(int productId, String productName, float productPrice, int productQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
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
}
