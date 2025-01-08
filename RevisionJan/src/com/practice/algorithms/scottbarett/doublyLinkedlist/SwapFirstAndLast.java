package com.practice.algorithms.scottbarett.doublyLinkedlist;

import com.practice.datastructure.doublyLinkedList.DoublyLinkedList;

public class SwapFirstAndLast extends DoublyLinkedList {
    public SwapFirstAndLast(int value) {
        super(value);
    }

    public static void main(String[] args) {
        SwapFirstAndLast myDLL = new SwapFirstAndLast(1);
        myDLL.append(2);
        myDLL.append(3);
        myDLL.append(4);
        myDLL.append(5);

        System.out.println("DLL before swap:");
        myDLL.printList();

        myDLL.swapFirstLast();

        System.out.println("\nDLL after swap:");
        myDLL.printList();
    }

    public void swapFirstLast() {
        if (length < 2)
            return;
        int val = this.head.value;
        this.head.value = this.tail.value;
        this.tail.value = val;

    }

}
