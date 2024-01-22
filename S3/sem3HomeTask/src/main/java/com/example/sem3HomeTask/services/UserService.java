package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // @Autowired
    /**
     * Сервис уведомлений.
     */
    private NotificationService notificationService;

    /**
     * Конструктор.
     */
    // Внедрение зависимости через конструктор
    public UserService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * Метод позволяющий создать пользователя с заданными полями.
     * @param name - имя
     * @param age - возраст
     * @param email - электронная почта
     * @return User
     * @see NotificationService#notifyUser
     * @see RegistrationService#processRegistration
     * @see User
     */
    public User createUser(String name, int age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);

        // Отправляем уведомление о создании нового пользователя
        notificationService.notifyUser(user);

        return user;
    }
}
