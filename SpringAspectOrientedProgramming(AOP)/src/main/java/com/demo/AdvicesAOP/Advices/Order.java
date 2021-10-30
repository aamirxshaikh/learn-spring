package com.demo.AdvicesAOP.Advices;

import java.util.Map;

public class Order {
    private int orderId;
    private String orderBy;
    private String orderAddress;
    private Map<Product, Integer> orderProducts;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public Map<Product, Integer> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Map<Product, Integer> orderProducts) {
        this.orderProducts = orderProducts;
    }

//    concern/join point

    public void displayOrderProducts() {
//        if(orderProducts.isEmpty()) {
//            throw new IllegalStateException("No products in the cart");
//        }

        System.out.println("--------------------------------------------");

        System.out.println("OrderID " + orderId + " OrderBy " + orderBy);

        for (Map.Entry<Product, Integer> productIntegerEntry : orderProducts.entrySet()) {
            System.out.println("Product Name " + productIntegerEntry.getKey().productName + " Price " + productIntegerEntry.getKey().productPrice + " Quantity " + productIntegerEntry.getValue());
        }

        System.out.println("OrderAddress " + orderAddress);

        System.out.println("--------------------------------------------");
    }

//    concern/join point

    public float getOrderValue() {
        float totalPrice = 0F;

        if(! (orderProducts.isEmpty())) {
            for (Map.Entry<Product, Integer> productIntegerEntry : orderProducts.entrySet()) {
                totalPrice += productIntegerEntry.getKey().productPrice * productIntegerEntry.getValue();
            }
        }

        return totalPrice;
    }
}
