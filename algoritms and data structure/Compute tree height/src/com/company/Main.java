package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private int maxDepth;

    private int[] a;

    private Node[] nodes;

    private Node root;

    public static void main(String[] args) throws FileNotFoundException {
	    new Main().run();
    }

    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int n = in.nextInt();
        a = new int[n];
        nodes = new Node[n];
        root = new Node();
        for (int i = 0; i < n; i++){
            a[i] = in.nextInt();
            nodes[i] = new Node();
        }
        for (int i = 0; i < n; i++){
            if (a[i] == -1){
                root.addChildren(nodes[i]);
                nodes[i].setParent(root);
            }else{
                nodes[a[i]].addChildren(nodes[i]);
                nodes[i].setParent(nodes[a[i]]);
            }
        }
        root.setDepth(0);
        findNode(root);

        System.out.println(maxDepth);
    }

    private void findNode(Node node) {
        maxDepth = maxDepth > node.getDepth() ? maxDepth : node.getDepth();
        for (Node child : node.getChildren()) {
            child.setDepth(node.getDepth() + 1);
            findNode(child);
        }
    }
}

class Node{
    private int depth;
    private List<Node> children;
    private Node parent;

    Node(){
        children = new ArrayList<>();
    }

    void setDepth(int depth){
        this.depth = depth;
    }

    int getDepth(){
        return depth;
    }

    void setParent(Node node){
        parent =  node;
    }

    Node getParent(){
        return parent;
    }

    void addChildren(Node node){
        children.add(node);
    }

    List<Node> getChildren(){
        return children;
    }
}
