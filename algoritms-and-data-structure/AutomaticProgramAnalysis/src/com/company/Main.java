package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	    new Main().run();
    }

    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int n = in.nextInt();
        int e = in.nextInt();
        int d = in.nextInt();
        int[] variables = new int[n];

        for (int i = 0; i < n; ++i) {
            variables[i] = -1;
        }

        // create set
        for (int i = 0; i < e; ++i) {
            int v1 = in.nextInt() - 1;
            int v2 = in.nextInt() - 1;
            unite(variables, v1, v2);
        }

        // find variance
        boolean hasError = false;
        for (int i = 0; i < d; ++i) {
            int v1 = in.nextInt() - 1;
            int v2 = in.nextInt() - 1;
            int[] parents = find(variables, v1, v2);
            if (parents[0] == parents[1]) {
                hasError = true;
                break;
            }
        }
        if (hasError)
            System.out.println(0);
        else
            System.out.println(1);
    }

    void unite(int[] variables, int v1, int v2) {
        int[] parents = find(variables, v1, v2);
        if (parents[0] != parents[1]) {
            variables[parents[0]] = parents[1];
        }
    }

    int[] find(int[] variables, int v1, int v2) {
        int copy1 = v1;
        int copy2 = v2;
        while (variables[v1] != -1) {
            v1 = variables[v1];
        }
        if (v1 != copy1) {
            variables[copy1] = v1;
        }
        while (variables[v2] != -1) {
            v2 = variables[v2];
        }
        if (v2 != copy2) {
            variables[copy2] = v2;
        }
        return new int[] {v1, v2};
    }
}

