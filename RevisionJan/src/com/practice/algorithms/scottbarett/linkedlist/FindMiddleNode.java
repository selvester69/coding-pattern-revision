package com.practice.algorithms.scottbarett.linkedlist;

import com.practice.datastructure.linkedlist.LinkedList;
import com.practice.datastructure.linkedlist.Node;

/**
 * this class uses linked list from src\com\practice\datastructure\linkedlist\LinkedList.java
 */
public class FindMiddleNode extends LinkedList {




    
    
    
    public FindMiddleNode(int val) {
        super(val);
    }

    public int findMiddle(){
        if(this.head==null) return 0;
        Node fast = this.head,slow = this.head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.value;
    }

    public static void main(String[] args) {
        FindMiddleNode myLinkedList = new FindMiddleNode(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);
        myLinkedList.printList();
        System.out.println(myLinkedList.findMiddle());
    }

}
