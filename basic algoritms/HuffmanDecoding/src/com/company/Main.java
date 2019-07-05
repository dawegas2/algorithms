//Восстановите строку по её коду и беспрефиксному коду символов.

// В первой строке входного файла заданы два целых числа k и l через пробел — количество различных букв,
// встречающихся в строке, и размер получившейся закодированной строки, соответственно. В следующих k строках
// записаны коды букв в формате "letter: code". Ни один код не является префиксом другого. Буквы могут быть
// перечислены в любом порядке. В качестве букв могут встречаться лишь строчные буквы латинского алфавита;
// каждая из этих букв встречается в строке хотя бы один раз. Наконец, в последней строке записана закодированная
// строка. Исходная строка и коды всех букв непусты. Заданный код таков, что закодированная строка имеет
// минимальный возможный размер.

// В первой строке выходного файла выведите строку s. Она должна состоять из строчных букв латинского алфавита.
// Гарантируется, что длина правильного ответа не превосходит 10^4 символов.

//Sample Input:
//4 14
//a: 0
//b: 10
//c: 110
//d: 111
//01001100100111

//Sample Output :
//abacabad

package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        int k = Integer.parseInt(input[0]);
        int l = Integer.parseInt(input[1]);

        Map<String, String> map = new HashMap<>();
        for (int i =0; i < k; i++){
            input = in.nextLine().split(": ");
            map.put(input[1], input[0]);
        }

        String code = in.nextLine();
        String substr = "";
        String res = "";
        for (int i = 0; i  < l; i++){
            substr += code.charAt(i);
            if (map.get(substr) != null){
                res += map.get(substr);
                substr = "";
            }
        }

        System.out.println(res);
    }
}
