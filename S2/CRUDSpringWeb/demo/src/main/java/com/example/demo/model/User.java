package com.example.demo.model;

import java.util.Objects;

/**
 * Класс User со свойствами id, firstName lastName.
 * @author Nick
 * @version 1.0
 */

public class User {

    /** Поле id - идентификационный номер */
    private int id;

    /** Поле firstName - имя пользователя */
    private String firstName;

    /** Поле lastName - фамилия пользователя */
    private String lastName;

    /** Метод getId позволяет получить значение идентификационного номера пользователя.
     * @return id
     */
    public int getId() {
        return id;
    }

    /** Метод setId позволяет установить значение идентификационного номера пользователя.
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /** Метод getFirstName позволяет получить имя пользователя.
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /** Метод setFirstName позволяет установить имя пользователя.
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /** Метод getLastName позволяет получить фамилию пользователя.
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /** Метод setLastName позволяет установить фамилию пользователя.
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(firstName, user.getFirstName()) && Objects.equals(lastName, user.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}
