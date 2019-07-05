// Даны число 1≤n≤102 ступенек лестницы и целые числа −104≤a1,…,an≤104, которыми помечены ступеньки.
// Найдите максимальную сумму, которую можно получить, идя по лестнице снизу вверх (от нулевой до n-й ступеньки),
// каждый раз поднимаясь на одну или две ступеньки.

// Sample Input 1:
// 2
// 1 2

// Sample Output 1:
// 3

// Sample Input 2:
// 2
// 2 -1

// Sample Output 2:
// 1

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
        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        int[] d = new int[n];

        d[0] = arr[0];
        if (n > 1)
            d[1] = Math.max(d[0] + arr[1], arr[1]);
        for (int i = 2; i < n;i++) {
            d[i] = Math.max(d[i-1], d[i - 2]) + arr[i];
        }
        System.out.println(d[n-1]);
    }
}
