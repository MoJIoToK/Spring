package com.example.example4sem6_rikky_and_morty_rest.exception;

/**
 * Класс GlobalExceptionHandler. Обработчик исключений для контроллеров.
 *
 * @author Nick
 * @version 1.0
 */

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Обрабатывает исключение CharacterNotFoundException.
     *
     * @param e     Исключение CharacterNotFoundException
     * @param model Модель данных
     * @return String Название страницы ошибки
     * @see CharacterNotFoundException
     */
    @ExceptionHandler(CharacterNotFoundException.class)
    public String handleCharacterNotFoundException(CharacterNotFoundException e, Model model) {
        model.addAttribute("errorMessage", e.getMessage());
        return "characterNotFound";
    }
}
