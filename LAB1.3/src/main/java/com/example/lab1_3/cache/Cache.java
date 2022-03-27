package com.example.lab1_3.cache;

import com.example.lab1_3.controller.ComplexController;
import com.example.lab1_3.entities.Complex;
import org.apache.logging.log4j.Level;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.example.lab1_3.errorlogger.LogErrors;
import com.example.lab1_3.calculations.Parameters;
import com.example.lab1_3.logger.ProgramLogger;

import java.util.HashMap;
import java.util.Map;

public class Cache {

    private static final Map<Parameters, Complex> solutions = new HashMap<>();

    public void add(@NotNull Parameters params, @NotNull Complex root) {
        if (!solutions.containsKey(params)) {
            solutions.put(params, root);
            ProgramLogger.log(Level.INFO, "Value " + params + "@" + root + " added to cache!");
        }
    }

    public @Nullable Complex find(@NotNull Parameters params) {
        if (solutions.containsKey(params))
            return solutions.get(params);

        ProgramLogger.log(Level.WARN, "Value " + params + " was not found in cache!");
        return null;
    }

    @Contract(pure = true)
    public @NotNull String getStringCache() {
        return ("Cache:\n" + solutions);
    }

    @Contract(pure = true)
    public static @NotNull String getStaticStringCache() {
        return ("Cache:\n" + solutions);
    }

    @Contract(pure = true)
    public Map<Parameters, Complex> getSolutions() {
        return solutions;
    }
}