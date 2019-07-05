// Первая строка входа содержит целые числа 1≤W≤10^4 и 1≤n≤300 — вместимость рюкзака и число золотых
// слитков. Следующая строка содержит n целых чисел 0≤w1,…,wn≤105, задающих веса слитков.
// Найдите максимальный вес золота, который можно унести в рюкзаке.

//Sample Input:
//10 3
//1 4 8

//Sample Output:
//9

package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	    new Main().run();
    }

    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("Input.txt"));
        int w = in.nextInt(); //volume
        int m = in.nextInt(); //number of parts
        int[] arr = new int[m];

        for (int i = 0; i < m; i++){
            arr[i] = in.nextInt();
        }

        int[][] d = new int[m+1][w+1];

        for (int i = 0; i < m; i++){
            d[i][0] = 0;
        }
        for (int i = 0; i < w; i++){
            d[0][i] = 0;
        }
        Arrays.sort(arr);

        for (int j = 1; j <= m; j++){
            for (int i = 1; i <= w; i++){
                d[j][i] = d[j-1][i];
                if (i>= arr[j-1]) {
                    d[j][i] = Math.max(d[j][i], d[j-1][i-arr[j-1]] + arr[j-1]);
                }
            }
        }

        System.out.println(d[m][w]);
    }
}
