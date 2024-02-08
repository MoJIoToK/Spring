package com.example.s8_hw.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@RequiredArgsConstructor
public class UserActionAspect {

    @Around("@annotation(com.example.s8_hw.aspect.TrackUserAction)")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();

        System.out.println("Метод вызванный пользователем - " + methodName +
                ", с параметрами " + Arrays.asList(arguments) +
                " был завершен.");

        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        System.out.println("Метод - " + methodName +
                ", выполнился за " + executionTime +
                ", с результатом -" + result);
//        System.out.println("Пользователь вызвал метод: " +
//                joinPoint.getSignature().getName() + ".");
//        Object proceed = joinPoint.proceed();
//        System.out.println("Метод завершён.");
        return result;
    }

}
