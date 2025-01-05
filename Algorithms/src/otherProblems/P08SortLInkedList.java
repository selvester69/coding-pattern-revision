package otherProblems;

public class P08SortLInkedList {
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

	private static ListNode findMiddle(ListNode head) {
		if (head == null)
			return head;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			if (fast != null) {
				slow = slow.next;
            }
		}
		ListNode temp = slow.next;
		slow.next = null;
		return temp;
	}

	public static ListNode sortList(ListNode head) {
		if(head==null || head.next==null) return head;
		// merge Sort
		ListNode middle = findMiddle(head);
		middle = sortList(middle);
		head = sortList(head);
		
		return mergeSort(head, middle);
	}

	private static ListNode mergeSort(ListNode leftSort, ListNode rightSort) {
		if (leftSort == null && rightSort == null)
			return null;
		ListNode res = new ListNode(0), temp = res;

		while (leftSort != null && rightSort != null) {
			if (leftSort.val < rightSort.val) {
				temp.next = leftSort;
				leftSort = leftSort.next;
			} else {
				temp.next = rightSort;
				rightSort = rightSort.next;
			}
			temp = temp.next;
		}
		if (leftSort == null)
			temp.next = rightSort;
		if (rightSort == null)
			temp.next = leftSort;

		return res.next;
	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(5);
		ListNode head = n1;
		n1.next = new ListNode(3);
		n1 = n1.next;
		n1.next = new ListNode(2);
		n1 = n1.next;
		n1.next = new ListNode(1);
		n1 = n1.next;
		n1.next = new ListNode(4);
		n1 = n1.next;
		print(head);
		System.out.println();
		print(sortList(head));
	}

	public static void print(ListNode temp) {
		while (temp != null) {
			System.out.print(temp.val + "->");
			temp = temp.next;
		}
		System.out.println("null");
	}
}
