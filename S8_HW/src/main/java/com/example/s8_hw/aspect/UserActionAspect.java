package com.example.s8_hw.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import javax.xml.stream.events.Comment;
import java.util.Arrays;
import java.util.Objects;

@Aspect
public class UserActionAspect {

    @Around("execution(* org.example.service.*.*(..))")
    public Object  trackUserAction(ProceedingJoinPoint joinPoint) throws Throwable{
        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();

        System.out.println("Method " + methodName +
                " with parameters " + Arrays.asList(arguments) +
                " will execute.");

        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        System.out.println("Сообщение до вызова комментируемого метода");

        return result;

    }

}
