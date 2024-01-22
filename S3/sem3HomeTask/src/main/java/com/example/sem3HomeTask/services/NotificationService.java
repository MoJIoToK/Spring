package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.stereotype.Service;

/**
 * Класс NotificationService. Содержит методы для уведомления о действии.
 *
 * @author Nick
 * @version 1.0
 */
@Service
public class NotificationService {

    /**
     * Метод показывает уведомление о создании профиля нового пользователя.
     *
     * @param user
     */
    public void notifyUser(User user) {
        System.out.println("A new user has been created: " + user.getName());
    }

    /**
     * Метод показывает уведомление.
     *
     * @param s - строка
     */
    public void sendNotification(String s) {
        System.out.println(s);
    }
}
