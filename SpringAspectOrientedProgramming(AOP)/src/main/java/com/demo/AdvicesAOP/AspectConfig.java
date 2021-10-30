package com.demo.AdvicesAOP;

import com.demo.AdvicesAOP.Advices.Order;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.context.ApplicationContext;

public class AspectConfig {
    private Order getOrder() {
        ApplicationContext applicationContext = ApplicationContextWrapper.getApplicationContext();

        return (Order) applicationContext.getBean("order");
    }

    public void printMethodName(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Called by : " + proceedingJoinPoint.getSignature().getName());

        Order order = getOrder();

        proceedingJoinPoint.proceed();

        System.out.println("Number of Products : " + order.getOrderProducts().size());
    }

    public void printOrderValue() {
        Order order = getOrder();

        System.out.println("============================");

        System.out.println("Order Total : " + order.getOrderValue());

        System.out.println("============================");
    }

    public void logException(JoinPoint joinPoint, Throwable exception) {
        System.out.println("Exception has been thrown in : " + joinPoint.getSignature());

        System.out.println("Exception message : " + exception.getMessage());
    }
}
