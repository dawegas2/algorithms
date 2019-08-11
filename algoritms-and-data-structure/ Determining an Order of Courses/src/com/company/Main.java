package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    List<Integer> res = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        new Main().run();
    }

    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int n = in.nextInt();
        Vertice[] vertices = new Vertice[n];
        for (int i = 0; i < n; i++){
            vertices[i] = new Vertice();
            vertices[i].setValue(i + 1);
        }
        int m = in.nextInt();
        for (int i = 0; i < m; i++){
            int v = in.nextInt() - 1;
            int u = in.nextInt() - 1;
            vertices[v].addChild(vertices[u]);
            vertices[u].hasParents = true;
        }
        for (int i = 0; i < n; i++){
            if (!vertices[i].hasParents){
                dfs(vertices[i]);
            }
        }
        for (int i = res.size() - 1; i >= 0; i--){
            System.out.print(res.get(i) + " ");
        }
    }

    void dfs(Vertice v){
        if (v.isVisited) {
            return;
        }
        else
            v.isVisited = true;
        for (Vertice child : v.getChildren()) {
            dfs(child);
        }
        res.add(v.getValue());
    }
}

class Vertice{

    private int value;

    private List<Vertice> children;

    boolean hasParents;

    boolean isVisited;

    Vertice(){
        children = new ArrayList<>();
    }

    void setValue(int value){
        this.value = value;
    }

    int getValue(){
        return value;
    }

    void addChild(Vertice v){
        children.add(v);
    }

    List<Vertice> getChildren(){
        return children;
    }
}

