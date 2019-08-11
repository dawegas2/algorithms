package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    List<Swap> swaps = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        new Main().run();
    }

    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        for (int i = n / 2; i >= 0; i--){
            siftDown(arr, i);
        }
        System.out.println(swaps.size());
        for (Swap swap : swaps) {
            System.out.println(swap);
        }
    }

    private void siftDown(int[] arr, int pos){
        int left = 2 * pos + 1;
        int right = 2 * pos + 2;
        if (right < arr.length){
            if (arr[left] < arr[right] && arr[left] < arr[pos]){
                int temp = arr[pos];
                arr[pos] = arr[left];
                arr[left] = temp;
                swaps.add(new Swap(pos, left));
                pos = left;
                siftDown(arr, pos);
                return;
            }
            if (arr[right] < arr[left] && arr[right] < arr[pos]){
                int temp = arr[pos];
                arr[pos] = arr[right];
                arr[right] = temp;
                swaps.add(new Swap(pos, right));
                pos = right;
                siftDown(arr, pos);
            }
        }else{
            if (left < arr.length){
                if (arr[left] < arr[pos]){
                    int temp = arr[pos];
                    arr[pos] = arr[left];
                    arr[left] = temp;
                    swaps.add(new Swap(pos, left));
                    pos = left;
                    siftDown(arr, pos);
                }
            }
        }
    }
}

class Swap{
    int first;

    int second;

    Swap(int first, int second){
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return first + " " + second;
    }
}
