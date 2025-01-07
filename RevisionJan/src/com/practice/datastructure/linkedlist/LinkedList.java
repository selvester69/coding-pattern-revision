package com.practice.datastructure.linkedlist;

public class LinkedList {

    Node head;
    Node tail;
    int length;

    public LinkedList(int val) {
        Node newNode = new Node(val);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public void printList() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.value + "->");
        }
        System.out.println("null");
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public int getLength() {
        return this.length;
    }

    public void printAll() {
        if (this.length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length: " + length);
        System.out.println("\n Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void append(int val) {
        Node newNode = new Node(val);
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.length++;
    }

    public Node removeLast() {
        if (length == 0)
            return null;
        Node temp = head;
        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            Node prev = head;
            while (temp.next != null) {
                prev = temp;
                temp = temp.next;
            }
            this.tail = prev;
            prev.next = null;
        }
        this.length--;
        return temp;
    }

    public void prepend(int val) {
        Node newNode = new Node(val);
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
    }

    public Node removeHead() {
        if (length == 0)
            return null;
        Node temp = this.head;
        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            temp.next = null;
        }
        this.length--;
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index > length)
            return null;
        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // use get to set the value
    public boolean set(int index, int value) {
        Node node = get(index);
        if (node != null) {
            node.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        }
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == this.length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        this.length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length)
            return null;
        if (index == 0)
            return removeHead();
        if (index == this.length-1)
            return removeLast();

        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        this.length--;
        return temp;
    }


    public void reverse(){
        if(this.head==null) return;
        if(this.length==1) return;
        Node temp = this.head;
        Node prev = null;
        while(temp!=null){
            Node next = temp.next;
            
        }
    }

}
