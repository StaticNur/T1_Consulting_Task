package com.example.T1_Consulting_Task.controller;

import com.example.T1_Consulting_Task.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculateController {
    private final CalculateService calculateService;

    @Autowired
    public CalculateController(CalculateService calculateService) {
        this.calculateService = calculateService;
    }

    @GetMapping("/{str}")
    public ResponseEntity<String> getResult(@PathVariable("str") String str) {
        return ResponseEntity.ok(calculateService.calculateSymbol(str));
    }
}
