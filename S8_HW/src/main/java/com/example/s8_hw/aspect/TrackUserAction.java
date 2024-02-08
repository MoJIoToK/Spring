package com.example.s8_hw.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Аннотация TrackUserAction необходима для маркировки отслеживаемых методов,
 * которые позволят логировать действия пользователя.
 * Данная аннотация ставится перед теми методами которые необходимо логировать
 * в сервисном слое.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackUserAction {
}
