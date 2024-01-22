package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс DataProcessingService. Содержит методы для взаимодействия с данными о пользователях.
 *
 * @author Nick
 * @version 1.0
 */
@Service
public class DataProcessingService {

    /**
     * Метод позволяющий получить доступ к методам класса UserRepository.
     *
     * @return UserRepository
     * @see UserRepository
     */
    public UserRepository getRepository() {
        return repository;
    }

    /**
     * Поле UserRepository.
     */
    @Autowired
    private UserRepository repository;

    /**
     * Метод сортирующий входной список по возрасту, в порядке возрастания.
     *
     * @param users - List<User>
     * @return List
     */
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /**
     * Метод фильтрующий входной список по возрасту. В выходной список попадут пользователи достигшие
     * заданного возраста.
     *
     * @param users
     * @param age
     * @return List
     */
    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    /**
     * Метод позволяет получить средний возраст пользователей.
     *
     * @param users
     * @return double
     */
    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    /**
     * Метод вызывает метод addUser() для добавления нового пользователя в БД.
     *
     * @param user
     * @see UserRepository#addUser(User)
     */
    public void addUser(User user) {
        repository.addUser(user);
    }

}
