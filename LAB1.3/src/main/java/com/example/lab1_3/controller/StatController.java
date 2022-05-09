package com.example.lab1_3.controller;

import com.example.lab1_3.calculations.Calculation;
import com.example.lab1_3.cache.Cache;
import com.example.lab1_3.Statistics.StatChanger;
import com.example.lab1_3.Statistics.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/statistics")
public class StatController {
    private final StatChanger statProv;

    @Autowired
    public StatController(StatChanger statProv) {
        this.statProv = statProv;
    }

    @GetMapping
    public ResponseEntity<Statistics> getAllStats() {
        statProv.calculate();
        return new ResponseEntity<>(statProv.getStats(), HttpStatus.OK);
    }
}