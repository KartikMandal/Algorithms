package com.kartik.org;
/**
 * 
 * @author kmandal
 * 
 *<pre>
Original Linked List: 1 2 3 4 5 6 7 8

Modified List for k = 1
8 2 3 4 5 6 7 1

Modified List for k = 2
8 7 3 4 5 6 2 1

Modified List for k = 3
8 7 6 4 5 3 2 1

Modified List for k = 4
8 7 6 5 4 3 2 1

Modified List for k = 5
8 7 6 4 5 3 2 1

Modified List for k = 6
8 7 3 4 5 6 2 1

Modified List for k = 7
8 2 3 4 5 6 7 1

Modified List for k = 8
1 2 3 4 5 6 7 8
</pre>
 *
 */
public class LinkedListSwapNthElementFromLast {

	private static Node head;

	private static class Node {
		private int value;
		private Node next;

		Node(int value) {
			this.value = value;

		}
	}

	public void addToTheLast(Node node) {

		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;

			temp.next = node;
		}
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.value);
			temp = temp.next;
		}
		System.out.println();
	}

	
	static int getSize(Node node) {
		if (node == null) {
			return 0;
		}
		return getSize(node.next) + 1;

	}

	/*
	 * Function for swapping kth nodes from both ends of linked list
	 */
	static void swapKth(int k) {
		// Count nodes in linked list
		int n = getSize(head);

		// Check if k is valid
		if (n < k)
			return;

		// If x (kth node from start) and y(kth node from end)
		// are same
		if (2 * k - 1 == n)
			return;

		// Find the kth node from beginning of linked list.
		// We also find previous of kth node because we need
		// to update next pointer of the previous.
		Node x = head;
		Node x_prev = null;
		for (int i = 1; i < k; i++) {
			x_prev = x;
			x = x.next;
		}

		// Similarly, find the kth node from end and its
		// previous. kth node from end is (n-k+1)th node
		// from beginning
		Node y = head;
		Node y_prev = null;
		for (int i = 1; i < n - k + 1; i++) {
			y_prev = y;
			y = y.next;
		}

		// If x_prev exists, then new next of it will be y.
		// Consider the case when y->next is x, in this case,
		// x_prev and y are same. So the statement
		// "x_prev->next = y" creates a self loop. This self
		// loop will be broken when we change y->next.
		if (x_prev != null)
			x_prev.next = y;

		// Same thing applies to y_prev
		if (y_prev != null)
			y_prev.next = x;

		// Swap next pointers of x and y. These statements
		// also break self loop if x->next is y or y->next
		// is x
		Node temp = x.next;
		x.next = y.next;
		y.next = temp;

		// Change head pointers when k is 1 or n
		if (k == 1)
			head = y;

		if (k == n)
			head = x;
	}

	public static void main(String[] args) {
		LinkedListSwapNthElementFromLast list = new LinkedListSwapNthElementFromLast();
		// Creating a linked list
		Node head = new Node(5);
		list.addToTheLast(head);
		list.addToTheLast(new Node(6));
		list.addToTheLast(new Node(7));
		list.addToTheLast(new Node(1));
		list.addToTheLast(new Node(2));
		list.addToTheLast(new Node(8));

		list.printList();
		// Finding 3rd node from end
		for (int i = 1; i < 4; i++) {
			swapKth(i);
			System.out.println("Modified List for k = " + i);
			list.printList();
			System.out.println("");
		}
	}

}
