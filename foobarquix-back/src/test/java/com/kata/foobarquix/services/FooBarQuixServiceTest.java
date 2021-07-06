package com.kata.foobarquix.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

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
    public void test_if_divisible_by_3_should_return_Foo(){
        //GIVEN
        int inputNumber = 9;

        //WHEN
        String result = fooBarService.convertNumber(inputNumber);

        //THEN
        assertEquals("Foo", result);
    }

    @Test
    public void test_if_divisible_by_5_should_return_Bar(){
        //GIVEN
        int inputNumber = 10;

        //WHEN
        String result = fooBarService.convertNumber(inputNumber);

        //THEN
        assertEquals("Bar", result);
    }

    @Test
    public void test_if_contains_7_should_return_quix(){
        //GIVEN
        int inputNumber = 7;

        //WHEN
        String result = fooBarService.convertNumber(inputNumber);

        //THEN
        assertEquals("Quix", result);
    }

    @Test
    public void test_if_divisible_by_three_and_contains_3(){
        //GIVEN
        int inputNumber = 3;
        int inputNumber2 = 33;

        //WHEN
        String result = fooBarService.convertNumber(inputNumber);
        String result2 = fooBarService.convertNumber(inputNumber2);

        //THEN
        assertEquals("FooFoo", result);
        assertEquals("FooFooFoo", result2);
    }

    @Test
    public void test_if_no_condition_is_true_then_return_the_input_number(){
        //GIVEN
        int inputNumber = 11;

        //WHEN
        String result = fooBarService.convertNumber(inputNumber);

        //THEN
        assertEquals("11", result);
    }

    @ParameterizedTest
    @MethodSource("getInputNumbersForConvertNumber")
    public void test_cases_provided_in_the_example_from_frontend(int input, String expected){
        assertEquals(expected, fooBarService.convertNumber(input));
    }

    private static Stream<Arguments> getInputNumbersForConvertNumber(){
        return Stream.of(
                Arguments.of(1, "1"),
                Arguments.of(3, "FooFoo"),
                Arguments.of(5, "BarBar"),
                Arguments.of(7, "Quix"),
                Arguments.of(9, "Foo"),
                Arguments.of(51, "FooBar"),
                Arguments.of(53, "BarFoo"),
                Arguments.of(33, "FooFooFoo"),
                Arguments.of(27, "FooQuix"),
                Arguments.of(15, "FooBarBar")
        );
    }





}