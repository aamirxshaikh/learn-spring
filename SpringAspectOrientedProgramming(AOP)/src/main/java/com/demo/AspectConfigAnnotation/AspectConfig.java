package com.demo.AspectConfigAnnotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class AspectConfig {
//    cross-cutting concern

//    @Pointcut("execution(void com.demo.AspectConfigAnnotation.Pointcuts.*.*())")
//    @Pointcut("execution(public * *(..))")
    @Pointcut("execution(public * *.get*(..))")
    private void getPointcut() {}

    @Pointcut("execution(* *.add*(int, com.demo.AspectConfigAnnotation.Pointcuts.Product))")
    private void addPointcut() {}

    @Pointcut("within(com.demo.AspectConfigAnnotation.Pointcuts.ProductList)")
    private void listAllMethodsProductPointcut() {}

    @Pointcut("within(com.demo.AspectConfigAnnotation.Pointcuts.*)")
    private void anyClassMethodPointcut() {}

    @Before("getPointcut()")
    public void getMessage(JoinPoint joinPoint) {
        System.out.println("Performing get | Invoked by " + joinPoint.getSignature().getName());

        System.out.println("$$$$$$$ GET $$$$$$$$$");
    }

    @Before("addPointcut()")
    public void addMessage(JoinPoint joinPoint) {
        System.out.println("Performing add | Invoked by " + joinPoint.getSignature().getName());

        System.out.println("$$$$$$$ Add $$$$$$$$$");

        System.out.println("Args " + Arrays.toString(joinPoint.getArgs()));
    }

    @Before("anyClassMethodPointcut()")
    public void anyClassMethodMessage(JoinPoint joinPoint) {
        System.out.println("anyClassMethod | Invoked by " + joinPoint.getSignature().getName());

        System.out.println("$$$$$$$ anyClassMethod $$$$$$$$$");

        System.out.println("Args " + Arrays.toString(joinPoint.getArgs()));
    }
}
