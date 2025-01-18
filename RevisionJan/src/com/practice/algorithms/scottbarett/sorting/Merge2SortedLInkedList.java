package com.practice.algorithms.scottbarett.sorting;

import com.practice.datastructure.linkedlist.LinkedList;
import com.practice.datastructure.linkedlist.Node;

public class Merge2SortedLInkedList extends LinkedList {

    public Merge2SortedLInkedList(int val) {
        super(val);
    }

    public static void main(String[] args) {

        Merge2SortedLInkedList l1 = new Merge2SortedLInkedList(1);
        l1.append(3);
        l1.append(5);
        l1.append(7);

        Merge2SortedLInkedList l2 = new Merge2SortedLInkedList(2);
        l2.append(4);
        l2.append(6);
        l2.append(8);

        l1.merge(l2);

        l1.printAll();

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * Head: 1
         * Tail: 8
         * Length:8
         * 
         * Linked List:
         * 1
         * 2
         * 3
         * 4
         * 5
         * 6
         * 7
         * 8
         * 
         */

    }

    private void merge(Merge2SortedLInkedList other) {
        Node l1 = this.head;
        Node newHead = new Node(0);
        Node temp = newHead;
        Node l2 = other.getHead();
        if (l1 == null)
            this.head = l2;
        if (l2 == null)
            this.head = l1;
        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                newHead.next = l1;
                l1 = l1.next;
            } else {
                newHead.next = l2;
                l2 = l2.next;
            }
            newHead = newHead.next;
        }
        if (l1 != null) {
            newHead.next = l1;
        } else {
            newHead.next = l2;
            this.tail = other.getTail();
        }
        this.head = temp.next;
        this.length += other.getLength();
    }
}
