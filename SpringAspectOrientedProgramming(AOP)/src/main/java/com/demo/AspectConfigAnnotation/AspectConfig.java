package com.demo.AspectConfigAnnotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectConfig {
//    cross-cutting concern

    @Pointcut("execution(void com.demo.AspectConfigAnnotation.Pointcuts.*.*())")
    private void pointcutExpression() {}

    @Before("pointcutExpression()")
    public void print(JoinPoint joinPoint) {
        System.out.println("Invoked " + joinPoint.getSignature().getName());

        System.out.println("$$$$$$$$$$$$$$$$");
    }
}
