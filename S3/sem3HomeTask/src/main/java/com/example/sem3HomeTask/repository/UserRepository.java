package com.example.sem3HomeTask.repository;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.DataProcessingService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс UserRepository. Содержит методы для взаимодействия с БД.
 *
 * @author Nick
 * @version 1.0
 */
@Component
public class UserRepository {

    /**
     * Поле jdbc
     */
    private final JdbcTemplate jdbc;

    /**
     * Конструктор
     *
     * @param jdbc
     */
    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * Метод позволяет получить список пользователей с помощью обращения к БД.
     *
     * @return List список пользоваталей
     */
    public List<User> getUsers() {
        String sql = "select * from \"user\"";
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setName(r.getString("name"));
            rowObject.setAge(r.getInt("age"));
            rowObject.setEmail(r.getString("email"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    /**
     * Метод позволяет добавить нового пользователя в БД при помощи запроса к БД.
     *
     * @param user
     * @see DataProcessingService#addUser
     */
    public void addUser(User user) {
        String sql = "INSERT INTO \"user\" (name, age, email) VALUES (?, ?, ?)";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
    }

}
