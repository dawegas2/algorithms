package com.company;

import java.util.Scanner;
import java.lang.System;

public class Main {

    public static void main(String[] args) {
        int[] numbers = GetNumbers();
        int k = numbers[0];
        int m = numbers[1];
        if (k != m)
            System.out.println(k+m-1);
        else{
            System.out.println(0);
        }
    }

    //Method for getting variables from the user
    public static int[] GetNumbers(){
        while (true){
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            try{
                int space = input.indexOf(" ");
                int k = Integer.parseInt(input.substring(0, space));
                int m = Integer.parseInt(input.substring(space + 1));
                return new int[]{k, m};
            }catch (Exception e){
                System.out.println("You entered invalid values! Try again!");
            }

        }
    }
}
