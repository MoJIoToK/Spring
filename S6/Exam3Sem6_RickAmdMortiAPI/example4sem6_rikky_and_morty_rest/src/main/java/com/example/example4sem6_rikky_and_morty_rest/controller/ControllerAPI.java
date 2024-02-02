package com.example.example4sem6_rikky_and_morty_rest.controller;

/**
 * Класс ControllerAPI. Содержит методы для обработки запросов API.
 *
 * @author Nick
 * @version 1.0
 */

import com.example.example4sem6_rikky_and_morty_rest.domain.Characters;
import com.example.example4sem6_rikky_and_morty_rest.domain.Result;
import com.example.example4sem6_rikky_and_morty_rest.exception.CharacterNotFoundException;
import com.example.example4sem6_rikky_and_morty_rest.service.ServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerAPI {
    @Autowired
    private ServiceApi serviceApi;

    /**
     * Метод возвращает всех персонажей.
     *
     * @return Characters Коллекция персонажей
     * @see ServiceApi#getAllCharacters
     */
    @GetMapping("/")
    public ResponseEntity<Characters> getCharacters() {
        Characters allCharacters = serviceApi.getAllCharacters();
        return new ResponseEntity<>(allCharacters, HttpStatus.OK);
    }

    /**
     * Метод возвращает информацию о персонаже по его идентификатору.
     *
     * @param id
     * @return Result Информация о персонаже
     * @see ServiceApi#getCharacterById
     */
    @GetMapping("/{id}")
    public ResponseEntity<Result> getCharacterById(@PathVariable Integer id) {
        try {
            Result character = serviceApi.getCharacterById(id);
            return ResponseEntity.ok(character);
        } catch (CharacterNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

}
