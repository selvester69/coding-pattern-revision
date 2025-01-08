package com.practice.algorithms.scottbarett.doublyLinkedlist;

import com.practice.datastructure.doublyLinkedList.DoublyLinkedList;
import com.practice.datastructure.doublyLinkedList.Node;

public class ReverseDll extends DoublyLinkedList {

    public ReverseDll(int value) {
        super(value);

    }

    public static void main(String[] args) {
        ReverseDll myDLL = new ReverseDll(1);
        myDLL.append(2);
        myDLL.append(3);
        myDLL.append(4);
        myDLL.append(5);

        System.out.println("DLL before reverse:");
        myDLL.printList();

        myDLL.reverse();

        System.out.println("\nDLL after reverse:");
        myDLL.printList();

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * DLL before reverse:
         * 1
         * 2
         * 3
         * 4
         * 5
         * 
         * DLL after reverse:
         * 5
         * 4
         * 3
         * 2
         * 1
         * 
         */
    }

    private void reverse() {
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;
        Node before = null;
        while(temp!=null){
            Node after = temp.next;
            temp.next = before;
            temp.prev = after;
            before = temp;
            temp = after;
        }
    }
}
