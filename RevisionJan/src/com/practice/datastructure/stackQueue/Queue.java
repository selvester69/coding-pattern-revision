package com.practice.datastructure.stackQueue;

public class Queue {
    Node first;
    Node last;
    int length;

    public Queue(int value) {
        Node newNode = new Node(value);
        this.first = newNode;
        this.last = newNode;
        this.length = 1;
    }
    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("First: null");
            System.out.println("Last: null");
        } else {
            System.out.println("First: " + first.value);
            System.out.println("Last: " + last.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nQueue:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
    
    public void makeEmpty() {
        first = null;
        last = null;
        length = 0;
    }

    public void enqueue(int value){
        Node newNode = new Node(value);
        if(this.length==0){
            this.first = newNode;
            this.last = newNode;
        }else {
            this.last.next = newNode;
            this.last = newNode;
        }
        this.length++;
    }

    public Node dequeue(){
        if(this.length==0) return null;
        Node temp = this.first;
        if(length==1){
            this.first = null;
            this.last = null;
        }else {
            this.first = this.first.next;
            temp.next = null;
        }
        this.length--;
        return temp;
    }



}
