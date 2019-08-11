package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        new Main().run();
    }

    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int n = in.nextInt();
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; ++i) {
            int value = in.nextInt();
            int left = in.nextInt();
            int right = in.nextInt();
            nodes[i] = new Node(value, left, right);
        }
        inorder(nodes, nodes[0]);
        System.out.println();
        preorder(nodes, nodes[0]);
        System.out.println();
        postorder(nodes, nodes[0]);
    }

    private void inorder(Node[] nodes, Node root) {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        stack.push(root);
        while (stack.size() > 0) {
            while (current.left != -1 && !current.wasSelected) {
                stack.push(nodes[current.left]);
                current.wasSelected = true;
                current = nodes[current.left];
            }
            current = stack.pop();
            System.out.print(current.value + " ");
            if (current.right != -1) {
                stack.push(nodes[current.right]);
                current = nodes[current.right];
            }
        }
    }

    private void preorder(Node[] nodes, Node node) {
        System.out.print(node.value + " ");
        if (node.left != -1) {
            preorder(nodes, nodes[node.left]);
        }
        if (node.right != -1) {
            preorder(nodes, nodes[node.right]);
        }
    }

    private void postorder(Node[] nodes, Node node) {
        if (node.left != -1) {
            postorder(nodes, nodes[node.left]);
        }
        if (node.right != -1) {
            postorder(nodes, nodes[node.right]);
        }
        System.out.print(node.value + " ");
    }
}

class Node {
    int value;

    int left;

    int right;

    boolean wasSelected = false;

    Node(int value, int left, int right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
