package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{

    private int maxSize = -1;

    public static void main(String[] args) throws FileNotFoundException {
        new Main().run();
    }

    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int n = in.nextInt();
        int m = in.nextInt();
        Cell[] cells = new Cell[n];
        for (int i = 0; i < n; i++){
            int value = in.nextInt();
            cells[i] = new Cell();
            cells[i].pointer = i;
            cells[i].size = value;
            if (value > maxSize)
                maxSize = value;
        }
        for (int i = 0; i < m; i++){
            int destination = in.nextInt() - 1;
            int source = in.nextInt() - 1;
            union(destination, source, cells);
            System.out.println(maxSize);
        }
    }

    private void union(int destination, int source, Cell[] cells) {
        List<Integer> intermediate = new ArrayList<>();
        int ps = source;
        int ds = destination;
        while (cells[ps].pointer != ps){
            intermediate.add(ps);
            ps = cells[ps].pointer;
        }
        while (cells[ds].pointer != ds){
            intermediate.add(ds);
            ds = cells[ds].pointer;
        }
        if (ps == ds)
            return;
        for (Integer item : intermediate) {
            cells[item].pointer = ds;
        }
        cells[ps].pointer = ds;
        cells[ds].size += cells[ps].size;
        if (cells[ds].size > maxSize)
            maxSize = cells[ds].size;
    }
}

class Cell{
    int pointer;

    int size;
}