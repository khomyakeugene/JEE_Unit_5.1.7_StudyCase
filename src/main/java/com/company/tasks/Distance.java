package com.company.tasks;

/**
 * Created by Yevgen on 03.01.2016.
 */
public class Distance {
    public static Double calcDistance(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point2.getX()-point1.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2));
    }
}
