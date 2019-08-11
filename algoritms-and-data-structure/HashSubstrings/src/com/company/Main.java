package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(new File("input.txt")));
        String pattern = in.readLine();
        String text = in.readLine();
        int patternHash = calculateHash(pattern);
        BufferedWriter write = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = text.length() - pattern.length() + 1;
        String s = text.substring(0, pattern.length());
        StringBuilder res = new StringBuilder();
        int textHash = calculateHash(s);
        if (patternHash == textHash && pattern.equals(s)){
            res.append(0 + " ");
        }
        for (int i = 1; i < n; ++i){
            s = text.substring(i, i + pattern.length());
            textHash = recalculateHash(textHash, text.charAt(i - 1), text.charAt(i + pattern.length() - 1));
            if (patternHash == textHash && pattern.equals(s)){
                res.append(i + " ");
            }
        }
        System.out.println(res);
    }

    private int calculateHash(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); ++i){
            sum += s.charAt(i);
        }
        return sum;
    }

    private int recalculateHash(int hash, char first, char last){
        return hash - (int) first + (int) last;
    }
}
