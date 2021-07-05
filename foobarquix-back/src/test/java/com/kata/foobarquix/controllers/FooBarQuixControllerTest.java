package com.kata.foobarquix.controllers;

import com.kata.foobarquix.services.FooBarQuixService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class FooBarQuixControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FooBarQuixService fooBarService;

    @Test
    public void test_whenGetMethodCalledShouldReturnIsOkStatusFooBarQuixIstheRe() throws Exception {
        //GIVEN
        int inputNumber = 33;

        //WHEN
        when(fooBarService.convertNumber(inputNumber)).thenReturn("FooFoo");

        //THEN
        mockMvc.perform(get("/foo-bar-quix/{inputNumber}", inputNumber)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void test_whenGetMethodCalledShouldReturnDtoContainingResultObject() throws Exception {

        //GIVEN
        int inputNumber = 33;

        //WHEN
        when(fooBarService.convertNumber(inputNumber)).thenReturn("FooFoo");

        //THEN
        mockMvc.perform(get("/foo-bar-quix/{inputNumber}", inputNumber).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value", is("FooFoo")));
    }


}