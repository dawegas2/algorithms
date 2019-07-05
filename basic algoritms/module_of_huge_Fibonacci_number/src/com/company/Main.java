//Даны целые числа 1≤n≤10^18 и 2≤m≤10^5, необходимо найти остаток от деления n-го числа Фибоначчи на m.
//Sample Input:
//10 2

//Sample Output:
//1

package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    new Main().run();
    }

    private void run() {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        int m = in.nextInt();

        //list of reminders
        List<Integer> rmd = new ArrayList<>();

        rmd.add(0);
        rmd.add(1);

        for(int i = 2; i < m * 6; i++){
            rmd.add((rmd.get(i - 1) + rmd.get(i - 2)) % m);
            if(rmd.get(i) == 1 && rmd.get(i-1) == 0){
                break;
            }
        }

        //remove repetitions
        for(int i = 0; i < 2; i++){
            rmd.remove(rmd.size() - 1);
        }

        //output
        if (n == 0)
            System.out.println(1);
        else
            System.out.println(rmd.get((int)(n % rmd.size())));
    }
}
