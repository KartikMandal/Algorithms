package com.kartik.org;



public class LinkListReverseSubLinkList {
	
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
			
			
	static Node reverse(Node node, int k)
	{
	    Node curr = node;
	    //Initialize next and previous as null
	    Node next = null;
	    Node previous = null;
	    int count = 0;   
	    //reverse first k nodes
	    while (curr != null && count < k)
	    {
	        next  = curr.next;
	        curr.next = previous;
	        previous = curr;
	        curr = next;
	        count = count + 1;
	    }
	    if (next !=  null)
	    {
	       node.next = reverse(next, k); 
	    }
	    //previous will be new head of the linked list
	    return previous;
	}
	
	
	public static void main (String[] args) {
		for ( int i = 130 ; i >= 10 ; i=i-10)
			push(i);
			//Node n= head;
		System.out.println("Generated Linked List: ");
		printLinkedList();
		System.out.println("Linked list after rotation: ");
		Node n = head;
		head=reverse(n, 4);
		System.out.println("Generated Linked List: ");
		printLinkedList();
	}
	
	

}
