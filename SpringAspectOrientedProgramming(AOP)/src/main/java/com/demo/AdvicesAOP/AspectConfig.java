package com.demo.AdvicesAOP;

import com.demo.AdvicesAOP.Advices.Order;
import org.aspectj.lang.JoinPoint;
import org.springframework.context.ApplicationContext;

public class AspectConfig {
    private Order getOrder() {
        ApplicationContext applicationContext = ApplicationContextWrapper.getApplicationContext();

        return (Order) applicationContext.getBean("order");
    }

    public void printMethodName(JoinPoint joinPoint) {
        System.out.println("Called by : " + joinPoint.getSignature().getName());
    }

    public void printOrderValue() {
        Order order = getOrder();

        System.out.println("============================");

        System.out.println("Order Total : " + order.getOrderValue());

        System.out.println("============================");
    }
}
