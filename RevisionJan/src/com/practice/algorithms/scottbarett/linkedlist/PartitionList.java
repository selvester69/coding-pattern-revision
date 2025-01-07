package com.practice.algorithms.scottbarett.linkedlist;

import com.practice.datastructure.linkedlist.LinkedList;
import com.practice.datastructure.linkedlist.Node;

public class PartitionList extends LinkedList {

    public PartitionList(int val) {
        super(val);
    }

    public static void main(String[] args) {
        PartitionList ll = new PartitionList(3);
        ll.append(5);
        ll.append(8);
        ll.append(10);
        ll.append(2);
        ll.append(1);

        // Print the list before partitioning
        System.out.println("LL before partitionList:");
        // ll.printList(); // Output: 3 5 8 10 2 1

        // Call the partitionList method with x = 5
        ll.partitionList(3);

        // Print the list after partitioning
        System.out.println("LL after partitionList:");
        ll.printList(); // Output: 3 2 1 5 8 10

    }

    private void partitionList(int i) {
        Node before = new Node(0);
        Node after = new Node(0);
        Node t1 = before,t2 = after;
        Node temp = this.head;
        while (temp != null) {
            if (temp.value < i) {
                t1.next = temp;
                t1 = temp;
            } else {
                t2.next = temp;
                t2 = temp;
            }
            temp = temp.next;
        }
        t2.next = null;
        t1.next = after.next;
        this.head = before.next;
    }

}
