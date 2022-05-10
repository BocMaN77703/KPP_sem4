package com.example.lab1_3.Statistics;

import com.example.lab1_3.logger.ProgramLogger;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.Level;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

@Service
public class StatChanger {
    private static List<Integer> roots = new ArrayList<>();
    private Statistics stats=new Statistics();
    private static boolean shouldBeRecalculated = true;
    @Autowired
    public void setStats(Statistics stats) {
        this.stats = stats;
    }
    public Statistics getStats() {
        return stats;
    }
    public void increaseTotalRequests() {
        stats.totalRequests++;
    }
    public void increaseWrongRequests() {
        stats.wrongRequests++;
    }
    public void calculate() {
        ProgramLogger.log(Level.INFO, "Collecting stats...");

        if (!shouldBeRecalculated) {
            ProgramLogger.log(Level.WARN, "Stats need not to be recollected!");
            return;
        }

        try {
            stats.mostCommon = roots
                    .stream()
                    .reduce(
                            BinaryOperator.maxBy(Comparator.comparingInt(o -> Collections.frequency(roots, o)))
                    ).orElse(0);

            roots = roots
                    .stream()
                    .distinct()
                    .sorted()
                    .collect(Collectors.toList());

            stats.min = roots
                    .stream()
                    .min(Comparator.comparing(Long::valueOf))
                    .orElse(0);

            stats.max = roots
                    .stream()
                    .max(Comparator.comparing(Long::valueOf))
                    .orElse(0);

            ProgramLogger.log(Level.WARN, "Stats recollected!");

            shouldBeRecalculated = false;
        } catch (NullPointerException exception) {
            ProgramLogger.log(Level.ERROR, "Error while collecting stats!");
            throw new RuntimeException(exception);
        }
    }
    public void addRoot(@NotNull Integer root) {
        roots.add(root);
        shouldBeRecalculated = true;
    }
}