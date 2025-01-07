package com.practice.algorithms.scottbarett.linkedlist;

import com.practice.datastructure.linkedlist.LinkedList;
import com.practice.datastructure.linkedlist.Node;

public class ReverseBetween extends LinkedList {

    public ReverseBetween(int val) {
        super(val);
    }

    public static void main(String[] args) {

        // Create a linked list with values 1, 2, 3, 4, and 5
        ReverseBetween myLinkedList = new ReverseBetween(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);

        System.out.println("Original linked list: ");
        myLinkedList.printList();

        // Reverse a sublist within the linked list
        myLinkedList.reverseBetween(1, 3);
        System.out.println("\nReversed sublist (1, 3): ");
        myLinkedList.printList();

        // Reverse another sublist within the linked list
        myLinkedList.reverseBetween(0, 4);
        System.out.println("\nReversed entire linked list: ");
        myLinkedList.printList();

        // Reverse a sublist of length 1 within the linked list
        myLinkedList.reverseBetween(2, 2);
        System.out.println("\nReversed sublist of length 1 (2, 2): ");
        myLinkedList.printList();

        // Reverse an empty linked list
        ReverseBetween emptyList = new ReverseBetween(0);
        // emptyList.makeEmpty();
        emptyList.reverseBetween(0, 0);
        System.out.println("\nReversed empty linked list: ");
        emptyList.printList();

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * Original linked list:
         * 1
         * 2
         * 3
         * 4
         * 5
         * 
         * Reversed sublist (1, 3):
         * 1
         * 4
         * 3
         * 2
         * 5
         * 
         * Reversed entire linked list:
         * 5
         * 2
         * 3
         * 4
         * 1
         * 
         * Reversed sublist of length 1 (2, 2):
         * 5
         * 2
         * 3
         * 4
         * 1
         * 
         * Reversed empty linked list:
         * 
         */
    }

    private void reverseBetween(int start, int end) {
        if(length==0) return;
        if(start<0 || end >length || start>end || start==end){
            return;
        }
        Node curr = head;
        Node prev = null;
        int i=0;
        for(;i<start;i++){
            prev= curr;
            curr = curr.next;
        }
        Node after = null,before=null,revTail = curr;
        while(i<=end){
            after = curr.next;
            curr.next = before;
            before = curr;
            curr = after;
            i++;
        }
        if(prev!=null){
            prev.next = before;
        }
        else {
            head = before;
        }
        revTail.next = curr;
    }

}
