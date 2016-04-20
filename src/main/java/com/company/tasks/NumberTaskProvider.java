package com.company.tasks;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yevhen on 19.04.2016.
 */
@Component
public class NumberTaskProvider implements TaskProvider<Number> {
    private static final double emptyDoubleArray[] = {};
    private static final double calcAverageDoubleValueTaskInputData[] = {123.66, 55.0, 729.8, 44.0};
    private static final double TransformCelsiusToFahrenheitTaskInputData = 23.0;
    private static final Double X1 = 3.0;
    private static final Double Y1 = 5.3;
    private static final Double X2 = 7.2;
    private static final Double Y2 = 1.1;


    private List<Task<? extends Number>> tasks = new ArrayList<>();

    @PostConstruct
    public void init() {
        tasks.add(new CalcAverageDoubleValueTask(calcAverageDoubleValueTaskInputData));
        tasks.add(new CalcAverageDoubleValueTask(emptyDoubleArray));
        tasks.add(new TransformCelsiusToFahrenheitTask(TransformCelsiusToFahrenheitTaskInputData));
        tasks.add(new CalcDistanceTask(X1, Y1, X2, Y2));
    }

    @Override
    public List<Task<? extends Number>> getAllTasks() {
        return tasks;
    }
}
