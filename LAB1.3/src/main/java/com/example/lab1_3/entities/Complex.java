package com.example.lab1_3.entities;
import lombok.Getter;
import lombok.Setter;
public class Complex {
    @Getter
    @Setter
    private double module;
    private double phase;

    public Complex(double module, double phase) {
        this.module = module;
        this.phase = phase;
    }

    public double getModule() {
        return module;
    }

    public void setModule(double module) {
        this.module = module;
    }

    public double getPhase() {
        return phase;
    }

    public void setPhase(double phase) {
        this.phase = phase;
    }
}
