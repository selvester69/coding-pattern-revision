package com.practice.algorithms.scottbarett.doublyLinkedlist;

import com.practice.datastructure.doublyLinkedList.DoublyLinkedList;
import com.practice.datastructure.doublyLinkedList.Node;

public class SwapNodeinPairs extends DoublyLinkedList {

    public SwapNodeinPairs(int value) {
        super(value);
    }

    public static void main(String[] args) {

        SwapNodeinPairs myDll = new SwapNodeinPairs(1);
        myDll.append(2);
        myDll.append(3);
        myDll.append(4);

        System.out.println("myDll before swapPairs:");
        myDll.printList();

        myDll.swapPairs();

        System.out.println("\nmyDll after swapPairs:");
        myDll.printList();

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * myDll before swapPairs:
         * 1 <-> 2 <-> 3 <-> 4
         * 
         * myDll after swapPairs:
         * 2 <-> 1 <-> 4 <-> 3
         * 
         */

    }

    private void swapPairs() {
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        Node temp = head;
        while (temp != null && temp.next != null) {
            Node first = temp;
            Node second = temp.next;
            prev.next = second;
            first.next = second.next;
            second.next = first;

            second.prev = prev;
            first.prev = second;
            if (first.next != null) {
                first.next.prev = first;
            }
            temp = first.next;
            prev = first;
        }
        this.head = dummy.next;
        if (head != null) {
            head.prev = null;
        }

    }

}
