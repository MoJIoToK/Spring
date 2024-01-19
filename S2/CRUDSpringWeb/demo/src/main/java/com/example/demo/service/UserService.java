package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Класс UserService со свойством userRepository. Содержит логику работы приложения.
 * @author Nick
 * @version 1.0
 */
@Service
public class UserService {

    /** Поле userRepository */
    private final UserRepository userRepository;

    /**
     * Конструктор
     *
     * @param userRepository - класс, работающий с БД.
     */
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Метод findAll() вызывает функцию findAll в классе UserRepository.
     *
     * @return List
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * Метод saveUser() вызывает функцию save в классе UserRepository.
     *
     * @param user - экземпляра класса User в БД.
     * @return user
     * @see UserRepository#save - метод вызывающий данный метод.
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Метод deleteById(id) вызывает функцию deleteById в классе UserRepository.
     *
     * @param id - id экземпляра класса User в БД.
     * @see UserRepository#deleteById - метод вызывающий данный метод.
     */
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    /**
     * Метод update(<User>) вызывает функцию update в классе UserRepository.
     *
     * @param user - экземпляр класса User из БД.
     * @see UserRepository#findUserById - метод возвращает экземпляр класса User для работы метода update().
     * @see UserRepository#update - метод вызывающий данный метод.
     */
    public void update(User user) {
        userRepository.update(user);
    }

    /**
     * Метод getUserById() вызывает функцию findUserById в классе UserRepository.
     *
     * @param id - id по которому идёт поиск в БД.
     * @return user - экземпляр класса User.
     * @see UserRepository#update
     * @see UserService#update
     */
    public User getUserById(int id) {
        return userRepository.findUserById(id);
    }
}
