package com.kartik.org;

//https://www.journaldev.com/24/memcached-java-client-example
//https://www.javaworld.com/article/2078565/open-source-tools/open-source-tools-use-memcached-for-java-enterprise-performance-part-1-architecture-and-setup.html
//https://hackernoon.com/top-10-system-design-interview-questions-for-software-engineers-8561290f0444
//https://github.com/shashank88/system_design
//https://www.hiredintech.com/system-design/the-system-design-process/
//https://github.com/checkcheckzz/system-design-interview
//http://ksat.me/a-plain-english-introduction-to-cap-theorem/
//https://www.educative.io/collection/page/5668639101419520/5649050225344512/5668600916475904
//https://www.interviewbit.com/problems/design-url-shortener/
//https://www.geeksforgeeks.org/rotate-linked-list-block-wise/
//https://www.geeksforgeeks.org/rotate-linked-list-block-wise/
//http://massivealgorithms.blogspot.com/2014/06/rotate-array-right-by-k-element-without.html
//https://www.youtube.com/watch?v=utE_1ppU5DY



/**
 * Rotate Linked List block wise
Given a Linked List of length n and block length k rotate in circular manner towards right/left each block by a number d. If d is positive rotate towards right else rotate towards left.

Examples:

Input: 1->2->3->4->5->6->7->8->9->NULL, 
        k = 3 
        d = 1
Output: 3->1->2->6->4->5->9->7->8->NULL
Explanation: Here blocks of size 3 are
rotated towards right(as d is positive) 
by 1.
 
Input: 1->2->3->4->5->6->7->8->9->10->
               11->12->13->14->15->NULL, 
        k = 4 
        d = -1
Output: 2->3->4->1->6->7->8->5->10->11
             ->12->9->14->15->13->NULL
Explanation: Here, at the end of linked 
list, remaining nodes are less than k, i.e.
only three nodes are left while k is 4. 
Rotate those 3 nodes also by d.
 
 @link http://www.interviewdruid.com/category/linked-lists/
 * @author kmandal
 *
 */
public class LinkListRotatedClockWiseFromKthPostion {
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
		if(node == null){
			return 0;
		}
		return getSize(node.next)+1;

	}

	public static void rotateAnPlace(Node node, int k) {
		if (k < 2)
			return;
		Node currentHead = getPostion(node, k); // now this is the selected head
		Node tail = getPostion(node, k - 1);// one minus of selected postion
		Node oldtail = getPostion(node, getSize(node) ); // this is old tail
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
