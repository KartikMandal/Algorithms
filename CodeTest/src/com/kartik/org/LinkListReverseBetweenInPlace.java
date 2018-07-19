package com.kartik.org;


public class LinkListReverseBetweenInPlace {

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

		public static void push(int data) {
			Node newNode = new Node();
			newNode.data = data;
			newNode.next = head;
			head = newNode;
		}

		public static void printLinkedList() {
			System.out.println("Printing LinkedList (head --> last) ");
			Node current = head;
			while (current != null) {
				System.out.println(current.data + "");
				current = current.next;
			}
			System.out.println();
		}
				
				
		static Node reverseBetween(Node head, int m, int n) {
	        Node newHead = new Node(-1);
	        newHead.next = head;
	        Node prev = newHead;
	        for(int i = 0 ; i < m-1 ; i++){
	            prev = prev.next;
	        }
	        Node reversedPrev = prev;
	        //position m
	        prev = prev.next;
	        Node cur = prev.next;
	        for(int i = m ; i < n ; i++){
	            prev.next = cur.next;
	            cur.next = reversedPrev.next;
	            reversedPrev.next = cur;
	            cur = prev.next;
	        }
	        return newHead.next;
	    }
		
		
		public static void main (String[] args) {
			for ( int i = 130 ; i >= 10 ; i=i-10)
				push(i);
				//Node n= head;
			System.out.println("Generated Linked List: ");
			printLinkedList();
			System.out.println("Linked list after rotation: ");
			Node n = head;
			head=reverseBetween(n, 2,10);
			System.out.println("Generated Linked List: ");
			printLinkedList();
		}

}
