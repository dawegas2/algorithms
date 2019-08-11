package com.company;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //new Prima().run(); // crushes on some tests (do not know why)
        new Kruskal().run(); // passes all tests
    }
}

