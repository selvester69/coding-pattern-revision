package datastructure.sll;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList list = new LinkedList(2);
        list.append(3);
        list.append(4);
        list.append(5);
        System.out.println("list should be 2 -> 3 -> 4 -> 5");
        list.print();
        list.prepend(1);
        list.prepend(0);
        System.out.println("list should be 0 -> 1 -> 2 -> 3 -> 4 -> 5");
        list.print();
        list.append(6);
        list.append(7);
        System.out.println("list should be 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7");
        list.print();
        list.removeLast();
        list.removeLast();
        System.out.println("list should be 0 -> 1 -> 2 -> 3 -> 4 -> 5");
        list.print();
        list.removeFirst();
        list.removeFirst();
        System.out.println("list should be 2 -> 3 -> 4 -> 5");
        list.print();
    }
}
