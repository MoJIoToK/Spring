package com.example.s4_hw.services;

import com.example.s4_hw.model.BrokerAccount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrokerService {
    List<BrokerAccount> portfolio = new ArrayList<>();

    public void addTicker(BrokerAccount brokerAccount){
        portfolio.add(brokerAccount);
    }

    public List<BrokerAccount> getPortfolio(){
        return portfolio;
    }
}
