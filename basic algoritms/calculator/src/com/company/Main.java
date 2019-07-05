// У вас есть примитивный калькулятор, который умеет выполнять всего три операции с текущим числом x:
// заменить x на 2x, 3x или x+1. По данному целому числу 1≤n≤105 определите минимальное число операций k,
// необходимое, чтобы получить n из 1. Выведите k и последовательность промежуточных чисел.

//Sample Input 1:
//1
//Sample Output 1:
//0
//1

//Sample Input 2:
//5
//Sample Output 2:
//3
//1 2 4 5

//Sample Input 3:
//96234
//Sample Output 3:
//14
//1 3 9 10 11 22 66 198 594 1782 5346 16038 16039 32078 96234

package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	    new Main().run();
    }

    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int n = in.nextInt();
        int[] numbers = new int[n+1];
        int[] d = new int[n+1];
        int[] p = new int[n+1];
        d[0] = 0;
        for (int i = 1; i < n+1; i++){
            d[i] = d[i-1] + 1;
            p[i] = i - 1;
            numbers[i] = numbers[i-1]+1;
            if (i % 2 == 0){
                if (d[i/2] + 1 < d[i]){
                    d[i] = d[i/2] + 1;
                    numbers[i] = numbers[i/2]*2;
                    p[i] = i / 2;
                }
            }
            if (i % 3 == 0){
                if (d[i/3] + 1 < d[i]){
                    d[i] = d[i/3] + 1;
                    numbers[i] = numbers[i/3]*3;
                    p[i] = i / 3;
                }
            }
        }

        System.out.println(d[n]-1);
        List<Integer> res = new ArrayList<>();
        res.add(n);
        while (p[n] >= 1){
            res.add(numbers[p[n]]);
            n = p[n];
        }
        for (int i = res.size() - 1; i >= 0; i--) {
            System.out.print(res.get(i) + " ");
        }
    }
}
