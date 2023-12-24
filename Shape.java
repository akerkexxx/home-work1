package com.fxdj;

public class Shape {
    private Point[] points;
    private double perim;
    public Shape(Point[] points) {
        this.points = points;
    }

    public double perimeter() {
        double perimeter = 0;
        int len = points.length;
        for (int i = 0; i < len; i++) {
            Point currentPoint = points[i];
            Point nextPoint = points[(i + 1) % len];
            perimeter += currentPoint.distanceTo(nextPoint);
        }
        this.perim = perimeter;
        return perimeter;
    }


    public double averageSide() {
            int numOfSides = points.length;
            return (perim/numOfSides);
    }

    public double longestSide() {
        double longestSide = 0;
        for (int i = 0; i < points.length; i++) {
            Point currentPoint = points[i];
            Point nextPoint = points[(i + 1) % points.length];
            longestSide = Math.max(currentPoint.distanceTo(nextPoint), longestSide);

        }
        return longestSide;
    }
}
