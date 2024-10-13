package datastructure.singlelinkedlist;

public class LinkedList {

    public Node head;
    public Node tail;
    public int length;

    public class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public void print() {
        if (this.length == 0 || this.head == null) {
            System.out.println("list is empty");
        } else {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.length = this.length + 1;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
    }

    public Node removeLast() {
        if (this.length == 0) {
            return null;
        }
        Node temp = this.head, prev = null;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        this.tail = prev;
        this.tail.next = null;
        this.length--;
        return temp;
    }

    public Node removeFirst() {
        if (this.length == 0) {
            return null;
        }
        Node temp = this.head;
        this.head = temp.next;
        temp.next = null;
        this.length--;
        return temp;
    }

    public Node get(int index) {
        // check if index is in range
        if (index < 0 || index > this.length) {
            return null;
        }
        // using for loop
        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        // using while loop
        Node temp1 = this.head;
        while (index > 0) {
            temp1 = temp1.next;
            index--;
        }
        System.out.println(temp.value == temp1.value);

        return temp;
    }

    public void set(int value, int index) {
        Node temp = this.get(index);
        if (temp == null) {
            return;
        }
        temp.value = value;
    }

    public boolean insert(int value, int index) {
        if (index < 0 || index > this.length) {
            return false;
        }
        // edge cases
        // if index==0 // add to front and return true
        if (index == 0) {
            this.prepend(value);
            return true;
        }
        // if index==length //add to back and return
        else if (index == this.length) {
            this.append(value);
            return true;
        } else {
            Node prev = this.get(index - 1);
            Node newNode = new Node(value);
            newNode.next = prev.next;
            prev.next = newNode;
            this.length++;
            return true;
        }
    }

    public Node remove(int index) {
        if (index < 0 || index > length) {
            return null;
        }
        if (index == 0) {
            return this.removeFirst();
        } else if (index == length - 1) { // last index is length-1
            return this.removeLast();
        } else {
            Node prev = this.get(index);
            Node temp = prev.next;
            prev.next = temp.next;
            temp.next = null;
            this.length--;
            return temp;
        }
    }
    public void reverse() {
        if (head == null) {
            System.out.println("list is empty ");
            return;
        }
        Node temp = head;
        head = tail;
        tail = temp;
        // reverse
        Node next = null, prev = null;
        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
    }

}
