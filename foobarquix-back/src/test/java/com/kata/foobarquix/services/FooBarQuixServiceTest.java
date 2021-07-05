package com.kata.foobarquix.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FooBarQuixServiceTest {

    //If the number is divisible by 3 or contains 3, replace 3 by "Foo";
    //if the number is divisible by 5 or contains 5, replace 5 by "Bar";
    //if the number contains 7, replace 7 by "Quix".
    //        Divisors have high predecence, the content is analyzed in the order of appearance.
    //If no match, return the input number as a string.

    @Autowired
    private FooBarQuixService fooBarService;

    @Test
    public void test_ifNumberDivisibleByThreeReplaceThreeByFoo(){
        //GIVEN
        int inputNumber = 33;
        //WHEN
        String result = fooBarService.convertNumber(inputNumber);

        //THEN
        assertEquals("FooFoo", result);
    }

    @Test
    public void test_ifNumberContainsThreeReplaceThreeByFoo(){
        //GIVEN
        int inputNumber = 13;

        //WHEN
        String result = fooBarService.convertNumber(inputNumber);

        //THEN
        assertEquals("1Foo", result);
    }

    @Test
    public void test_ifOtherNumberContainsThreeReplaceThreeByFoo(){
        //GIVEN
        int inputNumber = 23;

        //WHEN
        String result = fooBarService.convertNumber(inputNumber);

        //THEN
        assertEquals("2Foo", result);
    }

    @Test
    public void test_ifNumberDivisibleByFiveReplaceFiveWithBar(){
        //GIVEN
        int inputNumber = 5;

        //WHEN
        String result = fooBarService.convertNumber(inputNumber);

        //THEN
        assertEquals("Bar", result);
    }

    @Test
    public void test_ifNumberContainsFiveReplaceFiveWithBar(){
        //GIVEN
        int inputNumber = 52;

        //WHEN
        String result = fooBarService.convertNumber(inputNumber);

        //THEN
        assertEquals("Bar2", result);
    }

    @Test
    public void test_ifDivisibleByThreeButDoesntContainFiveShouldNotChangeNumber(){
        //GIVEN
        int inputNumber = 10;

        //WHEN
        String result = fooBarService.convertNumber(inputNumber);

        //THEN
        assertEquals("10", result);
    }

    @Test
    public void test_ifHasSevenReplaceSevenWithQuix(){
        //GIVEN
        int inputNumber = 7;

        //WHEN
        String result = fooBarService.convertNumber(inputNumber);

        //THEN
        assertEquals("Quix", result);
    }

    @Test
    public void test_ifContainsFiveThreeShouldReplaceFiveAndThreeWithBarFooAccordingly(){
        //GIVEN
        int inputNumber = 53;
        int inputNumber2 = 500003;

        //WHEN
        String result = fooBarService.convertNumber(inputNumber);
        String result2 = fooBarService.convertNumber(inputNumber2);

        //THEN
        assertEquals("BarFoo", result);
        assertEquals("Bar0000Foo", result2);
    }

    @Test
    public void test_ifContainsThreeFiveFooBarAccordingly(){
        //GIVEN
        int inputNumber = 35;
        int inputNumber2 = 300005;

        //WHEN
        String result = fooBarService.convertNumber(inputNumber);
        String result2 = fooBarService.convertNumber(inputNumber2);

        //THEN
        assertEquals("FooBar", result);
        assertEquals("Foo0000Bar", result2);
    }

    @Test
    public void test_ifNoneOfTheConditionsAreTrueReturnOriginalNumber(){
        //GIVEN
        int inputNumber = 22;

        //WHEN
        String result = fooBarService.convertNumber(inputNumber);

        //THEN
        assertEquals("22", result);
    }

}