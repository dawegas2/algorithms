package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        new Main().run();
    }

    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int n = in.nextInt();
        int m = in.nextInt();
        Node[] vertices = new Node[n];
        for (int i = 0; i < n; i++){
            vertices[i] = new Node();
        }
        for (int i = 0; i < m; i++){
            int first = in.nextInt() - 1;
            int second = in.nextInt() - 1;
            vertices[first].children.add(vertices[second]);
            vertices[second].children.add(vertices[first]);
        }
        System.out.println(bfs(vertices[0]));
    }

    private int bfs(Node vertex) {
        vertex.dist = 0;
        Queue queue = new Queue();
        queue.enqueue(vertex);
        while (!queue.isEmpty()){
            Node u = queue.dequeue();
            for (Node child : u.children) {
                if (child.dist == -1){
                    queue.enqueue(child);
                    child.dist = u.dist + 1;
                }else {
                    if (u.dist == child.dist)
                        return 0;
                }
            }
        }
        return 1;
    }

}

class Node{

    List<Node> children;

    int dist;

    Node(){
        children = new ArrayList<>();
        dist = -1;
    }
}

class Queue{

    List<Node> queue;

    Queue(){
        queue = new ArrayList<>();
    }

    Node dequeue(){
        Node node = queue.get(0);
        queue.remove(0);
        return node;
    }

    void enqueue(Node node){
        queue.add(node);
    }

    boolean isEmpty(){
        if (queue.size() > 0)
            return false;
        return true;
    }
}
