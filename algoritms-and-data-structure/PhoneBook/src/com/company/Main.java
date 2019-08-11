package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        new Main().run();
    }

    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int n = Integer.parseInt(in.nextLine());
        int m = 1000;
        List<Contact>[] contacts = new ArrayList[m];
        for (int i = 0; i < m; ++i){
            contacts[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; ++i){
            String[] query = in.nextLine().split(" ");
            switch (query[0]){
                case "add":
                    int hash = calculateHash(query[1]);
                    boolean flag = false;
                    for (Contact contact : contacts[hash]) {
                        if (contact.number.equals(query[1])){
                            contact.name = query[2];
                            flag = true;
                            break;
                        }
                    }
                    if (!flag)
                        contacts[hash].add(new Contact(query[1], query[2]));
                    break;
                case "find":
                    hash = calculateHash(query[1]);
                    flag = false;
                    for (Contact contact : contacts[hash]) {
                        if (contact.number.equals(query[1])){
                            System.out.println(contact.name);
                            flag = true;
                            break;
                        }
                    }
                    if (!flag)
                        System.out.println("not found");
                    break;
                case "del":
                    hash = calculateHash(query[1]);
                    for (int j = 0; j < contacts[hash].size(); j++){
                        Contact contact = contacts[hash].get(j);
                        if (contact.number.equals(query[1])){
                            contacts[hash].remove(j);
                            break;
                        }
                    }
                    break;
            }
        }
    }

    private int calculateHash(String number){
        int num = Integer.parseInt(number);
        int m = 1000, a = 23, b = 79, p = (int)Math.pow(10, 7) + 7;
        return ((a * num + b) % p ) % m;
    }
}

class Contact {

    String number;

    String name;

    Contact(String number, String name){
        this.number = number;
        this.name = name;
    }
}
