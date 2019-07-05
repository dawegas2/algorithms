// Первая строка содержит число 1≤n≤10^5, вторая — массив A[1…n], содержащий натуральные числа, не превосходящие
// 109. Необходимо посчитать число пар индексов 1≤i<j≤n, для которых A[i]>A[j]. (Такая пара элементов называется
// инверсией массива. Количество инверсий в массиве является в некотором смысле его мерой неупорядоченности:
// например, в упорядоченном по неубыванию массиве инверсий нет вообще, а в массиве, упорядоченном по убыванию,
// инверсию образуют каждые два элемента.)

//Sample Input:
//5
//2 3 9 2 9

//Sample Output:
//2

package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    private long inversions = 0;

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Scanner in = null;
        try {
            in = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int n = in.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++){
            arr[i] = in.nextLong();
        }
        mergeSort(arr, 0, arr.length-1);

        System.out.println(inversions);
    }

    private long[] mergeSort(long[] arr, int start, int finish){
        long[] res = null;
        if (start < finish){
            int center = (start + finish) / 2;
            res = merge(mergeSort(arr, start, center), mergeSort(arr, center + 1, finish));
        }else{
            res = new long[]{arr[start]};
        }
        return res;

    }

    private long[] merge(long[] left, long[] right){
        int l_pos = 0;
        int r_pos = 0;
        int i = 0;
        long[] arr = new long[left.length + right.length];
        while (l_pos < left.length && r_pos < right.length){
            if (left[l_pos] <= right[r_pos]){
                arr[i] = left[l_pos++];
                i++;
            }
            else{
                arr[i] = right[r_pos++];
                i++;
                inversions += left.length - l_pos;
            }
        }
        if (l_pos == left.length){
            while (r_pos < right.length){
                arr[i] = right[r_pos++];
                i++;
            }
        }else{
            while (l_pos < left.length) {
                arr[i] = left[l_pos++];
                i++;
            }
        }
        return arr;
    }
}
