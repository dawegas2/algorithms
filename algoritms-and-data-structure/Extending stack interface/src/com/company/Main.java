package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File("input.txt")));
        int n = Integer.parseInt(in.readLine());
        Stack stack = new Stack();
        for (int i = 0; i < n; i++){
            String s = in.readLine();
            String[] arr = s.split(" ");
            switch (arr[0]){
                case ("push"):
                    stack.push(Integer.parseInt(arr[1]));
                    break;
                case ("pop"):
                    stack.pop();
                    break;
                case ("max"):
                    stack.max();
                    break;
            }
        }
    }
}

class Stack{

    private List<Integer> nums;

    private int pos;

    private List<Integer> maxValue;

    Stack(){
        nums = new ArrayList<>();
        maxValue = new ArrayList<>();
        pos = -1;
    }

    void push(int a){
        nums.add(a);
        if (pos != -1)
            maxValue.add(maxValue.get(pos) > a ? maxValue.get(pos) : a);
        else{
            maxValue.add(a);
        }
        pos++;
    }

    void pop(){
        nums.remove(pos);
        maxValue.remove(pos);
        pos--;
    }

    void max(){
        System.out.println(maxValue.get(pos));
    }
}
