package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    private int order = 1;

    private int numberOfSCC = 0;

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
            vertices[u].addChild(vertices[v]);
            vertices[v].addParent(vertices[u]);
        }
        for (int i = 0; i < n; i++){
            dfs(vertices[i]);
        }
        Arrays.sort(vertices, (o1, o2) -> Integer.compare(o2.getPostOrder(), o1.getPostOrder()));
        for (int i = 0; i < n; i++){
            vertices[i].isVisited = false;
            vertices[i].swap();
        }
        for (int i = 0; i < n; i++){
            if (!vertices[i].isVisited) {
                dfs(vertices[i]);
                numberOfSCC++;
            }
        }
        System.out.println(numberOfSCC);
    }

    private void dfs(Vertice v){
        if (v.isVisited) {
            return;
        }
        else
            v.isVisited = true;
        order++; //preorder
        for (Vertice child : v.getChildren()) {
            dfs(child);
        }
        int postOrder = order++;
        v.setPostOrder(postOrder);
    }
}

class Vertice{
    private List<Vertice> children;

    private List<Vertice> parents;

    boolean isVisited;

    private int postOrder;

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

    void setPostOrder(int value){
        postOrder = value;
    }

    int getPostOrder(){
        return postOrder;
    }

    void swap(){
        List<Vertice> temp = children;
        children = parents;
        parents = temp;
    }
}
