// В первой строке задано два целых числа 1≤n≤50000 и 1≤m≤50000 — количество отрезков и точек на прямой,
// соответственно. Следующие n строк содержат по два целых числа ai и bi (ai≤bi) — координаты концов отрезков.
// Последняя строка содержит m целых чисел — координаты точек. Все координаты не превышают 108 по модулю.
// Точка считается принадлежащей отрезку, если она находится внутри него или на границе. Для каждой точки в порядке
// появления во вводе выведите, скольким отрезкам она принадлежит.

//Sample Input:
//2 3
//0 5
//7 10
//1 6 11

//Sample Output:
//1 0 0

package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

    public class Main {

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
            int m = in.nextInt();

            //read points
            int[] left = new int[n+2];
            int[] right = new int[n+2];
            for (int i = 1; i < n+1; i++){
                left[i] = in.nextInt();
                right[i] = in.nextInt();
            }
            left[0] = right[0] = Integer.MIN_VALUE;
            left[n+1] = right[n+1] = Integer.MAX_VALUE;
            Arrays.sort(left);
            Arrays.sort(right);

            for (int i = 0; i < m; i++){
                int num = in.nextInt();
                System.out.println(binarySearch(left, num)- binarySearch(right, num-1));
            }

        }

        private static int binarySearch(int[] arr, int value){
            int first = 0;
            int last = arr.length-1;
            while (first <= last){
                int pos = (first + last)/2;
                if (arr[pos] <= value) {
                    if (value < arr[pos+1])
                        return pos;
                    else
                        first = pos + 1;
                }
                else
                    last = pos - 1;
            }
            return first +1;
        }
}
