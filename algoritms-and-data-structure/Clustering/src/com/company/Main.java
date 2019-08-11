package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws FileNotFoundException {
        new Main().run();
    }

    void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int n = in.nextInt();
        Point[] points = new Point[n];
        Path[] paths = new Path[calculateNumberOfPaths(n)];
        for (int i = 0; i < n; ++i) {
            points[i] = new Point(in.nextInt(), in.nextInt());
        }
        for (int i = 0, ind = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j, ++ind) {
                paths[ind] = new Path(points[i], points[j]);
                paths[ind].dist = calculateDist(points[i], points[j]);
            }
        }
        Arrays.sort(paths, Comparator.comparingDouble(Path::getDist));
        int k = in.nextInt();
        for (Path path : paths) {
            Point p1 = find(path.p1);
            Point p2 = find(path.p2);
            if (p1 != p2) {
                if (n == k) {
                    System.out.printf("%.7f", path.dist);
                    break;
                } else {
                    n -= 1;
                }
                p1.pointer = p2;
            }
        }
    }

    private Point find(Point point) {
        Point pointer = point.pointer;
        while (pointer != pointer.pointer) {
            pointer = pointer.pointer;
        }
        point.pointer = pointer;
        return pointer;
    }

    private double calculateDist(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    private int calculateNumberOfPaths(int n) {
        int res = 0;
        for (int i = 1; i < n; ++i) {
            res += i;
        }
        return res;
    }

    private class Point {
        int x;

        int y;

        Point pointer;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
            pointer = this;
        }
    }

    private class Path {
        Point p1;

        Point p2;

        double dist;

        Path(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
            dist = Double.MAX_VALUE;
        }

        double getDist() {
            return dist;
        }
    }
}
