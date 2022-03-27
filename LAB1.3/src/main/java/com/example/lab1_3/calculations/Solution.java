package com.example.lab1_3.calculations;

import com.example.lab1_3.SpringConfig;
import com.example.lab1_3.cache.Cache;
import com.example.lab1_3.logger.ProgramLogger;
import org.apache.logging.log4j.Level;
import org.jetbrains.annotations.Nullable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.lab1_3.entities.Complex;

public class Solution {

    private final Cache cache;

    private final Parameters parameters;

    private Complex root;

    public Solution(Parameters params) {
        var context = new AnnotationConfigApplicationContext(SpringConfig.class);
        cache = context.getBean("cache", Cache.class);
        context.close();
        this.parameters = params;
    }

    public void calculateRoot() {
        var temp = cache.find(parameters);
        if (temp != null) {
            ProgramLogger.log(Level.WARN, "Value found in cache!");
            setRoot(temp);
            return;
        }
        Complex tmp=new Complex(Math.sqrt(Math.pow(parameters.getFirstValue(), 2) + Math.pow(parameters.getSecondValue(), 2)),
                Math.atan2(parameters.getFirstValue(), parameters.getSecondValue()));
        setRoot(tmp);
        cache.add(parameters, root);
    }

    public Complex getRoot() {
        return root;
    }

    public void setRoot(@Nullable Complex root) {
        this.root = root;
    }

}