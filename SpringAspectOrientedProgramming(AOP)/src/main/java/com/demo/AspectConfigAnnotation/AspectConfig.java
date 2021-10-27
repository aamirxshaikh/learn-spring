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

    @Pointcut("execution(* *.add*(..))")
    private void addPointcut() {}

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
}
