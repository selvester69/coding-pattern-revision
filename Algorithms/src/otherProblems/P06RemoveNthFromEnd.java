package otherProblems;

public class P06RemoveNthFromEnd {
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

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return head;
		ListNode fast = head;
		for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
		if(fast==null) {
			head = head.next;
			return head;
		}
		ListNode slow = head;
		
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return head;
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
		print(removeNthFromEnd(head, 2));
	}

	public static void print(ListNode temp) {
		while (temp != null) {
			System.out.print(temp.val + "->");
			temp = temp.next;
		}
		System.out.println("null");
	}

}
