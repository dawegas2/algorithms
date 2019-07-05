package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Reachability().main();
    }
}

class Reachability {
    private static boolean[] visited;

    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        explore(adj, x);
        if (visited[y])
            return 1;
        return 0;
    }

    private static void explore(ArrayList<Integer>[] adj, int x){
        visited[x] = true;
        for (Integer integer : adj[x]) {
            if (!visited[integer])
                explore(adj, integer);
        }
    }


    public static void main() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            visited[i] = false;
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}