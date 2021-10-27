package com.demo.AspectConfigAnnotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class AspectConfig {
//    cross-cutting concern

    @Pointcut("execution(* *.print*(..))")
    private void printPointcut() {}

    @Pointcut("execution(* *.display*(..))")
    private void displayPointcut() {}

    @Pointcut("execution(public * *.get*(..))")
    private void getPointcut() {}

    @Pointcut("within(com.demo.AspectConfigAnnotation.Pointcuts.ProductList)")
    private void listAllMethodsProductPointcut() {}

    @Pointcut("printPointcut() || displayPointcut()")
    private void printOrDisplayPointcut() {}

    @Pointcut("printPointcut() && listAllMethodsProductPointcut()")
    private void printAndListAllMethodsPointcut() {}

    @Pointcut("! (printOrDisplayPointcut() || getPointcut())")
    private void doesNotPublishOrGetPointcut() {}

    @Before("printOrDisplayPointcut()")
    public void printMessage(JoinPoint joinPoint) {
        System.out.println("Publishing | Invoked by " + joinPoint.getSignature().getName());

        System.out.println("$$$$$$$ PUBLISH $$$$$$$$$");
    }

    @Before("printAndListAllMethodsPointcut()")
    public void printAndListAllMethodsMessage(JoinPoint joinPoint) {
        System.out.println("Printing from ProductList | Invoked by " + joinPoint.getSignature().getName());

        System.out.println("$$$$$$$ Print method called from ProductList $$$$$$$$$");
    }

    @Before("doesNotPublishOrGetPointcut()")
    public void doesNotPublishOrGetMessage(JoinPoint joinPoint) {
        System.out.println("Does not publish or retrieve data");
    }
}
