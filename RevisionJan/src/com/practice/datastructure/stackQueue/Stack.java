package com.practice.datastructure.stackQueue;

public class Stack {
    Node top;
    int height;

    public Stack(int value) {
        Node newNode = new Node(value);
        this.top = newNode;
        this.height = 1;
    }

    public Node getTop() {
        return this.top;
    }

    public int getHeight() {
        return this.height;
    }

    public void printStack() {
        Node temp = this.top;
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
    }
    public void makeEmpty() {
        top = null;
        height = 0;
    }
    public void printAll() {
        if (height == 0) {
            System.out.println("Top: null");
        } else {
            System.out.println("Top: " + top.value);
        }
        System.out.println("Height:" + height);
        System.out.println("\nStack:");
        if (height == 0) {
            System.out.println("empty");
        } else {
            printStack();
        }
    }

    public void push(int value){
        Node newNode = new Node(value);
        if(height==0){
            this.top = newNode;
        }else {
            newNode.next = this.top;
            this.top = newNode;
        }
        this.height++;
    }

    public Node pop(){
        if(this.top==null) return this.top;
        Node temp = this.top;
        this.top = this.top.next;
        temp.next = null;
        this.height--;
        return temp;
    }

}
