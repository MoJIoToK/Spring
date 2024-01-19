package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Класс UserController со свойством userService. Содержит методы для взаимодействия пользователя и приложения.
 * Для взаимодействия с БД необходим класс UserService.
 *
 * @author Nick
 * @version 1.0
 */
@Controller
public class UserController {
    /** Поле userService */
    private final UserService userService;

    /**
     * Конструктор
     *
     * @param userService - класс, работающий с БД.
     */
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Метод findAll() обработчик HTTP запроса Get, будет вызван на страничке с адресом "/users".
     * Вызывает функцию findAll в классе UserService, для того чтобы получить список всех пользователей.
     *
     * @param model
     * @return List<User>
     */
    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();

        model.addAttribute("users", users);
        return "user-list";
    }

    /**
     * Метод createUserForm() обработчик HTTP запроса Get, будет вызван с адреса "/user-create" и переведёт
     * на страницу с адресом "user-create".
     *
     * @param user
     */
    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    /**
     * Метод createUser() обработчик HTTP Post запроса. Будет вызван при получении запроса по адресу "/user-create".
     * Вызывает функцию createUser в классе UserService, для того чтобы сохранить данные о новом пользователе.
     * Возвращает на страницу с адресом /users".
     *
     * @param user
     */

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    /**
     * Метод deleteUser() обработчик HTTP запроса Get, будет вызван с адреса "/user-delete".
     * Вызывает функцию deleteById в классе UserService,
     * для того чтобы удалить данные о пользователе по его id.
     * Возвращает на страницу с адресом "/users".
     *
     * @param id
     */

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    /**
     * Метод updateUserForm() обработчик HTTP запроса Get, будет вызван с адреса "/user-update".
     * Вызывает функцию getUserById в классе UserService, для того чтобы получить данные о пользователе по его id.
     * Переводит на страницу с адресом "/user-update"
     * @param id
     */

    @GetMapping("user-update/{id}")
    public String updateUserForm(@PathVariable("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    /**
     * Метод updateUser() обработчик HTTP Post запроса. Будет вызван при получении запроса по адресу "/user-update".
     * Вызывает функцию update в классе UserService, для того чтобы обновить данные о пользователе.
     * Возвращает на страницу с адресом /users".
     *
     * @param user
     */
    @PostMapping("/user-update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/users";
    }

}
