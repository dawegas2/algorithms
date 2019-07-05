// По данным n отрезкам необходимо найти множество точек минимального размера,
// для которого каждый из отрезков содержит хотя бы одну из точек.
//
// В первой строке дано число 1≤n≤100 отрезков. Каждая из последующих n строк содержит по два числа 0≤l≤r≤109,
// задающих начало и конец отрезка. Выведите оптимальное число m точек и сами m точек.
// Если таких множеств точек несколько, выведите любое из них.

//Sample Input 1:
//
//        3
//        1 3
//        2 5
//        3 6

//Sample Output 1:
//
//        1
//        3

package com.company;

import java.util.*;
import static java.lang.System.out;

class Main {
    public static void main(String[] args) {
        //read data
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++){
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }

        //sort array
        Arrays.sort(arr, Comparator.comparingInt(x->x[1]));

        //add points in list
        List<Integer> points = new ArrayList<>();
        points.add(arr[0][1]);
        for (int i = 1; i < n; i++){
            if (points.get(points.size()-1) < arr[i][0])
                points.add(arr[i][1]);
        }

        //write results
        out.println(points.size());
        for (int i = 0; i < points.size(); i++){
            out.print(points.get(i)+ " ");
        }
    }
}
