// По данному числу 1≤n≤109 найдите максимальное число k, для которого n можно представить как сумму k
// различных натуральных слагаемых. Выведите в первой строке число k, во второй — k слагаемых.

//Sample Input 1:
//4

//Sample Output 1:
//2
//1 3

package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //read number
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int n = num;

        //calculate result
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            if (num - i > i){
                list.add(i);
                num -= i;
            }
            else{
                list.add(num);
                break;
            }
        }

        //output
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
    }
}
