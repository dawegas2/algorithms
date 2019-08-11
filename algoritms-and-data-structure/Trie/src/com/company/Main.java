package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args){
        new Trie().run();
    }
}

class Trie {
    void run(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] patterns = new String[n];
        for (int i = 0; i < n; i++){
            patterns[i] = in.next();
        }
        List<Node> nodes = constructTrie(patterns);
        printResult(nodes);
    }

    private void printResult(List<Node> nodes) {
        for (Node node : nodes) {
            System.out.println(node.getParent() + "->" + node.getPosition()
                    + ":" + node.getChar());
        }
    }

    private List<Node> constructTrie(String[] patterns){
        List<Node> trie = new ArrayList<>();
        Node root = new Node(' ', 0, -1);
        for (String pattern : patterns) {
            Node cur = root;
            for (int i = 0; i < pattern.length(); i++){
                cur = cur.getChild(pattern.charAt(i));
                if (!trie.contains(cur))
                    trie.add(cur);
            }
        }
        return trie;
    }
}

class Node{
    private Character c;
    private int pos;
    private static int count = 0;
    private int parent;
    private List<Node> children;
    Node(Character c, int pos, int parent){
        children = new ArrayList<>();
        this.c = c;
        this.pos = pos;
        this.parent = parent;
    }

    Character getChar(){
        return c;
    }

    int getParent(){
        return parent;
    }

    int getPosition(){
        return pos;
    }

    Node getChild(Character c){
        Node result = null;
        for (Node node : children) {
            if (node.getChar().equals(c))
            {
                result = node;
                break;
            }
        }
        if (result == null){
            result = new Node(c, ++count, pos);
            children.add(result);
        }
        return result;
    }
}

