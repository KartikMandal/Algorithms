package com.kartik.org;

/**
 * Approach 2: Split the list and move it to the end.
 * Since n may be a large number compared to the length of list. So we need to know the length of linked list.
 * Let's  start with an example.
 *   Given [0,1,2], rotate 1 steps to the right -> [2,0,1].
 *   Given [0,1,2], rotate 2 steps to the right -> [1,2,0].
 *   Given [0,1,2], rotate 3 steps to the right -> [0,1,2].
 *   Given [0,1,2], rotate 4 steps to the right -> [2,0,1].
 * From above, we can find that:
 * no matter how big K, the result is always the same as rotating K % n steps to the right.
 *   Ex: {1,2,3} k=2, Move the list after the 1st node to the front
 *   Ex: {1,2,3} k=5, In this case Move the list after (3- 5%3 = 1)st node to the front.
 *
 * So the code has three parts.
 *   1. Get the length
 *   2. Move to the (len - k%len)th node
 *   3. Do the rotation
 */

public class LinkListNumberOfTimeRotate {

	static Node head;

	private static class Node {
		private int data;
		private Node next;

		Node(int data) {
			this.data = data;

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


	public void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.data);
			temp = temp.next;
		}
		System.out.println();
	}
		
	public static Node rotateRight(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        Node dummy = new Node(-1);
        dummy.next = head;
        Node fast = dummy, slow = dummy;
        int len;
        // Get the total length of the list
        for (len = 0; fast.next != null; len++) {
            fast = fast.next;
        }
        // Get the (len - k%len)th node
        for (int j = len - (k % len); j > 0; j--) {
            slow = slow.next;
        }

        // Rotate the list
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }
	
	public static void main(String[] args) {
		LinkListNumberOfTimeRotate list=new LinkListNumberOfTimeRotate();
		// Creating a linked list
		Node head=new Node(5);
		list.addToTheLast(head);
		list.addToTheLast(new Node(6));
		list.addToTheLast(new Node(7));
		list.addToTheLast(new Node(1));
		list.addToTheLast(new Node(2));

		list.printList(head);
		
		Node d=rotateRight(head, 2);
		list.printList(d);

	}

}
