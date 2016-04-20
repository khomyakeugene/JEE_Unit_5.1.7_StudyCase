package com.company.tasks;

/**
 * Created by Yevgen on 26.03.2016 as a part of the project "JEE_Unit_2_Homework".
 */
public class TransformCelsiusToFahrenheitTask implements Task<Double> {
    private Double celsiusDegree;
    private Double result;

    public TransformCelsiusToFahrenheitTask(Double celsiusDegree) {
        this.celsiusDegree = celsiusDegree;
    }

    @Override
    public void execute() {
        result = Temperature.transformCelsiusToFahrenheit(celsiusDegree);
    }

    @Override
    public Double getResult() {
        return result;
    }
}
