package com.kartik.org;
/**
 * 
 * 
 *Swap nodes in a linked list without swapping data
Given a linked list and two keys in it, swap nodes for two given keys. Nodes should be swapped by changing links. Swapping data of nodes may be expensive in many situations when data contains many fields.
It may be assumed that all keys in linked list are distinct.

Examples:

Input:  10->15->12->13->20->14,  x = 12, y = 20
Output: 10->15->20->13->12->14

Input:  10->15->12->13->20->14,  x = 10, y = 20
Output: 20->15->12->13->10->14

Input:  10->15->12->13->20->14,  x = 12, y = 13
Output: 10->15->13->12->20->14
 * @author kmandal
 *
 */

public class LinkedListSwapNodes {

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
 
 
	public void printList(Node printNode) {
		while (printNode != null) {
			System.out.format("%d ", printNode.value);
			printNode = printNode.next;
		}
		System.out.println();
	}
 
	/* Function to swap Nodes x and y in linked list by 
    changing links */
 public static void swapNodes(int x, int y) 
 { 
     // Nothing to do if x and y are same 
     if (x == y) return; 

     // Search for x (keep track of prevX and CurrX) 
     Node prevX = null, currX = head; 
     while (currX != null && currX.value != x) 
     { 
         prevX = currX; 
         currX = currX.next; 
     } 

     // Search for y (keep track of prevY and currY) 
     Node prevY = null, currY = head; 
     while (currY != null && currY.value != y) 
     { 
         prevY = currY; 
         currY = currY.next; 
     } 

     // If either x or y is not present, nothing to do 
     if (currX == null || currY == null) 
         return; 

     // If x is not head of linked list 
     if (prevX != null) 
         prevX.next = currY; 
     else //make y the new head 
         head = currY; 

     // If y is not head of linked list 
     if (prevY != null) 
         prevY.next = currX; 
     else // make x the new head 
         head = currX; 

     // Swap next pointers 
     Node temp = currX.next; 
     currX.next = currY.next; 
     currY.next = temp; 
 } 
 
 
 static Node swapNodes(Node head_ref, int x, int y)  
 {  
     Node head=head_ref; 
     // Nothing to do if x and y are same  
     if (x == y)  
         return null;  
   
     Node a = null, b = null;  
   
     // search for x and y in the linked list  
     // and store therir pointer in a and b  
     while (head_ref.next!=null) {  
   
         if ((head_ref.next).value == x) {  
             a = head_ref;  
         }  
   
         else if ((head_ref.next).value == y) {  
             b = head_ref;  
         }  
   
         head_ref = ((head_ref).next);  
     }  
   
     // if we have found both a and b  
     // in the linked list swap current  
     // pointer and next pointer of these  
     if (a!=null&&  b!=null) {  
     Node temp = a.next;  
     a.next = b.next;  
     b.next = temp;      
     temp = a.next.next;  
     a.next.next = b.next.next;  
     b.next.next = temp;  
     }  
     return head; 
 }  
	public static void main(String[] args) {
		LinkedListSwapNodes list = new LinkedListSwapNodes();
		// Creating a linked list
		Node head1=new Node(5);
		list.addToTheLast(head1);
		list.addToTheLast(new Node(6));
		list.addToTheLast(new Node(7));
		list.addToTheLast(new Node(1));
		list.addToTheLast(new Node(2));
		System.out.print("Number 1:  ");
		list.printList(head1);
		// swap
		swapNodes(6,7);
		System.out.print("after swap:  ");
		list.printList(head);
	}
}
