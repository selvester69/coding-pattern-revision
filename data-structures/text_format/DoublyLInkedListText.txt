public class DoublyLinkedList{
    class Node{
        int value;
        Node next;
        Node prev;

        Node(int value){
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;
    int length;
    Node tail;

    DoublyLinkedList(int value){
        Node newNode = new Node(value);
        this.head = newNode;
        this.tail = newNode;
        this.length = 1;
    }

    public Node getHead(){
        return this.head;
    }
    public Node getTail(){
        return this.tail;
    }
    public int getLength(){
        return this.length;
    }
    public void printList(){
        Node temp = this.head;
        while(temp!=null){
            System.out.print(temp.value+" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void printAll(){
        if (this.length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + this.head.value);
            System.out.println("Tail: " + this.tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        }else {
          printList();  
        }
    }

    // appends a new node to the end of the doubly linked list.
    public void append(int value){
        Node newNode = new Node(value);
        if(this.head==null){
            this.head = newNode;
            this.tail = newNode;
        }else{
            this.tail.next = newNode;
            newNode.prev= this.tail;
            this.tail = newNode;
        }

        this.length++;
    }

    // adds a new node to the beginning of the doubly linked list.
    public Node removeLast(){
        if(this.head ==null){
            return null;
        }
        Node temp = this.tail;
        if(this.length==1){
            this.tail = null;
            this.head = null;
        }else {
            this.tail = this.tail.prev;
            this.tail.next = null;
            temp.prev = null;
        }
        this.length--;
        return temp;
    }

    // adds a new node to the beginning of the doubly linked list.
    public void prepend(int value) {
        Node newNode = new Node(value);
        if(this.head == null){
            this.head = newNode;
            this.tail = newNode;
        }else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.length++;
    }

    // removes the first node from the doubly linked list and returns it.
    public Node removeFirst(){
        if(this.length ==0){
            return null;
        }
        Node temp = this.head;
        if(this.length ==1){
            this.head = null;
            this.tail = null;
        }else {
            this.head = this.head.next;
            this.head.prev = null;
            temp.next = null;
        }
        this.length--;
        return temp;
    }

     // retrieves a node at a given index from the doubly linked list.
    public Node get(int index){
        if(index < 0 || index > this.length){
            return null;
        }
        Node temp = null;
        if(index<this.length/2){
            temp = this.head;
            while(index>0){   //for(int i=0;i<index;i++){  //iterate from forward
                temp = temp.next;
                index--;
            }
        }else {
            //iterate from backward  //for(int i=length-1;i>index;i--){
            temp = this.tail;
            while((this.length-index-1)>0){
                temp = temp.prev;
                index++;
            }
        }
        return temp;   
    }
     
    // inserts a new node with a given value at a specified index in the doubly linked list.
    public boolean insert(int index, int value){
        if(index<0||index>this.length){
            return false;
        }
        if(index==0){
            prepend(value);
            this.length++;
            return true;
        }else if(index==this.length){
            append(value);
            this.length++;
            return true;
        }else {
        Node newNode = new Node(value);
        Node temp = get(index-1);
        newNode.next = temp.next;
        temp.next = newNode;
        newNode.next.prev = newNode;
        newNode.prev = temp;
        this.length++;
        return true;
        }
    }

    // removes a node at a specified index from the doubly linked list
     public Node remove(int index){
        if(index<0||index>=length){
            return null;
        }
        if(index==0){
            return removeFirst();
        }else if(index==this.length-1){
            return removeLast();
        }else {
            Node before = get(index-1);
            Node temp = before.next;
            before.next = temp.next;
            temp.next.prev = before;
            temp.prev = null;
            temp.next = null;
            this.length--;
            return temp;
        }
    }

}