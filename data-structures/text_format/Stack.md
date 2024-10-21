
class Stack{
    class Node{
        int value;
        Node next;

        Node(int value){
            this.value = value;
            this.next  null;
        }
    }

    Node top;
    int height;

    Stack(int value){
        Node newNode = new Node(value);
        this.top = newNode;
        this.height = 1;
    }

    public Node getTop() {
        return top;
    }

    public int getHeight() {
        return height;
    }

    public void printStack() {
        Node temp = this.top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
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

    public void makeEmpty() {
        top = null;
        height = 0;
    }

    public void push(int value){
        Node newNode = new Node(value);
        if(this.height==0){
            this.top = newNode;
        }else {
        newNode.next = this.top;
        this.top = newNode;
        }
        this.height++;
    }

    public Node pop(){
        if(this.height==0){
            return null;
        }
        Node temp = this.top;
        this.top = this.top.next;
        temp.next = null;
        this.height--;
        return temp;
    }


}