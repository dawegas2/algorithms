package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	    new Main().run();
    }

    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int n = in.nextInt();
        int m = in.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++){
            nodes[i] = new Node();
        }
        for (int i = 0; i < m; ++i){
            int parent = in.nextInt() - 1;
            int child = in.nextInt() - 1;
            int cost = in.nextInt();
            nodes[parent].children.add(nodes[child]);
            nodes[parent].costs.add(cost);
        }
        int origin = in.nextInt() - 1;
        int destination = in.nextInt() - 1;
        nodes[origin].cost = 0;
        dijkstra(origin, nodes, n);
        if (nodes[destination].cost == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(nodes[destination].cost);
    }

    private void dijkstra(int origin, Node[] nodes, int n) {
        PriorityQueue<Node> queue = new PriorityQueue<>(n, (Node o1, Node o2) -> Integer.compare(o1.cost, o2.cost));
        queue.add(nodes[origin]);
        while (queue.size() > 0){
            Node peek = queue.peek();
            queue.remove(peek);
            for (int i = 0; i < peek.children.size(); ++i){
                Node child = peek.children.get(i);
                if (peek.cost + peek.costs.get(i) < child.cost){
                    child.cost = peek.cost + peek.costs.get(i);
                    queue.add(child);
                }
            }
        }
    }
}

class Node{

    int cost;

    List<Node> children;

    List<Integer> costs;

    Node(){
        cost = Integer.MAX_VALUE;
        children = new ArrayList<>();
        costs = new ArrayList<>();
    }
}
