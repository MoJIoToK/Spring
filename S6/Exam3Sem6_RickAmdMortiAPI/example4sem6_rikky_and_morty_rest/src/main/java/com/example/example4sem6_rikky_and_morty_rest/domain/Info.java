package com.example.example4sem6_rikky_and_morty_rest.domain;

/**
 * Класс Info, представляет информацию о коллекции персонажей.
 *
 * @author Nick
 * @version 1.0
 */

import lombok.Data;

@Data
public class Info {
    private Integer count;
    private Integer pages;
    private String next;
    private String prev;
}
