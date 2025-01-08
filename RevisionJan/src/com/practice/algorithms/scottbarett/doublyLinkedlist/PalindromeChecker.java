package com.practice.algorithms.scottbarett.doublyLinkedlist;

import com.practice.datastructure.doublyLinkedList.DoublyLinkedList;
import com.practice.datastructure.doublyLinkedList.Node;

public class PalindromeChecker extends DoublyLinkedList {

    public PalindromeChecker(int value) {
        super(value);
    }

    public static void main(String[] args) {
        PalindromeChecker myDLL1 = new PalindromeChecker(1);
        myDLL1.append(2);
        myDLL1.append(3);
        myDLL1.append(2);
        myDLL1.append(1);

        System.out.println("myDLL1 isPalindrome:");
        System.out.println(myDLL1.isPalindrome());

        PalindromeChecker myDLL2 = new PalindromeChecker(1);
        myDLL2.append(2);
        myDLL2.append(3);

        System.out.println("\nmyDLL2 isPalindrome:");
        System.out.println(myDLL2.isPalindrome());

        /*
         * EXPECTED OUTPUT:
         * ----------------
         * DLL before swap:
         * 1
         * 2
         * 3
         * 4
         * 5
         * 
         * DLL after swap:
         * 5
         * 2
         * 3
         * 4
         * 1
         * 
         */
    }

    private boolean isPalindrome() {
        Node start = this.head;
        Node end = this.tail;
        if (this.length == 0 || this.length == 1)
            return true;
        while (start != end) {
            if (start.value != end.value)
                return false;
            start = start.next;
            end = end.prev;
        }
        return true;
    }
}
