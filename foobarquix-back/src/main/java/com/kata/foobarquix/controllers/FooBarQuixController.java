package com.kata.foobarquix.controllers;

import com.kata.foobarquix.dto.ResultDto;
import com.kata.foobarquix.services.impl.FooBarQuixServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/foo-bar-quix")
public class FooBarQuixController {

    @Autowired
    FooBarQuixServiceImpl fooBarQuixServiceImpl;

    @GetMapping(path = "/{inputNumber}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
    public ResultDto convertNumber(@PathVariable int inputNumber) {
        return new ResultDto(fooBarQuixServiceImpl.convertNumber(inputNumber));
    }

}
