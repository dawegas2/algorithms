package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new ConnectedComponents().main();
    }
}

class ConnectedComponents {
    private static boolean[] visited;

    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int result = 0;
        for (int i = 0; i < adj.length; i++){
            if (!visited[i]){
                result++;
                explore(adj, i);
            }
        }
        return result;
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
        System.out.println(numberOfComponents(adj));
    }
}
