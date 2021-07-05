package com.kata.foobarquix.services;

import com.kata.foobarquix.functions.FooBarPredicate;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class FooBarQuixService {
    public String convertNumber(int inputNumber) {
        FooBarPredicate fooBarDivByOrContainsThree = n -> n % 3 == 0 || hasNumber(n, 3);
        FooBarPredicate fooBarDivByFive = n -> n % 5 == 0 || hasNumber(n, 5);

        if(fooBarDivByFive.evaluate(inputNumber) && fooBarDivByOrContainsThree.evaluate(inputNumber)){
            return getComputedResult(inputNumber);
        } else if(fooBarDivByOrContainsThree.evaluate(inputNumber)){
            return getComputedResult(inputNumber, "3", "Foo");
        } else if (fooBarDivByFive.evaluate(inputNumber)){
            return getComputedResult(inputNumber, "5", "Bar");
        } else if(hasNumber(inputNumber, 7)){
            return getComputedResult(inputNumber, "7", "Quix");
        } else {
            return String.valueOf(inputNumber);
        }
    }

    @NotNull
    private String getComputedResult(int inputNumber) {
        String result = String.valueOf(inputNumber);
        result = result.replace("3", "Foo");
        result = result.replace("5", "Bar");
        return result;
    }

    @NotNull
    private String getComputedResult(int inputNumber, String target, String replacement) {
        String stringNumber = String.valueOf(inputNumber);
        stringNumber = stringNumber.replace(target, replacement);
        return stringNumber;
    }

    private boolean hasNumber(int n, int searchNumber){
        while (n > 0){
            if(n % 10 == searchNumber) return true;
            n = n / 10;
        }
        return false;
    }
}
