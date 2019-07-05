package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    String input = in.nextLine();
	    int k = input.indexOf("@");
	    int m = input.lastIndexOf("@");
	    String newString = input.substring(0, k+1) + new StringBuilder(input.substring(k+1, m)).reverse() +
				input.substring(m);
	    System.out.println(newString);
    }

}
