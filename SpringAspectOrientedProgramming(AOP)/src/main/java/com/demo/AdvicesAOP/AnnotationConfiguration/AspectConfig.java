package com.demo.AdvicesAOP.AnnotationConfiguration;

import com.demo.AdvicesAOP.AnnotationConfiguration.Advices.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.context.ApplicationContext;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect

public class AspectConfig {
    private static final Logger logger = LogManager.getLogger(AspectConfig.class);

    private Order getOrder() {
        ApplicationContext applicationContext = ApplicationContextWrapper.getApplicationContext();

        return (Order) applicationContext.getBean("order");
    }

    @Around("execution(* com.demo.AdvicesAOP.AnnotationConfiguration.Advices.Order.displayOrderProducts())")
    public void printMethodName(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("Called by : " + proceedingJoinPoint.getSignature().getName());

        Order order = getOrder();

        proceedingJoinPoint.proceed();

        System.out.println("Number of Products : " + order.getOrderProducts().size());
    }

    @AfterThrowing(pointcut = "execution(* com.demo.AdvicesAOP.AnnotationConfiguration.Advices.Order.*(..))", throwing = "exception")
    public void logException(JoinPoint joinPoint, Throwable exception) {
        logger.error("An Exception has been thrown when running : " + joinPoint.getSignature());

        logger.error("Exception Message : " + exception.getMessage());
    }

    @AfterReturning(pointcut = "execution(* com.demo.AdvicesAOP.AnnotationConfiguration.Advices.Order.displayOrderProducts())")
    public void applyDiscount() {
        Order order = getOrder();

        System.out.println("============================");

        logger.info("Order Total : " + order.getOrderValue());

        System.out.println("Order Total : " + order.getOrderValue());

        System.out.println("============================");

        float orderValue = order.getOrderValue();

        if(orderValue > 500) {
            System.out.println("********************************");

            System.out.println("You are qualified for order !");

            logger.info("Discounted Total : " + (0.8 * orderValue));

            System.out.println("********************************");

        }
    }
}
