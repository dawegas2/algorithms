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
        int n = Integer.parseInt(in.nextLine());
        Stack stack = new Stack();
        for (int i = 0; i < n; i++){
            String s = in.nextLine();
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
