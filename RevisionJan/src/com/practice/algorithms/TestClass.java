package com.practice.algorithms;

import java.util.HashMap;
import java.util.Map;

public class TestClass {

    public static void main(String[] args) {
        int num = 3749;
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        StringBuilder res = new StringBuilder("");
        int place = 0;
        while (num > 0) {
            int d = num % 10;
            num = num / 10;
            place++;
            int n = d * place;
            if (map.containsKey(n)) {
                res.insert(0, map.get(n));
            }
            System.out.println(res.toString());
        }
        System.out.println(res.toString());
    }

}
