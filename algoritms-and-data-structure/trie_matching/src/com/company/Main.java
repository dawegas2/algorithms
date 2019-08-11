package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args){
        new TrieMatchingExtended ().main(null);
    }
}

class TrieMatchingExtended  {

    private List<Integer> positions;

    public static void main (String [] args) {
        new TrieMatchingExtended ().run();
    }

    void run(){
        positions = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String text = in.next();
        int n = in.nextInt();
        String[] patterns = new String[n];
        for (int i = 0; i < n; i++){
            patterns[i] = in.next() + "$";
        }
        List<Node> nodes = constructTrie(patterns);
        checkMatching(nodes, text);
        for (int position : positions) {
            System.out.print(position + " ");
        }
    }

    private void checkMatching(List<Node> nodes, String text) {
        for (int i = 0; i < text.length(); i++){
            prefixTrieMatching(text.substring(i), nodes, i);
        }
    }

    private void prefixTrieMatching(String text, List<Node> trie, int pos) {
        int len = 0;
        char symbol = text.charAt(len);
        Node v = trie.get(0); //root of trie
        while (len <= text.length()){
            boolean flag = false;
            for (Node child : v.getChildren()) {
                if (child.getChar() == '$'){
                    positions.add(pos);
                    return;
                }
                if (child.getChar() == symbol){
                    len++;
                    if (len < text.length())
                        symbol = text.charAt(len);
                    v = child;
                    flag = true;
                    break;
                }
            }
            if (!flag)
                break;
        }

    }

    private List<Node> constructTrie(String[] patterns){
        List<Node> trie = new ArrayList<>();
        Node root = new Node(' ');
        trie.add(root);
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
    private List<Node> children;
    Node(Character c){
        children = new ArrayList<>();
        this.c = c;
    }

    Character getChar(){
        return c;
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
            result = new Node(c);
            children.add(result);
        }
        return result;
    }

    List<Node> getChildren(){
        return children;
    }
}

