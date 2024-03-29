package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.repository.UserRepository;
import com.example.sem3HomeTask.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Класс TaskController со свойствами jdbc. Содержит методы взаимодействия с БД.
 *
 * @author Nick
 * @version 1.0
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

    /**
     * Сервис обработки данных.
     */
    @Autowired
    private DataProcessingService service;

    /**
     * Метод позволяет получить список всех задач.
     *
     * @return List список задач
     */
    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    /**
     * Метод позволяет получить список пользователей отсортированных по возрасту.
     *
     * @return List отсортированных список пользователей в формате JSON.
     * @see DataProcessingService#sortUsersByAge
     * @see DataProcessingService#getRepository
     * @see UserRepository#getUsers
     */
    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge() {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    /**
     * Метод позволяет получить отфильтрованный по возрасту список пользователей.
     *
     * @param age возраст пользователя.
     * @return List отфильтрованный список пользователей в формате JSON.
     * @see DataProcessingService#filterUsersByAge
     * @see DataProcessingService#getRepository
     * @see UserRepository#getUsers
     */
    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable("age") int age) {
        List<User> usersList = service.getRepository().getUsers();
        return service.filterUsersByAge(usersList, age);
    }

    /**
     * Метод позволяет получить средний возраст всех пользователей.
     *
     * @return double средний возраст всех пользователей.
     * @see DataProcessingService#calculateAverageAge
     * @see DataProcessingService#getRepository
     * @see UserRepository#getUsers
     */
    @GetMapping("/calc")
    public double calculateAverageAge() {
        List<User> usersList = service.getRepository().getUsers();
        return service.calculateAverageAge(usersList);

    }

}
