package com.practice.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

public class P15NbitBinaryNumberwithmore1s {

    public List<String> generatebinary(int n) {
        List<String> res = new ArrayList<>();
        if (n < 0) {
            return res;
        }
        recur(n, 0, 0, "", res);
        return res;
    }

    public void recur(int n, int ones, int zeros, String op, List<String> res) {
        if (op.length() == n) {
            res.add(op);
            return;
        }
        if (ones < n) {
            recur(n, ones + 1, zeros, op + "1", res);
        }
        if (zeros < ones) {
            recur(n, ones, zeros + 1, op + "0", res);
        }
    }

    /**
     * another approach
     * 
     * @param args
     */
    public List<String> generateNthBinary(int n) {
        List<String> res = new ArrayList<>();
        if (n < 0) {
            return res;
        }
        int ones = n;
        int zeros = n;
        recursion(n, ones, zeros, "", res);
        return res;
    }

    public void recursion(int n, int ones, int zeros, String op, List<String> res) {
        if (n == 0) {
            res.add(op);
            return;
        }
        recursion(n - 1, ones - 1, zeros, op + "1", res);
        if (zeros > ones) {
            recursion(n - 1, ones, zeros - 1, op + "0", res);
        }
    }

    public static void main(String[] args) {
        P15NbitBinaryNumberwithmore1s obj = new P15NbitBinaryNumberwithmore1s();
        System.out.println(obj.generatebinary(4));
        System.out.println(obj.generateNthBinary(4));
    }

}
