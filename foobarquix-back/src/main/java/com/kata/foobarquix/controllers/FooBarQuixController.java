package com.kata.foobarquix.controllers;

import com.kata.foobarquix.dto.ResultDTO;
import com.kata.foobarquix.services.FooBarQuixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FooBarQuixController {

    @Autowired
    private FooBarQuixService fooBarService;

    @GetMapping("/foo-bar-quix/{inputNumber}")
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200", "http://localhost:3000"})
    public ResultDTO convertNumber(@PathVariable int inputNumber){
        return new ResultDTO(fooBarService.convertNumber(inputNumber));
    }


}
