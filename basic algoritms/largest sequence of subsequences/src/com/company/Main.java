// Дано целое число 1≤n≤10^3 и массив A[1…n] натуральных чисел, не превосходящих 2⋅10^9.
// Выведите максимальное 1≤k≤n, для которого найдётся подпоследовательность 1≤i1<i2<…<ik≤n длины k,
// в которой каждый элемент делится на предыдущий (формально: для  всех 1≤j<k, A[ij]|A[ij+1]).

//Sample Input:
//4
//3 6 7 12

//Sample Output:
//3

package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	    new Main().run();
    }

    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int n = in.nextInt();
        int[] arr = new int[n];
        int[] elems = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
            int res = 0;
            for (int j = 0; j < i; j++){
                if (arr[i] % arr[j] == 0)
                    res = Math.max(res, elems[j]);
            }
            elems[i] = res + 1;
        }

        int res = elems[0];
        for (int i = 0; i < n; i++){
            res = Math.max(res, elems[i]);
        }
        System.out.println(res);
    }
}
