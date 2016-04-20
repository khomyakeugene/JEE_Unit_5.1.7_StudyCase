package com.company.tasks;

import java.util.Arrays;
import java.util.OptionalDouble;

/**
 * Created by Yevgen on 26.03.2016 as a part of the project "JEE_Unit_2_Homework".
 */
public class CalcAverageDoubleValueTask implements Task<Double> {
    private double inputData[];
    private Double result = null;

    public CalcAverageDoubleValueTask(double[] inputData) {
        this.inputData = inputData;
    }

    @Override
    public void execute() {
        OptionalDouble optionalDoubleResult = Arrays.stream(inputData).average();

        result = optionalDoubleResult.isPresent() ? optionalDoubleResult.getAsDouble() : null;
    }

    @Override
    public Double getResult() {
        return result;
    }
}
