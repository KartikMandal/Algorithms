package com.kartik.org;

public class LinkListReverse {
private Node head;

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


public void printList(Node head) {
	Node temp = head;
	while (temp != null) {
		System.out.format("%d ", temp.value);
		temp = temp.next;
	}
	System.out.println();
}

public static Node reverseLinkedList(Node node) {
	if (node == null || node.next == null) {
		return node;
	}

	Node remaining = reverseLinkedList(node.next);
	node.next.next = node;
	node.next = null;
	return remaining;
}

public static void main(String[] args) {
	LinkListReverse list = new LinkListReverse();
	// Creating a linked list
	Node head=new Node(5);
	list.addToTheLast(head);
	list.addToTheLast(new Node(6));
	list.addToTheLast(new Node(7));
	list.addToTheLast(new Node(1));
	list.addToTheLast(new Node(2));

	list.printList(head);
	//Reversing LinkedList
	Node reverseHead=reverseLinkedList(head);
	System.out.println("After reversing");
	list.printList(reverseHead);

}
// Linklist Palindome --> https://java2blog.com/how-to-check-if-linked-list-is/
// Add two number  -->https://java2blog.com/add-two-numbers-represented-by-linked-list-in-java/
//https://www.amrita.ac.in/swaminathanj/Algorithms/15_LPS.html
}