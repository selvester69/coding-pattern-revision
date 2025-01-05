package otherProblems;

public class P07OddEvenList {
	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.val + " ";
		}
	}

	public static ListNode oddEvenList(ListNode head) {
		if(head==null) return head;
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode oddHead = odd,evenHead=even;
        ListNode temp = head;int index=1;
        while(temp!=null){
            if(index%2==0){
                even.next = temp;
                even = even.next;
            }else {
                odd.next = temp;
                odd = odd.next;
            }
            temp = temp.next;
            index++;
        }
        even.next = null;
        odd.next = evenHead.next;
        return oddHead.next;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode head = n1;
		n1.next = new ListNode(2);
		n1 = n1.next;
		n1.next = new ListNode(3);
		n1 = n1.next;
		n1.next = new ListNode(4);
		n1 = n1.next;
		n1.next = new ListNode(5);
		n1 = n1.next;
		print(head);
		System.out.println();
		print(oddEvenList(head));
	}

	public static void print(ListNode temp) {
		while (temp != null) {
			System.out.print(temp.val + "->");
			temp = temp.next;
		}
		System.out.println("null");
	}

}
