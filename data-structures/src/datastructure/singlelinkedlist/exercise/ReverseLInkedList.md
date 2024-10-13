public class ReverseLL {

    static Node reverse(Node head, Node tail) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        head = tail;
        tail = temp;
        Node prev = null, next = null;
        while (temp != null) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(6);
        list.print();
        Node res = reverse(list.head,list.tail);
        for(int i=0;i<list.length;i++){
            System.out.print(res.value+" -> ");
            res = res.next;
        }
    }

}