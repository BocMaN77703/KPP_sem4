package com.example.lab1_3.calculations;


import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.lang.Nullable;
import java.util.Objects;

public class Parameters {

    // Method equals() overriding
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (obj == null || obj.getClass() != this.getClass())
            return false;

        Parameters params = (Parameters) obj;

        return  Objects.equals(firstValue,  params.firstValue)  &&
                Objects.equals(secondValue, params.secondValue);
    }

    // Method hashCode() overriding
    @Override
    public int hashCode() {
        return Objects.hash(firstValue, secondValue);
    }

    private @Nullable Integer firstValue;

    private @Nullable Integer secondValue;


    public Parameters(
            @Nullable Integer firstValue,
            @Nullable Integer secondValue
    ) {
        if (firstValue == null && secondValue == null)
            throw new IllegalArgumentException("No first and second values!");

        if (firstValue == null)
            throw new IllegalArgumentException("No first value!");

        if (secondValue == null)
            throw new IllegalArgumentException("No second value!");

        this.firstValue  = firstValue;
        this.secondValue = secondValue;
    }

    @NotNull
    @Contract(pure = true)
    public Integer getFirstValue() {
        assert firstValue != null;
        return firstValue;
    }

    @NotNull
    @Contract(pure = true)
    public Integer getSecondValue() {
        assert secondValue != null;
        return secondValue;
    }





    public void setFirstValue(@Nullable Integer firstValue) {
        this.firstValue = firstValue;
    }

    public void setSecondValue(@Nullable Integer secondValue) {
        this.secondValue = secondValue;
    }

}