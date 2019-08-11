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
        int res = 0;
        for (int i = 0; i < n; ++i){
            if (nodes[i].cost == Integer.MAX_VALUE){
                res = Integer.max(dijkstra(i, nodes, n), res);
                if (res == 1)
                    break;
            }
        }
        System.out.println(res);
    }

    private int dijkstra(int origin, Node[] nodes, int n) {
        PriorityQueue<Node> queue = new PriorityQueue<>(n, (o1, o2) -> o2.cost.compareTo(o1.cost));
        for (Node node : nodes) {
            node.wasSelected = false;
        }
        nodes[origin].cost = 0;
        nodes[origin].wasSelected = true;
        queue.add(nodes[origin]);
        while (queue.size() > 0){
            Node peek = queue.peek();
            queue.remove(peek);
            for (int i = 0; i < peek.children.size(); ++i){
                Node child = peek.children.get(i);
                if (peek.cost + peek.costs.get(i) < child.cost){
                    if (child.wasSelected && child.cost + peek.costs.get(i) < 0){
                        return 1;
                    }
                    child.wasSelected = true;
                    child.cost = peek.cost + peek.costs.get(i);
                    queue.add(child);
                }
            }
        }
        return 0;
    }
}

class Node{

    Integer cost;

    List<Node> children;

    List<Integer> costs;

    boolean wasSelected;

    Node(){
        cost = Integer.MAX_VALUE;
        children = new ArrayList<>();
        costs = new ArrayList<>();
    }
}
