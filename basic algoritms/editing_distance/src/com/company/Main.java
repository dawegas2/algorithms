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
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        int[][]d = new int[line1.length()+1][line2.length()+1];
        for (int i = 0; i <= line1.length(); i++){
            d[i][0] = i;
        }
        for (int i = 0; i <= line2.length(); i++){
            d[0][i] = i;
        }
        System.out.println(EditDistBU(line1, line2, d));
    }

    private int EditDistBU(String line1, String line2, int[][] d){
        for (int i = 1; i <= line1.length(); i++){
            for (int j = 1; j <= line2.length(); j++){
                int c = line1.charAt(i-1) == line2.charAt(j-1) ? 0 : 1;
                d[i][j] = Math.min(d[i - 1][j] + 1, Math.min(d[i][j-1] + 1, d[i-1][j-1] + c));
            }
        }
        return d[line1.length()][line2.length()];
    }
}
