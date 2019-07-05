// Дано целое число 1≤n≤10^5и массив A[1…n], содержащий неотрицательные целые числа, не превосходящие 10^9.
// Найдите наибольшую невозрастающую подпоследовательность в A. В первой строке выведите её длину k, во
// второй — её индексы 1≤i1<i2<…<ik≤n (таким образом, A[i1]≥A[i2]≥…≥A[in]).

//Sample Input:
//5
//5 3 4 4 2

//Sample Output:
//4
//1 3 4 5

package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        new Main().run();
    }

    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int n = in.nextInt();
        int[] arr = new int[n];
        int[] d = new int[n + 1];
        int[] pd = new int[n];
        int[] pa = new int[n];
        int[] temp = new int[n+1];
        for (int i = 0; i < n; i++) {
            pd[i] = -1;
            pa[i] = -1;
            arr[i] = in.nextInt();
            d[i] = -1;
            temp[i] = -1;
        }
        d[0] = Integer.MAX_VALUE;
        d[n] = temp[n] = -1;

        for (int i=0; i<n; i++){
            int j = binarySearch(d, i + 1, arr[i]);
            d[j] = arr[i];
            pd[i] = j;
            temp[j] = i;
            pa[i] = temp[j - 1];
        }

        //output
        int max = -1;
        int ind = 0;
        for (int i = 0; i < n; i++){
            if (pd[i] > max){
                max = pd[i];
                ind = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        while (ind > -1){
            list.add(ind + 1);
            ind = pa[ind];
        }
        Integer[] res = list.toArray(new Integer[list.size()]);
        Arrays.sort(res);
        System.out.println(res.length);
        for (Integer item : res) {
            System.out.print(item + " ");
        }
    }

    private int binarySearch(int[] d, int n, int x){
        int l = -1;
        int r = n;
        while (r > l + 1){
            int m = (l + r) >> 1;
            if (d[m] >= x)
                l = m;
            else
                r = m;
        }
        return l + 1;
    }
}
