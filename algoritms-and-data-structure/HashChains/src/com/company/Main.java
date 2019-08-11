package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        new Main().run();
    }

    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int m = Integer.parseInt(in.nextLine());
        int n = Integer.parseInt(in.nextLine());
        List<String>[] strings = new ArrayList[m];
        for (int i = 0; i < m; ++i) {
            strings[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; ++i) {
            String[] query = in.nextLine().split(" ");
            switch (query[0]) {
                case "add":
                    int hash = calculateHash(query[1], m);
                    boolean flag = false;
                    for (String s : strings[hash]) {
                        if (s.equals(query[1])){
                            flag = true;
                            break;
                        }
                    }
                    if (!flag)
                        strings[hash].add(query[1]);
                    break;
                case "find":
                    hash = calculateHash(query[1], m);
                    flag = false;
                    for (String s : strings[hash]) {
                        if (s.equals(query[1])) {
                            System.out.println("yes");
                            flag = true;
                            break;
                        }
                    }
                    if (!flag)
                        System.out.println("no");
                    break;
                case "del":
                    hash = calculateHash(query[1], m);
                    for (int j = 0; j < strings[hash].size(); j++) {
                        String s = strings[hash].get(j);
                        if (s.equals(query[1])) {
                            strings[hash].remove(j);
                            break;
                        }
                    }
                    break;
                case "check":
                    int pos = Integer.parseInt(query[1]);
                    if (strings[pos].size() > 0){
                        for (int j = strings[pos].size() - 1; j >= 0; --j){
                            System.out.print(strings[pos].get(j) + " ");
                        }
                        System.out.println();
                    }else {
                        System.out.println();
                    }
                    break;
            }
        }
    }

    private int calculateHash(String s, int m) {
        BigInteger sum = BigInteger.ZERO; BigInteger p = BigInteger.valueOf(1000000007);
        for (int i = 0; i < s.length(); ++i){
            sum = sum.add(BigInteger.valueOf(s.charAt(i)).multiply(pow(i)));
        }
        return sum.mod(p).mod(BigInteger.valueOf(m)).intValue();
    }

    private BigInteger pow(int i){
        BigInteger x = BigInteger.valueOf(263);
        BigInteger res = BigInteger.ONE;
        for (int j = 0; j < i; ++j){
            res = res.multiply(x);
        }
        return res;
    }
}
