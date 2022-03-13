package com.example.lab1_3.controller;

import com.example.lab1_3.exception.CalculationException;
import com.example.lab1_3.response.ExceptionResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.lab1_3.entities.Complex;
import java.lang.Math;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
public class ComplexController {
    @GetMapping("/complex")
    ResponseEntity<ExceptionResponse> complexCalculation(@RequestParam(value="real", defaultValue="0") String real,
                               @RequestParam(value="imaginable", defaultValue="0") String imaginable) throws CalculationException {

        if (real.matches("[-+]?\\d+") && imaginable.matches("[-+]?\\d+")) {
            int intReal = Integer.parseInt(real);
            int intImaginable = Integer.parseInt(imaginable);
            double module, phase;
            module = Math.sqrt(Math.pow(intReal, 2) + Math.pow(intImaginable, 2));
            phase = Math.atan2(intReal, intImaginable);
            return new ResponseEntity(new Complex(module, phase), HttpStatus.BAD_REQUEST);

        }
        else throw new CalculationException("Wrong parameters");
    }
}