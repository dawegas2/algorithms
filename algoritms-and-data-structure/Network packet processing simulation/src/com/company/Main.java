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
        int size = in.nextInt();
        int n = in.nextInt();
        Queue buffer = new Queue(size);
        for (int i = 0; i < n; i++){
            int a = in.nextInt();
            int p = in.nextInt();
            System.out.println(buffer.addPacket(new Packet(a, p)));
        }
    }
}

class Queue{
    private int size;

    private int time;

    private int filled;

    private Packet previous;

    private int index = 0;

    Queue(int size){
        this.size = size;
    }

    int addPacket(Packet packet){
        int space = size;
        boolean flag = false;
        pop(packet.getA());
        if (previous != null && previous.getA() == packet.getA()){
            space -= previous.getP();
            flag = true;
        }
        int range = previous != null ? previous.getFinish_time() - packet.getA() : 0;
        if (flag)
            space += 1;
        if (range <= space){
            previous = packet;
            previous.setFinish_time(range > 0 ? range : 0);
            return range > 0 ? range + packet.getA(): packet.getA();
        }else{
            return -1;
        }
    }

    void pop(int time){
        if (previous != null && previous.getA() != time){
            filled -= previous.getFinish_time();
        }
    }
}

class Packet{
    private int p;

    private int a;

    private int finish_time;

    Packet(int a, int p){
        this.a = a;
        this.p = p;
        finish_time = a + p;
    }

    int getP(){
        return p;
    }

    int getA(){
        return a;
    }

    int getFinish_time(){
        return finish_time;
    }

    void setFinish_time(int buffer){
        finish_time += buffer;
    }
}
