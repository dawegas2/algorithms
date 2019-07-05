// Первая строка содержит количество предметов 1≤n≤103 и вместимость рюкзака 0≤W≤2⋅106.
// Каждая из следующих n строк задаёт стоимость 0≤ci≤2⋅106 и объём 0<wi≤2⋅106 предмета (n, W, ci, wi — целые числа).
// Выведите максимальную стоимость частей предметов (от каждого предмета можно отделить любую часть,
// стоимость и объём при этом пропорционально уменьшатся), помещающихся в данный рюкзак, с точностью не менее
// трёх знаков после запятой.

//Sample Input:
//
//3 50
//60 20
//100 50
//120 30

//Sample Output:
//
//180.000

package com.company;

import java.util.*;
import static java.lang.System.out;

class Main {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new Main().run();
        long finish = System.currentTimeMillis();
        out.println(finish - start);
    }

    private void run() {
        //read data
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double v = in.nextInt();
        double[][] arr = new double[n][2];
        for (int i = 0; i < n; i++){
            arr[i][0] = in.nextInt();
            arr[i][1] = in.nextInt();
        }

        //sort the array
        Arrays.sort(arr, Comparator.comparingDouble(x->1/(x[0]/x[1])));

        //calculate a result
        double sum = 0;
        for (int i = 0; i < n; i++){
            if (arr[i][1] < v){
                sum += arr[i][0];
                v -= arr[i][1];
            }else{
                sum += arr[i][0] / arr[i][1] * v;
                break;
            }
        }

        //output the result
        out.println(sum);
    }
}


