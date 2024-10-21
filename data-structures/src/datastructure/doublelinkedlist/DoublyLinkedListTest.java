package datastructure.doublelinkedlist;

import datastructure.doublelinkedlist.DoublyLinkedList.Node;

public class DoublyLinkedListTest {

    public static void main(String[] args) {
        DoublyLinkedList myDLL = new DoublyLinkedList(7);
        myDLL.append(1);
        myDLL.append(2);
        myDLL.append(3);
        myDLL.append(4);
        myDLL.append(6);
        myDLL.append(7);
        myDLL.printAll();

        // Node removed = myDLL.get(4);
        System.out.println("get = "+myDLL.get(myDLL.length/2).value);
        myDLL.printList();
    }
}
