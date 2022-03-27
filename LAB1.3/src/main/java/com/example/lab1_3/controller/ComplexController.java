package com.example.lab1_3.controller;

import com.example.lab1_3.exception.CalculationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.lab1_3.entities.Complex;
import com.example.lab1_3.calculations.Parameters;
import com.example.lab1_3.calculations.Solution;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.lab1_3.cache.Cache;
import java.lang.Math;



@RestController
public class ComplexController {
    @GetMapping("/complex")
    public Complex complexCalculation(@RequestParam(value="real", defaultValue="0") String real,
                                                                @RequestParam(value="imaginable", defaultValue="0") String imaginable) throws CalculationException {
        int intReal;
        int intImaginable;
        if (real.matches("[-+]?\\d+") ){
            intReal = Integer.parseInt(real);

        }
        else throw new CalculationException("Wrong parameter: Real");
        if(imaginable.matches("[-+]?\\d+")) {
            intImaginable = Integer.parseInt(imaginable);
        }
        else throw new CalculationException("Wrong parameter: Imaginable");
        double module, phase;
        //module = Math.sqrt(Math.pow(intReal, 2) + Math.pow(intImaginable, 2));
        //phase = Math.atan2(intReal, intImaginable);

        var solution = new Solution(new Parameters(intReal,intImaginable));
        solution.calculateRoot();

        return new Complex(solution.getRoot());
        //return new ResponseEntity<>(solution.getRoot(), HttpStatus.OK);
    }
    @GetMapping("/cache")
    public ResponseEntity<String> printCache() {
        return new ResponseEntity<>(Cache.getStaticStringCache(), HttpStatus.OK);
    }
}