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
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int p = in.nextInt();
            System.out.println(buffer.push(new Packet(a, p)));
        }
    }
}

class Queue{

    int size;

    List<Packet> packets;

    Queue(int size) {
        this.size = size;
        packets = new ArrayList<>();
    }


    int push(Packet packet) {
        int releasedItems = binarySearch(packet.getA());
        for (int i = 0; i < releasedItems; ++i) {
            packets.remove(0);
        }
        //packets.subList(0, releasedItems).clear();
        if (packets.size() < size) {
            if (packets.size() == 0) {
                packet.setFinish_time(packet.getP() + packet.getA());
                packets.add(packet);
                return packet.getA();
            } else {
                int prevFinishTime = packets.get(packets.size() - 1).getFinish_time();

                // finish time = previous packet's finish time + processing time
                packet.setFinish_time(prevFinishTime + packet.getP());
                packets.add(packet);
                return prevFinishTime;
            }
        } else {
            return -1;
        }
    }

    private int binarySearch(int time) {
        int left = - 1;
        int right = packets.size();
        while (right > left + 1) {
            int m = (left + right) >> 1;
            if (packets.get(m).getFinish_time() <= time) {
                left = m;
            } else {
                right = m;
            }
        }
        return left + 1;
    }

}

class Packet{
    private int p;

    private int a;

    private int finish_time;

    Packet(int a, int p){
        this.a = a;
        this.p = p;
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

    void setFinish_time(int time){
        finish_time = time;
    }
}
