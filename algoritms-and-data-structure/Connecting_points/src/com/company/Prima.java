package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prima {

    public void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int n = in.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; ++i) {
            points[i] = new Point(in.nextInt(), in.nextInt());
        }
        calculateMstWithPrimaAlgo(points);
        double sum = 0;
        for (Point point : points) {
            sum += point.dist;
        }
        System.out.printf("%.9f", sum);
    }

    private void calculateMstWithPrimaAlgo(Point[] points) {
        points[0].dist = 0;
        PriorityQueue<Point> pq = new PriorityQueue<>(points.length, (p1, p2) -> Double.compare(p1.dist, p2.dist));
        for (Point point : points) {
            pq.add(point);
        }
        while (pq.size() > 0) {
            Point peek = pq.peek();
            for (Point point : points) {
                if (point != peek && point != peek.parent) {
                    double dist = calculateDist(point, peek);
                    if (point.dist > dist) {
                        point.dist = dist;
                        point.parent = peek;
                    }
                }
            }
            pq.remove(peek);
        }
    }

    private double calculateDist(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    private class Point {

        double dist;

        int x;

        int y;

        Point parent;

        Point(int x, int y) {
            dist = Double.MAX_VALUE;
            this.x = x;
            this.y = y;
        }
    }
}


