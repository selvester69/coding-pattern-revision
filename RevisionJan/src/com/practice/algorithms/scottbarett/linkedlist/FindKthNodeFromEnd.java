package com.practice.algorithms.scottbarett.linkedlist;

import com.practice.datastructure.linkedlist.LinkedList;
import com.practice.datastructure.linkedlist.Node;

public class FindKthNodeFromEnd extends LinkedList {

    public FindKthNodeFromEnd(int val) {
        super(val);
    }

    public Node findKthFromEnd(int k){
        if(this.head==null) return this.head;
        Node fast = this.head;
        for(int i=0;i<k;i++){
            if(fast==null){
                return null;
            }
            fast = fast.next;
        }
        Node slow = this.head;
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    
    public static void main(String[] args) {
        FindKthNodeFromEnd myLinkedList = new FindKthNodeFromEnd(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);

        int k = 2;
        int result = myLinkedList.findKthFromEnd(k).value;

        System.out.println(result);
    }

}
