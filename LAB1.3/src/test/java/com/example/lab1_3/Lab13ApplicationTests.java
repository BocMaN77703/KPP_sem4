package com.example.lab1_3;

import com.example.lab1_3.response.ExceptionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.lab1_3.controller.ComplexController;
import com.example.lab1_3.exception.CalculationException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.example.lab1_3.entities.Complex;
import org.springframework.http.ResponseEntity;


@SpringBootTest
class Labwork1ApplicationTests {

    private final ComplexController calculationController = new ComplexController();
    //    private final Calculation calculation = new Calculation();
    @Test

    void testCalculateResultPlus_10() throws CalculationException {
       // ResponseEntity(calculationController.complexCalculation("1", "0"));
        Complex result = calculationController.complexCalculation("1", "0");
        Complex expected=new Complex(1.0,1.5707963267948966);
        assertEquals(expected, result);
    }
}
