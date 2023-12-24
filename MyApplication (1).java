package com.fxdj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyApplication {
    public static void main(String[] args) {
        // Specify the file path on your desktop
        String filePath = "/Users/Acer/Desktop/source.txt"; // Replace with your actual file path

        try {
            List<Point> points = readCoordinatesFromFile(filePath);
            Shape shape = new Shape(points.toArray(new Point[0]));

            double perimeter = shape.perimeter();
            double longestSide = shape.longestSide();
            double averageSide = shape.averageSide();

            System.out.println("Perimeter: " + perimeter);
            System.out.println("Longest side: " + longestSide);
            System.out.println("Average side: " + averageSide);
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found.");
        }
    }

    private static List<Point> readCoordinatesFromFile(String filePath) throws FileNotFoundException {
        List<Point> points = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filePath));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] coordinates = line.split(",");

            try {
                // Parse coordinates as numbers using Double.parseDouble()
                double x = Double.parseDouble(coordinates[0].trim());
                double y = Double.parseDouble(coordinates[1].trim());
                points.add(new Point(x, y));
            } catch (NumberFormatException e) {
                System.err.println("Invalid coordinate format in line: " + line);
                // Skip this line if there's a parsing error
                continue;
            }
        }

        scanner.close();
        return points;
    }
}
