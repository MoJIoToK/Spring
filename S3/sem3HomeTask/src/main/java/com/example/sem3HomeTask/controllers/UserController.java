package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.repository.UserRepository;
import com.example.sem3HomeTask.services.DataProcessingService;
import com.example.sem3HomeTask.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Класс UserController контроллер пользователей.
 *
 * @author Nick
 * @version 1.0
 */
@RestController
@RequestMapping("/user")//localhost:8080/user
public class UserController {

    /**
     * Сервис регистрации пользователя.
     */
    @Autowired
    private RegistrationService service;

    /**
     * Метод позволяет получить список пользователей в формате JSON.
     *
     * @return List
     * @see RegistrationService#getDataProcessingService
     * @see DataProcessingService#getRepository
     * @see UserRepository#getUsers
     */
    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    /**
     * Метод позволяет добавить нового пользователя в БД при помощи запроса.
     *
     * @param requestBody тело запроса.
     * @return String подтверждение добавления пользователя
     * @see RegistrationService#processRegistration
     */
    @PostMapping("/body")
    public String userAddFromParam(@RequestBody Map<String, Object> requestBody) {
        String name = (String) requestBody.get("name");
        Integer age = (Integer) requestBody.get("age");
        String email = (String) requestBody.get("email");
        service.processRegistration(name, age, email);
        return "User add!";
    }
}
