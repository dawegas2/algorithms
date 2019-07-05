package com.company;

import java.util.Scanner;

public class CountSort {
    public void run(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }

        arr = sort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private int[] sort(int[] arr) {
        int[] b = new int[10];
        int[] a = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            b[arr[i]]++;
        }
        for (int i = 1; i < 10; i++){
            b[i] += b[i-1];
        }
        for (int i = arr.length-1; i >= 0; i--){
            a[b[arr[i]]-1] = arr[i];
            b[arr[i]]--;
        }
        return a;
    }
}
