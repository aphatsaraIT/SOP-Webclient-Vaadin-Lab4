package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {


    @RequestMapping(value = "/getChange/{money}", method = RequestMethod.GET)
    public Change getChange(@PathVariable("money") Integer money){
        Change cash = new Change();
        double keep = money;
        double b1000 = Math.floor(keep / 1000);
        cash.setB1000((int) b1000);
        keep = keep%1000;
        double b500 = Math.floor(keep / 500);
        cash.setB500((int) b500);
        keep = keep%500;
        double b100 = Math.floor(keep / 100);
        cash.setB100((int) b100);
        keep = keep%100;
        double b20 = Math.floor(keep / 20);
        cash.setB20((int) b20);
        keep = keep%20;
        double b10 = Math.floor(keep / 10);
        cash.setB10((int) b10);
        keep = keep%10;
        double b5 = Math.floor(keep / 5);
        cash.setB5((int) b5);
        keep = keep%5;
        double b1 = Math.floor(keep);
        cash.setB1((int) b1);
        return cash;
    }
}
