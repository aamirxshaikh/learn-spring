package com.demo.AdvicesAOP.AnnotationConfiguration;

import com.demo.AdvicesAOP.AnnotationConfiguration.Advices.Order;
import com.demo.AdvicesAOP.AnnotationConfiguration.Advices.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.HashMap;
import java.util.Map;

@ComponentScan(basePackages = "com.demo.AdvicesAOP.AnnotationConfiguration")
@Configuration
@EnableAspectJAutoProxy

public class BeanConfig {
    @Bean(name = "order")
    public Order order() {
        Order order = new Order();

        order.setOrderId(1);
        order.setOrderBy("Aamir");
        order.setOrderAddress("xyz, 101");

        Product product1 = new Product(1, "Product 1", 99.99F, 3);
        Product product2 = new Product(1, "Product 2", 199.99F, 3);

        Map<Product, Integer> orderProducts = new HashMap<>();

        orderProducts.put(product1, 2);
        orderProducts.put(product2, 6);

        order.setOrderProducts(orderProducts);

        return order;
    }
}
