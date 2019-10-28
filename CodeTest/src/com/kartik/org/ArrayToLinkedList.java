package com.kartik.org;

public class ArrayToLinkedList {
	// Representation of a node 
	static class Node  
	{ 
	    int data; 
	    Node next;
	    Node neighbor;
	}; 
	  
	// Function to insert node 
	static Node insert(Node root, int item) 
	{ 
	    Node temp = new Node(); 
	    Node ptr; 
	    temp.data = item; 
	    temp.next = null; 
	  
	    if (root == null) 
	        root = temp; 
	    else 
	    { 
	        ptr = root; 
	        while (ptr.next != null) 
	            ptr = ptr.next; 
	        ptr.next = temp; 
	    } 
	    return root; 
	} 
	
	
	
	
}
