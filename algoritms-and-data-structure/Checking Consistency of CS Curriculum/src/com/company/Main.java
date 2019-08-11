package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private int res = 0; // 0 means there are no cycles

    public static void main(String[] args) throws FileNotFoundException {
	    new Main().run();
    }

    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int n = in.nextInt();
        Vertice[] vertices = new Vertice[n];
        for (int i = 0; i < n; i++){
            vertices[i] = new Vertice();
        }
        int m = in.nextInt();
        for (int i = 0; i < m; i++){
            int v = in.nextInt() - 1;
            int u = in.nextInt() - 1;
            vertices[v].addChild(vertices[u]);
            vertices[u].addParent(vertices[v]);
        }
        boolean selected = false;
        for (int i = 0; i < n; i++){
            if (vertices[i].getParents() != null && !vertices[i].hasParents()){
                selected = true;
                res = Math.max(res, dfs(vertices[i]));
            }
        }
        if (!selected)
            res = 1;
        System.out.println(res);
    }

    int dfs(Vertice v){
        if (v.isVisited && v.getParents() != null) {
            return 1;
        }
        else
            v.isVisited = true;
        for (Vertice child : v.getChildren()) {
            if (dfs(child) == 1)
                return 1;
            child.setParents();
        }
        return 0;
    }
}

class Vertice{
    private List<Vertice> children;

    private List<Vertice> parents;

    boolean isVisited;

    Vertice(){
        children = new ArrayList<>();
        parents = new ArrayList<>();
    }

    void addChild(Vertice v){
        children.add(v);
    }

    List<Vertice> getChildren(){
        return children;
    }

    List<Vertice> getParents(){
        return parents;
    }

    void setParents(){
        parents = null;
    }

    boolean hasParents(){
        if (parents.size() == 0)
            return false;
        return true;
    }

    void addParent(Vertice v){
        parents.add(v);
    }
}
