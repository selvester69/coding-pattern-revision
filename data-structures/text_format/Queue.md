
public class Queue{
    class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
            this.next = null;
        }
    }

    Node first;
    Node last;
    int length;

    Queue(int value){
        Node newNode = new Node(value);
        this.first = newNode;
        this.last = newNode;
        this.length=1;
    }
    public Node getFirst() {
        return this.first;
    }

    public Node getLast() {
        return this.last;
    }

    public int getLength() {
        return this.length;
    }

    public void printList() {
        Node temp = this.first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    public void printAll() {
        if (this.length == 0) {
            System.out.println("First: null");
            System.out.println("Last: null");
        } else {
            System.out.println("First: " + this.first.value);
            System.out.println("Last: " + this.last.value);
        }
        System.out.println("Length:" + this.length);
        System.out.println("\nQueue:");
        if (this.length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
    
    public void makeEmpty() {
        this.first = null;
        this.last = null;
        this.length = 0;
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
        if(this.length==0){
            return null;
        }
        Node temp = this.first;
        if(this.length==1){
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