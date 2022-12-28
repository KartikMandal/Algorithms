package com.kartik.org;
/**
 * Consider the linked list A->B->C->D->E. If we rotate the linked list by k = 2 positions, 
 * then the linked list will become D->E->A->B->C. To perform the rotation we do the following:

1. Locate the kth node from the end (let’s call this node the pivot). If k = 2, 
we have to locate the second last node which in this case is D.

2. Make the node previous to the pivot point to NULL. So in this case C will point to NULL.

3. Traverse till the end of the linked list and make the last node point to the
 head of the linked list. So the last node E will point to the head A.

4. Make the pivot the head of the new linked list. So D will now become the new head.

Note that if k = length of linked list, then after rotation we end up with the original linked list.
 So we apply the formula, k = k % length to figure out the actual rotation required.
 
 
 @link http://www.interviewdruid.com/category/linked-lists/
 * @author kmandal
 *
 */
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
		/*int count = 0;
		while (node.next != null) {
			node = node.next;
			count++;
		}
		return count;*/
		if(node == null){
			return 0;
		}
		return node.next != null?getSize(node.next)+1:1;

	}

	public static void rotateAnPlace(Node node, int k) {
		if (k < 2)
			return;
		Node currentHead = getPostion(node, k); // now this is the selected head
		Node tail = getPostion(node, k - 1);// one minus of selected postion
		Node oldtail = getPostion(node, getSize(node)); // this is old tail
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
		System.out.println("Linked list after rotation: 4");
		rotateAnPlace(n, 4);
		printLinkedList();
		System.out.println("Linked list after rotation: 3");
		n = head;
		rotateAnPlace(n, 3);
		printLinkedList();
	}
}
