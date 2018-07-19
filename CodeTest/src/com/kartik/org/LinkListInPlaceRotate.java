package com.kartik.org;

public class LinkListInPlaceRotate {

	static Node head;

	static class Node {
		int data;
		Node next;

		Node() {
		};

		Node(int d) {
			data = d;
			next = null;
		}
	}

	static Node getPostion(Node node, int k) {
		Node current = node;
		while (k > 1) {
			current = current.next;
			k--;
		}
		return current;
	}

	static int getSize(Node node) {
		int count = 0;
		while (node.next != null) {
			node = node.next;
			count++;
		}
		return count;

	}

	public static void rotateAnPlace(Node node, int k) {
		if (k < 2)
			return;
		Node currentHead = getPostion(node, k); // now this is the selected head
		Node tail = getPostion(node, k - 1);// one minus of selected postion
		Node oldtail = getPostion(node, getSize(node) + 1); // this is old tail
															// connect to
															// previous head
		oldtail.next = head;
		tail.next = null;
		head = currentHead;
	}

	// For printing Linked List
	public static void printLinkedList() {
		System.out.println("Printing LinkedList (head --> last) ");
		Node current = head;
		while (current != null) {
			System.out.println(current.data + "");
			current = current.next;
		}
		System.out.println();
	}

	public static void push(int data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = head;
		head = newNode;
	}

	public static void main(String[] args) {
		for (int i = 60; i >= 10; i = i - 10)
			push(i);
		Node n = head;
		System.out.println("Generated Linked List: ");
		printLinkedList();
		System.out.println("Linked list after rotation: ");
		rotateAnPlace(n, 4);
		printLinkedList();
		System.out.println("Linked list after rotation: ");
		n = head;
		rotateAnPlace(n, 2);
		printLinkedList();
	}
}
