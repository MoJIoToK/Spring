package com.example.s8_hw.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Аспект UserActionAspect. Представляет механизм отслеживания и логирования действий пользователя.
 *
 * @author Nick
 * @version 1.0
 */


@Aspect
@Component
@RequiredArgsConstructor
public class UserActionAspect {

    /**
     * Метод позволяет логировать методы вызванные действиями пользователя.
     * Методы должны быть помечены аннотацией TrackUserAction.
     * Логирование происходит путём вывода действий в консоль.
     *
     * @param joinPoint точка кода куда должен вмешаться аспект.
     * @return результат выполнения вызываемого метода.
     * @throws Throwable
     */
    @Around("@annotation(com.example.s8_hw.aspect.TrackUserAction)")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();

        System.out.println("Метод вызванный пользователем - " + methodName +
                ", с параметрами " + Arrays.asList(arguments) +
                " был завершен.");

        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        System.out.println("Метод - " + methodName +
                ", выполнился за " + executionTime +
                ", с результатом -" + result);

        return result;
    }

}
