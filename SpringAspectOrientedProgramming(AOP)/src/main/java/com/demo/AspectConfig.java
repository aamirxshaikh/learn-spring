package com.demo;

import org.aspectj.lang.JoinPoint;

public class AspectConfig {
//    cross-cutting concern
    public void print(JoinPoint joinPoint) {
        System.out.println("Invoked " + joinPoint.getSignature().getName());

        System.out.println("$$$$$$$$$$$$$$$$");
    }
}
