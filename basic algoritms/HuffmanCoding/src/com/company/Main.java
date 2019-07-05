// По данной непустой строке s длины не более 10^4, состоящей из строчных букв латинского алфавита,
// постройте оптимальный беспрефиксный код. В первой строке выведите количество различных букв k,
// встречающихся в строке, и размер получившейся закодированной строки. В следующих k строках запишите
// коды букв в формате "letter: code". В последней строке выведите закодированную строку.

//Sample Input 1:
//a

//Sample Output 1:
//1 1
//a: 0
//0

package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++){
            if (map.containsKey(input.charAt(i))){
                map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
            }else{
                map.put(input.charAt(i), 1);
            }
        }

        ArrayList<Node> nodes = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            nodes.add(new LeafNode(entry.getKey(), entry.getValue()));
        }
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(nodes);

        while (priorityQueue.size() > 1){
            Node a =  priorityQueue.poll();
            Node b = priorityQueue.poll();
            InternalNode node = new InternalNode(a, b);
            node.changeCode("");
            priorityQueue.add(node);
        }

        Node root = priorityQueue.poll();
        if (nodes.size() == 1){
            root.changeCode("0");
        }else{
            root.changeCode("");
        }

        Map<Character, String> codes = new HashMap<>();
        for (Node node : nodes){
            codes.put(node.character, node.code);
        }

        //code string
        StringBuilder codedString = new StringBuilder();
        for (int i = 0; i < input.length(); i++){
            codedString.append(codes.get(input.charAt(i)));
        }
        int sum = codedString.length();

        //output
        System.out.println(nodes.size() + " " + sum);
        for (Node node : nodes){
            System.out.println(node.character + ": " + node.code);
        }
        System.out.println(codedString);
    }
}

class Node implements Comparable<Node>{
    Character character;
    int iterations;
    String code = "";

    @Override
    public int compareTo(Node o) {
        return Integer.compare(iterations, o.iterations);
    }

    void changeCode(String code){
        this.code = code;
    }
}

class LeafNode extends Node{
    public LeafNode(char symbol, int iterations){
        this.character = symbol;
        this.iterations = iterations;
    }

    @Override
    void changeCode(String code){
        super.changeCode(code);
    }

}

class InternalNode extends Node{
    Node leftChild;
    Node rightChild;

    public InternalNode(Node leftChild, Node rightChild){
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.iterations = leftChild.iterations + rightChild.iterations;
    }

    @Override
    void changeCode(String code){
        super.changeCode(code);
        leftChild.changeCode(code + "0");
        rightChild.changeCode(code + "1");
    }

}
