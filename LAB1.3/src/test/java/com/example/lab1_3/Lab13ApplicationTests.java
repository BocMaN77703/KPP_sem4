package com.example.lab1_3;

import com.example.lab1_3.controller.MyCounter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.lab1_3.controller.ComplexController;
import com.example.lab1_3.exception.CalculationException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.lab1_3.entities.Complex;

import java.util.DoubleSummaryStatistics;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;


@SpringBootTest
class ApplicationTests {

    private final ComplexController calculationController = new ComplexController();
//    @Test
//
//    void test1() throws CalculationException {
//        Complex result = calculationController.complexCalculation("1", "0");
//        Complex expected=new Complex(1.0,1.5707963267948966);
//        assertEquals(expected, result);
//    }
@Test
void testIncrement() {
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    MyCounter counterService=new MyCounter();
    IntStream.range(0, 10000).forEach(count -> executorService.execute(counterService::increaseCounter));

    executorService.shutdown();
    try {
        if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
            executorService.shutdownNow();
        }
    } catch (InterruptedException e) {
        executorService.shutdownNow();
    }

    assertEquals(10000, counterService.getValue(), "Synchronization check");
}
}
