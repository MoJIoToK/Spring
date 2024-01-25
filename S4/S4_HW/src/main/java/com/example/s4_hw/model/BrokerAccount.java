package com.example.s4_hw.model;

import lombok.Data;

@Data
public class BrokerAccount {

    private String description;

    private String ticker;

    private double price;

    private int count;

}
