package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //array to sort
        int[] arr = CreateArray(10000000);

        //quick sort
        long start = System.currentTimeMillis();
        new QuickSort().run(arr.clone());
        long finish = System.currentTimeMillis();
        System.out.println("Quick sort lasts in " + (finish - start) + " ms");

        //merge sort
        start = System.currentTimeMillis();
        new MergeSort().run(arr.clone());
        finish = System.currentTimeMillis();
        System.out.println("Merge sort lasts in " + (finish - start) + " ms");

        //heap sort
        start = System.currentTimeMillis();
        new HeapSort().run(arr.clone());
        finish = System.currentTimeMillis();
        System.out.println("Heap sort lasts in " + (finish - start) + " ms");

        //java default array sort
        start = System.currentTimeMillis();
        Arrays.sort(arr.clone());
        finish = System.currentTimeMillis();
        System.out.println("Default sort lasts in " + (finish - start) + " ms");
    }

    private static Random rnd = new Random();

    private static int[] CreateArray(int length){
        int[] arr = new int[length];
        for (int i = 0; i < length; i++){
            arr[i] = rnd.nextInt();
        }
        return arr;
    }

}
