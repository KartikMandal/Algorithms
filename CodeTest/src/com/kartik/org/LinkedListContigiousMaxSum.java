package com.kartik.org;



public class LinkedListContigiousMaxSum {
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
	  
	// Function to return the maximum contiguous 
	// nodes sum in the given linked list 
	static int maxContiguousNodeSum(Node head) 
	{ 
	  
	    // If the list is empty 
	    if (head == null) 
	        return 0; 
	  
	    // If the list contains a single element 
	    if (head.next == null) 
	        return head.value; 
	  
	    // max_ending_here will store the maximum sum 
	    // ending at the current node, currently it 
	    // will be initialised to the maximum sum ending 
	    // at the first node which is the first node's value 
	    int max_ending_here = head.value; 
	  
	    // max_so_far will store the maximum sum of 
	    // contiguous nodes so far which is the required 
	    // answer at the end of the linked list traversal 
	    int max_so_far = head.value;
	  
	    // Starting from the second node 
	    head = head.next; 
	  
	    // While there are nodes in linked list 
	    while (head != null) { 
	  
	        // max_ending_here will be the maximum of either 
	        // the current node's value or the current node's 
	        // value added with the max_ending_here 
	        // for the previous node 
	        max_ending_here = Math.max(head.value, 
	                              max_ending_here + head.value); 
	  
	        // Update the maximum sum so far 
	        max_so_far = Math.max(max_ending_here, max_so_far); 
	  
	        // Get to the next node 
	        head = head.next; 
	    } 
	  
	    // Return the maximum sum so far 
	    return max_so_far; 
	}
	
	
	
public static void main(String args[]){
	LinkedListContigiousMaxSum list=new LinkedListContigiousMaxSum();
	// Creating a linked list
			Node head=new Node(1);
			list.addToTheLast(head);
			list.addToTheLast(new Node(2));
			//list.addToTheLast(new Node(1));
			list.addToTheLast(new Node(1));
			list.addToTheLast(new Node(-2));
			list.addToTheLast(new Node(3));
	 
			list.printList();
	 
			System.out.println("Linked list palidrome: "+maxContiguousNodeSum(head));
}
}
