package com.demo.AdvicesAOP.AnnotationConfiguration;

import com.demo.AdvicesAOP.AnnotationConfiguration.Advices.Order;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.context.ApplicationContext;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect

public class AspectConfig {
    private Order getOrder() {
        ApplicationContext applicationContext = ApplicationContextWrapper.getApplicationContext();

        return (Order) applicationContext.getBean("order");
    }

    @Around("execution(* com.demo.AdvicesAOP.AnnotationConfiguration.Advices.Order.displayOrderProducts())")
    public void printMethodName(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Called by : " + proceedingJoinPoint.getSignature().getName());

        Order order = getOrder();

        proceedingJoinPoint.proceed();

        System.out.println("Number of Products : " + order.getOrderProducts().size());
    }

    @After("execution(* com.demo.AdvicesAOP.AnnotationConfiguration.Advices.Order.displayOrderProducts())")
    public void printOrderValue() {
        Order order = getOrder();

        System.out.println("============================");

        System.out.println("Order Total : " + order.getOrderValue());

        System.out.println("============================");
    }

    @AfterThrowing(pointcut = "execution(* com.demo.AdvicesAOP.AnnotationConfiguration.Advices.Order.*(..))", throwing = "exception")
    public void logException(JoinPoint joinPoint, Throwable exception) {
        System.out.println("Exception has been thrown in : " + joinPoint.getSignature());

        System.out.println("Exception message : " + exception.getMessage());
    }

    @AfterReturning(pointcut = "execution(* com.demo.AdvicesAOP.AnnotationConfiguration.Advices.Order.displayOrderProducts())")
    public void applyDiscount() {
        Order order = getOrder();

        float orderValue = order.getOrderValue();

        if(orderValue > 500) {
            System.out.println("********************************");

            System.out.println("You are qualified for order !");

            System.out.println("Discounted Total : " + (0.8 * orderValue));

            System.out.println("********************************");

        }
    }
}
