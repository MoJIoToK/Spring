package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private DataProcessingService dataProcessingService;

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    /**
     * Метод позволяет сохранить пользователя в БД и уведомить об этом.
     * @param name имя пользователя.
     * @param age возраст пользователя.
     * @param email электронная почта пользователя.
     * @see UserService#createUser
     * @see DataProcessingService#addUserToList
     * @see NotificationService#sendNotification
     */
    public void processRegistration(String name, int age, String email){
        User createdUser = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(createdUser);
        notificationService.sendNotification("Пользователь добавлен в БД!");
    }

}
