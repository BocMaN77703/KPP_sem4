package com.example.lab1_3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.lab1_3.entities.Complex;
import java.lang.Math;

@RestController
public class ComplexController {
    @GetMapping("/complex")
    Complex complexCalculation(@RequestParam(value="real", defaultValue="0") int real,
                               @RequestParam(value="imaginable", defaultValue="0") int imaginable)
    {
        double module=0, phase=0;
        module=Math.sqrt(Math.pow(real,2)+Math.pow(imaginable,2));
        phase=Math.atan2(real, imaginable);
        return new Complex(module, phase);
    }

}
