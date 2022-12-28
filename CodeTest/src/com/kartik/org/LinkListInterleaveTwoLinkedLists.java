package com.kartik.org;


/**
 * Let’s consider two linked lists, L1 having the members A->B->C->D and 
 * L2 having the members X->Y->Z. Interleaving the two linked lists will
 *  result in the single linked list A->X->B->Y->C->Z->D, wherein the 
 *  first node of L2 is placed next to the first node of L1, second node of 
 *  L2 is placed next to second node of L1 and so on. If the sizes of the 
 *  two linked lists are m and n, then interleaving can be done in O(m+n)
 *  
 *   @link http://www.interviewdruid.com/category/linked-lists/
 *   
 * @author kmandal
 *
 */
public class LinkListInterleaveTwoLinkedLists {
	static Node headOne;
	static Node headTwo;
	static Node interLeave;
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
	
	
	static Node interleaveLists(Node n1, Node n2) {

		if (n1 == null) {
			return n2; /* If linked list1 is empty, return n2 */
		}

		if (n2 == null) {
			return n1; /* If linked list2 is empty, return n1 */
		}

		/* Process the two linked lists */
		Node result = n1;
		while (n1 != null && n2 != null) {
			Node temp1 = n1.next;
			Node temp2 = n2.next;

			/*
			 * Place node of second linked list next to the node of the first
			 * linked list
			 */
			if (n1.next != null)
				n2.next = n1.next;
			n1.next = n2;

			n1 = temp1;
			n2 = temp2;
		}
		return result;
	}
	
	
	// For printing Linked List
		public static void printLinkedList(Node head) {
			System.out.println("Printing LinkedList (head --> last) ");
			Node current = head;
			while (current != null) {
				System.out.println(current.data + "");
				current = current.next;
			}
			System.out.println();
		}

		public static Node push(int data,Node head) {
			Node newNode = new Node();
			newNode.data = data;
			newNode.next = head;
			return newNode;
		}

		public static void main(String[] args) {
			for (int i = 60; i >= 10; i = i - 10)
				headOne =push(i,headOne);
			//Node n = headOne;
			System.out.println("Generated Linked List: ");
			printLinkedList(headOne);
			
			for (int i = 150; i >= 130; i = i - 10)
				headTwo =push(i,headTwo);
			//Node n = headOne;
			System.out.println("Generated Linked List: ");
			printLinkedList(headTwo);
			
			interLeave=interleaveLists(headOne, headTwo);
			//Node n = headOne;
			System.out.println("Generated Linked List: ");
			printLinkedList(interLeave);
		}

}
