package com.example.example4sem6_rikky_and_morty_rest.domain;

/**
 * Класс Characters. Коллекция персонажей "Rick and Morty".
 *
 * @author Nick
 * @version 1.0
 */

import lombok.Data;

import java.util.List;

@Data
public class Characters {
    Info info;
    List<Result> results;
}
