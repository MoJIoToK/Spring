package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс RegistrationService. Содержит методы для регистрации пользователей.
 *
 * @author Nick
 * @version 1.0
 */
@Service
public class RegistrationService {

    /**
     * Сервис создания пользователей.
     */
    @Autowired
    private UserService userService;

    /**
     * Сервис уведомлений.
     */
    @Autowired
    private NotificationService notificationService;

    /**
     * Сервис взаимодействий с данными.
     */
    @Autowired
    private DataProcessingService dataProcessingService;

    /**
     * Метод позволяет получить доступ к методам класса DataProcessingService.
     *
     * @return DataProcessingService
     * @see DataProcessingService
     */
    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    /**
     * Метод позволяет сохранить пользователя в БД и уведомить об этом.
     *
     * @param name  имя пользователя.
     * @param age   возраст пользователя.
     * @param email электронная почта пользователя.
     * @see UserService#createUser
     * @see DataProcessingService#addUser
     * @see NotificationService#sendNotification
     */
    public void processRegistration(String name, int age, String email) {
        User createdUser = userService.createUser(name, age, email);
        dataProcessingService.addUser(createdUser);
        notificationService.sendNotification("Пользователь добавлен в БД!");
    }

}
