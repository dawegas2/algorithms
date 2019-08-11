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
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; ++i) {
            long value = in.nextLong();
            int left = in.nextInt();
            int right = in.nextInt();
            nodes[i] = new Node(value, left, right);
        }
        if (n == 0) {
            System.out.println("CORRECT");
            return;
        }
        checkIsBST(nodes);
        if (flag) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }

    private boolean flag = true;

    private void checkIsBST(Node[] nodes) {
        for (Node node : nodes) {
            if (node != null) {
                if (node.left != -1 && findMax(nodes, nodes[node.left]) > node.value) {
                    flag = false;
                    return;
                }
                if (node.right != -1 && findMin(nodes, nodes[node.right]) < node.value) {
                    flag = false;
                    return;
                }
            }
        }
    }

    private long findMax(Node[] nodes, Node node) {
        while (node.right != -1) {
            node = nodes[node.right];
        }
        return node.value;
    }

    private long findMin(Node[] nodes, Node node) {
        while (node.left != -1) {
            node = nodes[node.left];
        }
        return node.value;
    }
}

class Node {
    long value;

    int left;

    int right;

    Node(long value, int left, int right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}