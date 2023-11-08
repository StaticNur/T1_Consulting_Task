package com.example.T1_Consulting_Task.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class CalculateServiceTest {

    private CalculateService calculateService;

    @BeforeEach
    public void setUp() {
        calculateService = new CalculateService();
    }

    @Test
    public void testCalculateSymbol_ShouldReturnCorrectResult() {
        String inputString = "aaaaabcccc";
        String expectedOutput = "\"a\": 5, \"c\": 4, \"b\": 1";

        String result = calculateService.calculateSymbol(inputString);

        assertEquals(expectedOutput, result);
    }

    @Test
    public void testCalculateSymbol_ShouldReturnEmptyStringForEmptyInput() {
        String inputString = "";
        String expectedOutput = "";

        String result = calculateService.calculateSymbol(inputString);

        assertEquals(expectedOutput, result);
    }

    @Test
    public void testCalculateSymbol_ShouldReturnCorrectResultForMixedCaseInput() {
        String inputString = "AaAAaBCcCc";
        String expectedOutput = "\"A\": 3, \"a\": 2, \"c\": 2, \"C\": 2, \"B\": 1";

        String result = calculateService.calculateSymbol(inputString);

        assertEquals(expectedOutput, result);
    }
}