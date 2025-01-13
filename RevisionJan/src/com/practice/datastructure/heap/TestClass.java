package com.practice.datastructure.heap;

public class TestClass {
    public static void main(String[] args) {
        MaxHeap myHeap = new MaxHeap();
        myHeap.insert(95);
        myHeap.insert(75);
        myHeap.insert(80);
        myHeap.insert(55);
        myHeap.insert(60);
        myHeap.insert(50);
        myHeap.insert(65);

        System.out.println(myHeap.getHeap());

        myHeap.remove();

        System.out.println(myHeap.getHeap());

        myHeap.remove();

        System.out.println(myHeap.getHeap());

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * [95, 75, 80, 55, 60, 50, 65]
         * [80, 75, 65, 55, 60, 50]
         * [75, 60, 65, 55, 50]
         * 
         */

    }

}
