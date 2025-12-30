package ds;


public class LinkedListRotate {
	
	public static Node rotateRight(Node head, int k) {
		if (head == null || head.next == null || k == 0)
			return head;

		Node tail = head;
		int length = 1;

		while (tail.next != null) {
			tail = tail.next;
			length++;
		}

		tail.next = head;

		k = k % length;
		int stepsToNewHead = length - k;

		Node newTail = tail;
		while (stepsToNewHead-- > 0) {
			newTail = newTail.next;
		}

		Node newHead = newTail.next;
		newTail.next = null;

		return newHead;
	}

	public static void print(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		System.out.println("Original:");
		print(head);

		/*
		 * System.out.println("Rotate Right by 1:"); print(rotateRight(head, 1));
		 */

		System.out.println("Rotate Right by 2:");
		print(rotateRight(head, 2));

		/*
		 * System.out.println("Rotate Right by 3:"); print(rotateRight(head, 3));
		 */
	}
}
