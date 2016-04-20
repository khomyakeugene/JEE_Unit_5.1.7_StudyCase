package com.company.tasks;

/**
 * Created by Yevgen on 26.03.2016 as a part of the project "JEE_Unit_2_Homework".
 */
public class CalcDistanceTask implements Task<Double> {
    private Point point1;
    private Point point2;
    private Double result;

    public CalcDistanceTask(Double x1, Double y1, Double x2, Double y2) {
        point1 = new Point(x1, y1);
        point2 = new Point(x2, y2);
    }

    @Override
    public void execute() {
        result = Distance.calcDistance(point1, point2);
    }

    @Override
    public Double getResult() {
        return result;
    }
}
