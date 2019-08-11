package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	    new Main().run();
    }

    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int n = in.nextInt();
        int m = in.nextInt();
        PriorityQueue<Processor> proc = new PriorityQueue<>(n, new Comparator<Processor>() {
            @Override
            public int compare(Processor o1, Processor o2) {
                if (o1.time == o2.time)
                    return Integer.compare(o1.id, o2.id);
                return Long.compare(o1.time, o2.time);
            }
        });
        for (int i = 0; i < n; i++){
            proc.add(new Processor());
        }
        for (int i = 0; i < m; i++){
            long time = in.nextInt();
            process(time, proc);
        }
    }

    private void process(long time, PriorityQueue<Processor> proc){
        Processor peek = proc.peek();
        System.out.println(proc.peek());
        proc.remove(peek);
        peek.time += time;
        proc.add(peek);
    }
}

class Processor{

    static int ID = 0;

    int id;

    long time;

    Processor(){
        id = ID++;
        time = 0;
    }

    @Override
    public String toString() {
        return id + " " + time;
    }
}
