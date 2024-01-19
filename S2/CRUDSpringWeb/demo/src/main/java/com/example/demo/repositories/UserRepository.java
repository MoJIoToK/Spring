package com.example.demo.repositories;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Класс UserRepository со свойствами jdbc. Содержит методы взаимодействия с БД.
 * @author Nick
 * @version 1.0
 */

@Repository
public class UserRepository {

    /** Поле jdbc */
    private final JdbcTemplate jdbc;

    /**
     * Конструктор
     *
     * @param jdbc - класс, выполняющий основные операции JDBC. Например, такие как выполнение SQL запросов.
     */
    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * Метод findAll() формирует и отправляет запрос к БД на чтение всех записей о пользователях.
     *
     * @return JdbcTemplate.query
     */
    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    /**
     * Метод save() формирует и отправляет запрос к БД на добавление записи о пользователе.
     *
     * @param user - экземпляра класса User в БД.
     * @return user
     * @see UserService#saveUser - метод вызывающий данный метод.
     */
    public User save(User user) {
        String sql = "INSERT INTO userTable VALUES (NULL, ?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return user;
    }

    /**
     * Метод deleteById(id) формирует и отправляет запрос к БД на удаление данных о пользователе.
     *
     * @param id - id экземпляра класса User в БД.
     * @see UserService#deleteById - метод вызывающий данный метод.
     */
    public void deleteById(int id) {
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
    }

    /**
     * Метод update(<User>) формирует и отправляет запрос к БД на обновление данных о пользователе.
     *
     * @param user - экземпляр класса User из БД.
     * @see UserRepository#findUserById - метод возвращает экземпляр класса User для работы метода update().
     * @see UserService#update

    //* @see UserService#update - метод вызывающий данный метод.
     */
    public void update(User user) {
        String sql = "UPDATE userTable SET firstName = ?, lastName = ? WHERE id = ?";
        jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getId());
    }

    /**
     * Метод findUserById() формирует и отправляет запрос к БД на чтение данных о пользователе по его id.
     *
     * @param id - id по которому идёт поиск в БД.
     * @return user - экземпляр класса User.
     * @see UserRepository#update
     * @see UserService#update
     * @see UserService#getUserById
     */
    public User findUserById(int id) {
        String sql = "SELECT * FROM userTable WHERE id = ?";
        return jdbc.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(User.class))
                .stream().findFirst().orElse(null);
    }

}
