package com.example.sem3HomeTask.domain;

/**
 * Класс User со свойствами name, age, email.
 *
 * @author Nick
 * @version 1.0
 */
public class User {

    /**
     * Поле name - имя пользователя.
     */
    private String name;

    /**
     * Поле age - возраст пользователя.
     */
    private int age;

    /**
     * Поле email - электронная почта пользователя.
     */
    private String email;

    /**
     * Метод позволяет получить имя пользователя.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Метод позволяет установить имя пользователя.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Метод позволяет получить возраст пользователя.
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Метод позволяет установить возраст пользователя.
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Метод позволяет получить электронную почту пользователя.
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Метод позволяет установить электронную почту пользователя.
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
