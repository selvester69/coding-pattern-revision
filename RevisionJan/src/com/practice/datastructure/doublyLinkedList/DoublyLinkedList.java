package com.practice.datastructure.doublyLinkedList;

public class DoublyLinkedList {
    protected Node head;
    protected Node tail;
    protected int length;

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
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

    public void printList() {
        Node temp = this.head;
        for (int i = 0; i < this.length; i++) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length: " + length);
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.length++;
    }

    public Node removeLast() {
        if (this.length == 0)
            return null;
        Node temp = this.tail;
        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
            temp.prev = null;
        }
        this.length--;
        return temp;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.length++;
    }

    public Node removeFirst() {
        if (this.head == null)
            return this.head;
        Node temp = this.head;
        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            temp.next = null;
            this.head.prev = null;
        }
        this.length--;
        return temp;
    }

    // in case of doubly linked list iterate from end if index>length/2 to reduce
    // the time complexity
    public Node get(int index) {
        if (index < 0 || index >= this.length)
            return null;
        Node temp = null;
        if (index < length / 2) {
            temp = this.head;
            while (index > 0) {
                temp = temp.next;
                index--;
            }
        } else {
            temp = this.tail;
            while (length - index - 1 > 0) {
                temp = temp.prev;
                index++;
            }
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > this.length)
            return false;
        if (index == 0) {
            prepend(value);
            return true;
        } else if (index == this.length) {
            append(value);
            return true;
        } else {
            Node newNode = new Node(value);
            Node prev = get(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
            newNode.next.prev = newNode;
            newNode.prev = prev;
            this.length++;
            return true;
        }
    }

    public Node remove(int index) {
        if (index < 0 || index >= this.length)
            return null;
        if (index == 0) {
            return removeFirst();
        } else if (index == length - 1) {
            return removeLast();
        } else {
            Node prev = get(index - 1);
            Node temp = prev.next;
            prev.next = temp.next;
            prev.next.prev = prev;
            temp.prev = null;
            temp.next = null;
            this.length--;
            return temp;
        }
    }

    

}
