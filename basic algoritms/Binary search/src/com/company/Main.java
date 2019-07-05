// В первой строке даны целое число 1≤n≤10^5 и массив A[1…n] из n различных натуральных чисел, не превышающих 10^9,
// в порядке возрастания, во второй — целое число 1≤k≤10^5 и k натуральных чисел b1,…,bk, не превышающих 10^9.
// Для каждого i от 1 до k необходимо вывести индекс 1≤j≤n, для которого A[j]=bi, или −1, если такого j нет.

//Sample Input:
//5 1 5 8 12 13
//5 8 1 23 1 11

//Sample Output:
//3 1 -1 1 -1

package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.System.*;

public class Main {

    public static void main(String[] args) {
        long begin = currentTimeMillis();
        new Main().run();
        long end = currentTimeMillis();
        out.println(end - begin);
    }

    private void run() {
        Scanner in = null;
        try {
            in = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        int length = in.nextInt();
        for (int i = 0; i < length; i++){
            int value = in.nextInt();
            //System.out.print(binarySearchRecursion(arr, value, 0, n-1) +  " ");
            out.print(binarySearchLoop(arr, value) + " ");
        }
    }

    private static int binarySearchRecursion(int[] arr, int value, int first, int last){
        if (first >= last)
            return -1;
        int pos = first + (last - first)/2;
        if (arr[pos] == value)
            return pos + 1;
        if (arr[pos] > value)
            return binarySearchRecursion(arr, value, first, pos - 1);
        if (arr[pos] < value)
            return binarySearchRecursion(arr, value, pos + 1, last);
        return 0;
    }

    private static int binarySearchLoop(int[] arr, int value){
        int first = 0;
        int last = arr.length-1;
        while (first <= last){
            int pos = (first + last)/2;
            if (arr[pos] == value)
                return pos + 1;
            if (arr[pos] > value)
            {
                last = pos - 1;
            }else{
                first = pos + 1;
            }
        }
        return -1;
    }
}
