package com.example.example4sem6_rikky_and_morty_rest.exception;

/**
 * Класс CharacterNotFoundException. Возникает при отсутствии информации о персонаже.
 *
 * @author Nick
 * @version 1.0
 */

public class CharacterNotFoundException extends RuntimeException {
    /**
     * Конструктор класса CharacterNotFoundException.
     *
     * @param message Сообщение об исключении
     */
    public CharacterNotFoundException(String message) {
        super(message);
    }
}
