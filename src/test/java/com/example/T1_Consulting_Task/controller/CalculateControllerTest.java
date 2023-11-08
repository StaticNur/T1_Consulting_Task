package com.example.T1_Consulting_Task.controller;

import com.example.T1_Consulting_Task.service.CalculateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculateControllerTest {

    private CalculateController calculateController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        CalculateService calculateService = mock(CalculateService.class);
        when(calculateService.calculateSymbol("aaaaabcccc")).thenReturn("\"a\": 5, \"c\": 4, \"b\": 1");

        calculateController = new CalculateController(calculateService);
        mockMvc = MockMvcBuilders.standaloneSetup(calculateController).build();
    }

    @Test
    public void testGetResult_ShouldReturnCorrectResult() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/aaaaabcccc"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("\"a\": 5, \"c\": 4, \"b\": 1"));
    }

    @Test
    public void testGetResult_ShouldReturnEmptyStringForEmptyInput() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }
}