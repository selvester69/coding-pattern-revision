package com.practice.algorithms.scottbarett.linkedlist;
import java.util.Set;
import java.util.HashSet;

import com.practice.datastructure.linkedlist.LinkedList;
import com.practice.datastructure.linkedlist.Node;

public class RemoveDuplicate extends LinkedList {

    public RemoveDuplicate(int val) {
        super(val);
    }

    public static void main(String[] args) {
        RemoveDuplicate myLinkedList = new RemoveDuplicate(1);

        myLinkedList.append(1);
        myLinkedList.append(1);
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(5);
        myLinkedList.append(3);
        myLinkedList.append(4);

        myLinkedList.removeDuplicates();

        myLinkedList.printList();
    }

    private void removeDuplicates() {
        if(head==null) return ;
        Set<Integer> hs = new HashSet<>();
        Node temp = this.head,prev = null;
        while(temp!=null){
            if(hs.contains(temp.value)){
                prev.next = temp.next;
                temp.next = null;
                temp=prev;
            }else {
                hs.add(temp.value);
            }
            prev = temp;
            temp = temp.next;
        }
    }

}
