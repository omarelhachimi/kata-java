package com.kata.foobarquix.services.impl;

import com.kata.foobarquix.services.IFooBarQuixService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Character.getNumericValue;
import static java.util.stream.Collectors.joining;

@Service
public class FooBarQuixServiceImpl implements IFooBarQuixService {

    //////////////////////////////////////////////////////////////////////////////////////////
    ///
    /// FooBarQuixServiceImpl can be done in a more general way, meaning that the two maps get
    /// injected in the service, and service apply the logic independently of the maps
    ///
    /// The FooBarQuixServiceImplTest tests are not perfect two, because if we decide to change
    /// the number or the strings we will have to change tests code.
    ///
    /// The tests can be done also in a more general way
    ///
    /// For simplicity and time reasons i decided to keep the code this way and mention this here
    /// This code was coded in TDD, red test -> green test -> refactor
    ///
    //////////////////////////////////////////////////////////////////////////////////////////


    private static final Map<Integer, String> dividedByMap = new HashMap<Integer, String>() {{
        put(3, "Foo");
        put(5, "Bar");
    }};

    private static final Map<Integer, String> containsMap = new HashMap<Integer, String>() {{
        put(3, "Foo");
        put(5, "Bar");
        put(7, "Quix");
    }};

    @Override
    public String convertNumber(int numberToConvert) {

        String result = getStringBasedOnDivisibility(numberToConvert);
        result += getStringBasedOnTheNumbersItContains(String.valueOf(numberToConvert));
        return result.isEmpty() ? String.valueOf(numberToConvert) : result;
    }

    private String getStringBasedOnTheNumbersItContains(String numberToConvert) {
        return numberToConvert.chars()
                .mapToObj(integerAsChar -> containsMap.getOrDefault(getNumericValue(integerAsChar), ""))
                .collect(joining());
    }

    private String getStringBasedOnDivisibility(int numberToConvert) {
        return dividedByMap.keySet().stream()
                .filter(divisor -> numberToConvert % divisor == 0)
                .map(dividedByMap::get)
                .collect(joining());
    }

}
