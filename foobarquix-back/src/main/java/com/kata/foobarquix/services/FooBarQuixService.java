package com.kata.foobarquix.services;

import org.springframework.stereotype.Service;

@Service
public class FooBarQuixService {
    public String convertNumber(int inputNumber) {
        StringBuilder sb = new StringBuilder();
        String inputNumberStr = String.valueOf(inputNumber);

        //Divisors take higher precedence!
        if(inputNumber % 3 == 0) sb.append("Foo");
        if(inputNumber % 5 == 0) sb.append("Bar");

        inputNumberStr = inputNumberStr.replaceAll("[^357]", "");

        inputNumberStr = inputNumberStr.replace("3", "Foo");
        inputNumberStr = inputNumberStr.replace("5", "Bar");
        inputNumberStr = inputNumberStr.replace("7", "Quix");

        sb.append(inputNumberStr);

        String convertedNumber = sb.toString();

        if(!convertedNumber.isEmpty()){
            return convertedNumber;
        }else {
            return String.valueOf(inputNumber);
        }
    }
}
