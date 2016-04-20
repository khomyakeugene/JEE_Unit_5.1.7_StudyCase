package com.company.tasks.implementation;

import com.company.tasks.*;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Yevgen on 26.03.2016 as a part of the project "JEE_Unit_2_Homework".
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TaskExecutorTest {
    private static final double emptyDoubleArray[] = {};
    private static final double calcAverageDoubleValueTaskInputData[] = {123.66, 55.0, 729.8, 44.0};
    private static final double TransformCelsiusToFahrenheitTaskInputData = 23.0;
    private static final Double X1 = 3.0;
    private static final Double Y1 = 5.3;
    private static final Double X2 = 7.2;
    private static final Double Y2 = 1.1;

    private static TaskExecutor<Number> taskExecutor = new TaskExecutor<>();

    @BeforeClass
    public static void setUpClass() throws Exception {
        taskExecutor.addTask(new CalcAverageDoubleValueTask(calcAverageDoubleValueTaskInputData), new NotNullValidator<>());
        taskExecutor.addTask(new CalcAverageDoubleValueTask(emptyDoubleArray), new NotNullValidator<>());
        taskExecutor.addTask(new TransformCelsiusToFahrenheitTask(TransformCelsiusToFahrenheitTaskInputData));
    }

    @Test(timeout = 1000, expected = IllegalStateException.class)
    public void test1_testGetValidResultsBeforeExecute() throws Exception {
        taskExecutor.getValidResults();
    }

    @Test(timeout = 1000, expected = IllegalStateException.class)
    public void test2_testGetInvalidResultsBeforeExecute() throws Exception {
        taskExecutor.getInvalidResults();
    }

    @Test(timeout = 1000)
    public void test3_testAddTaskBeforeExecute() throws Exception {
        taskExecutor.addTask(new CalcDistanceTask(X1, Y1, X2, Y2));
    }

    @Test(timeout = 1000)
    public void test4_testExecute() throws Exception {
        taskExecutor.execute();
    }

    @Test(timeout = 1000, expected = IllegalStateException.class)
    public void test5_testAddTaskAfterExecute() throws Exception {
        taskExecutor.addTask(new CalcAverageDoubleValueTask(emptyDoubleArray), new NotNullValidator<>());
    }

    @Test(timeout = 1000)
    public void test6_testGetValidResultsAfterExecute() throws Exception {
        List<Number> expected = new ArrayList<>();

        // Directly execute all tasks which were added to <taskExecutor> before and store its result into <expected>
        OptionalDouble od = Arrays.stream(calcAverageDoubleValueTaskInputData).average();
        expected.add(od.isPresent() ? od.getAsDouble() : null);
        expected.add(Temperature.transformCelsiusToFahrenheit(TransformCelsiusToFahrenheitTaskInputData));
        expected.add(Distance.calcDistance(new Point(X1, Y1), new Point(X2, Y2)));

        // Actual data
        List<Number> actual = taskExecutor.getValidResults();

        // Try to compare as double
        assertArrayEquals(expected.stream().mapToDouble(Number::doubleValue).toArray(),
                actual.stream().mapToDouble(Number::doubleValue).toArray(), 0.0);
    }

    @Test(timeout = 1000)
    public void test7_testGetInvalidResultsAfterExecute() throws Exception {
        List<Number> expected = new ArrayList<>();
        expected.add(null);

        List<Number> actual = taskExecutor.getInvalidResults();

        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}