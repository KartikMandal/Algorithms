package com.kartik.org;



/**
 *Rotate Linked List block wise
Given a Linked List of length n and block length k rotate in circular manner towards right/left each block by a number d. 
If d is positive rotate towards right else rotate towards left.

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

@author kmandal
 */

public class LinkListRotatedByBlockWise {

	static Node main;
	static Node mainRoat;

	private static class Node {
		private int data;
		private Node next;
		Node(int data) {
			this.data = data;

		}
	}

	public void addToTheLast(Node node) {

		if (main == null) {
			main = node;
		} else {
			Node temp = main;
			while (temp.next != null)
				temp = temp.next;

			temp.next = node;
		}
	}


	public void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.data);
			temp = temp.next;
		}
		System.out.println();
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
	// Recursive function to rotate one block 
	static Node rotateHelper(Node  blockHead, 
	                          Node  blockTail, 
	                          int d, Node tail, 
	                          int k) 
	{ 
	    if (d == 0) 
	        return blockHead; 
	  
	    // Rotate Clockwise 
	    if (d > 0) { 
	        Node  temp = blockHead; 
	        for (int i = 1; temp.next.next!=null && i < k - 1; i++) {
	            temp = temp.next; 
	        }
	        temp.next=null;
	        blockTail.next = blockHead; 
	        tail = temp; 
	        return rotateHelper(blockTail, temp, 
	                            d-1, tail.next, k); 
	    } 
	  
	    // Rotate anti-Clockwise 
	    if (d < 0) { 
	        blockTail.next = blockHead; 
	        tail = blockHead; 
	        return rotateHelper(blockHead.next, 
	                blockHead, d + 1, tail.next, k); 
	    }
		return tail; 
	} 
	  
	// Function to rotate the linked list block wise 
	static Node rotateByBlocks(Node  head, 
	                                 int k, int d) 
	{ 
	    // If length is 0 or 1 return head 
	    if (head==null || head.next==null) 
	        return head; 
	  
	    // if degree of rotation is 0, return head 
	    if (d == 0) 
	        return head; 
	  
	    Node  temp = head, tail = null; 
	  
	    // Traverse upto last element of this block 
	    int i; 
	    for (i = 1; temp.next!=null && i < k; i++) 
	        temp = temp.next; 
	  
	    // storing the first node of next block 
	    Node  nextBlock = null;
	    if(temp != null)
	     nextBlock = temp.next; 
	  
	    // If nodes of this block are less than k. 
	    // Rotate this block also 
	    if (i < k) 
	        head = rotateHelper(head, temp, d % k, tail, i); 
	    else
	        head = rotateHelper(head, temp, d % k,tail, k); 
	   
	    // Append the new head of next block to 
	    // the tail of this block 
	    	if(mainRoat==null){
	    		mainRoat=head;
	    	}else{
	    		int size=getSize(mainRoat);
	    		Node n=getPostion(mainRoat, size);
	    		n.next=head;
	    	}
	   
	    if(nextBlock!=null)
	    rotateByBlocks(nextBlock, k,d % k); 
	  
	    // return head of updated Linked List 
	    return mainRoat; 
	} 
		

	public static void main(String[] args) {
		LinkListRotatedByBlockWise list=new LinkListRotatedByBlockWise();
		// Creating a linked list
		Node head=new Node(1);
		list.addToTheLast(head);
		list.addToTheLast(new Node(2));
		list.addToTheLast(new Node(3));
		list.addToTheLast(new Node(4));
		list.addToTheLast(new Node(5));
		list.addToTheLast(new Node(6));
		list.addToTheLast(new Node(7));
		list.addToTheLast(new Node(8));
		//list.addToTheLast(new Node(9));
		list.printList(head);
		
		//Node d=rotateRight(head, 2);
		Node d=rotateByBlocks(head, 3, 2);
		list.printList(d);

	}

}
