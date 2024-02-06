package com.example.hw.controller;

/**
 * Класс AppController. Контроллер приложения.
 *
 * @author Nick
 * @version 1.0
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    /**
     * Метод возвращает домашнюю страницу.
     *
     * @return String домашняя страница
     */
    @GetMapping("/")
    public String home() {
        return "home";
    }

    /**
     * Метод возвращает страницу для пользователей с ролью User.
     *
     * @return String публичная страница
     */
    @GetMapping("/public-data")
    public String userPage() {
        return "public_page";
    }

    /**
     * Метод возвращает страницу для пользователей с ролью Admin.
     *
     * @return String приватная страница
     */
    @GetMapping("/private-data")
    public String adminPage() {
        return "private_page";
    }

    /**
     * Метод возвращает страницу с отказом в доступе.
     *
     * @return String страница с отказом в доступе
     */
    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }

    /**
     * Метод возвращает страницу для аутентификации пользователя.
     *
     * @return String страница с аутентификацией
     */
    @GetMapping("/login")
    public String auth() {
        return "login-page";
    }


}

/**
 * Вам необходимо создать Spring Boot приложение, которое управляет доступом к ресурсам в зависимости
 * от роли пользователя. У вас должно быть два типа пользователей: USER и ADMIN.
 * <p>
 * 1. Создайте ресурс /private-data, доступный только для аутентифицированных пользователей с ролью ADMIN.
 * 2. Создайте ресурс /public-data, доступный для всех аутентифицированных пользователей независимо от
 * их роли.
 * 3. Реализуйте форму входа для аутентификации пользователей с использованием стандартных средств
 * Spring Security.
 * 4. Если неаутентифицированный пользователь пытается получить доступ к /private-data, он должен
 * быть перенаправлен на форму входа.
 */