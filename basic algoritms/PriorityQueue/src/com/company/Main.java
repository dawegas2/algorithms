//Первая строка входа содержит число операций 1≤n≤105. Каждая из последующих n строк задают операцию
// одного из следующих двух типов:
// 1)Insert x, где 0≤x≤10^9 — целое число;
// 2)ExtractMax.
//Первая операция добавляет число x в очередь с приоритетами, вторая — извлекает максимальное число и выводит его.

//Sample Input:
//6
//Insert 200
//Insert 10
//ExtractMax
//Insert 5
//Insert 500
//ExtractMax

//Sample Output:
//200
//500

package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++){
            String[] line = in.nextLine().split(" ");
            switch (line[0]){
                case Operation.INS:
                    Queue.insert(Integer.parseInt(line[1]));
                    break;
                case Operation.EXT:
                    Queue.extractMax();
                    break;
                default:
                    i--; //do not count if invalid request
                    System.out.println("Invalid request");
            }
            if (line[0].equals(Operation.INS))
                Queue.insert(Integer.parseInt(line[1]));
            else
                System.out.println(Queue.extractMax());
        }
    }
}

class Queue{
    private static ArrayList<Integer> list = new ArrayList<>();

    public static void insert(int x){
        list.add(x);

        int pos = list.size() - 1;
        if (pos > 0){
            while (true){
                if (x > list.get((pos-1)/2))
                {
                    list.set(pos, list.get((pos-1)/2));
                    list.set((pos-1)/2, x);
                    pos = (pos-1)/2;
                }else{
                    break;
                }
            }
        }
    }

    public static int extractMax(){
        int max = list.get(0);
        list.set(0, list.get(list.size()-1));
        list.remove(list.size()-1);

        siftDown();
        return max;
    }

    public static void siftDown(){
        int pos = 0;
        int pos_of_max = 0;
        while (true){
            if (list.size() - 1 < 2*pos + 1)
                return;
            if (list.size() - 1 == 2*pos + 1)
                pos_of_max = 2*pos+1;
            if (list.size() - 1 > 2*pos + 1){
                if (list.get(2*pos+1) > list.get(2*pos+2))
                    pos_of_max = 2*pos+1;
                else
                    pos_of_max = 2*pos+2;
            }

            if (list.get(pos) < list.get(pos_of_max))
            {
                int temp = list.get(pos);
                list.set(pos, list.get(pos_of_max));
                list.set(pos_of_max, temp);
                pos = pos_of_max;
            }else{
                return;
            }
        }

    }
}

class Operation{
    public static final String INS = "Insert";
    public static final String EXT = "ExtractMax";
}
