package com.kartik.org;

import java.util.Arrays;

/**
 * 
 * Given a linked list where the nodes can have the values 0 or 1 or 2, sort it in a single pass. For instance 2->1->0->0->2->0>1 should be sorted as 0->0->0->1->1->2->2

To sort the linked list in a single pass, we make use of the fact that there are only 3 possible values for the nodes in the linked list. So as we traverse the linked list, we can remove the nodes from the original linked list and append them into 3 separate linked lists based on the value of the nodes. At the end we can merge the 3 linked lists. The procedure we can use to solve the problem is as follows

1. Maintain the head and tail pointers for linked list-0 (will contain nodes with value 0), linked list-1 (will contain nodes with value 1) and linked list-2 (will contain nodes with value 2)

2. As we traverse through the original linked list, remove each node from the original linked list and add it to linked list-0 or linked list-1 or linked list-2 based on the value of the node.

3. At the end connect the tail of linked list-0 to the head of linked list-1 and the tail of linked list-1 to the head of linked list-2
 * 
 * 
 * @author kmandal
 *
 */
public class LinkedListSortSinglePass {

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


	public void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.data);
			temp = temp.next;
		}
		System.out.println();
	}

	
	/*
	head: array of heads of the separated lists
	tail: array of tails of the separated lists
	curNode: current node being processed
	i: data value of the node
	*/
	public static void addNode(Node[] head, Node[] tail, 
			Node curNode, int data) {
	    curNode.next = head[data];
	    head[data] = curNode;
	    if (tail[data] == null)
	        tail[data] = curNode;
	 
	}
	 
	/*firstNode: first node in the list to be sorted 
	numDistinctValues: number of distinct values 
	Return value: head of the sorted list
	*/
	public static Node sortList(Node firstNode, 
	                int numDistinctValues) {
		Node[] head = new Node[numDistinctValues]; 
		Node[] tail = new Node[numDistinctValues];
		Node result = null;
	 
	    if (firstNode == null)
	        return null;
	 
	    int i;
	    for (i = 0; i < numDistinctValues; ++i) {
	        head[i] = null;
	        tail[i] = null;
	    }
	 
	    /*Partition the list into separate lists (0-list, 1-list and 2-list)
	    based on the data in the node*/
	    Node curNode = firstNode;
	    while (curNode != null) {
	    	Node nextNode = curNode.next;
	        addNode(head, tail, curNode, curNode.data);
	        curNode = nextNode;
	    }
	    /*Connect the tail of first linked list with head of second linked list
	    and so on*/
	    result = head[0];
	  //this is hold first element data of zero index
	    Node lastElement = tail[0]; 
	 // so we start from 1
	    for (i = 1; i < numDistinctValues; ++i) { 
	        if (result == null)
	            result = head[i];
	 
	        /*Link last element of previous list with head of current list*/
	        if (lastElement != null)
	            lastElement.next = head[i];
	 
	        /*update the last element to the tail of current list*/
	        if (tail[i] != null)
	            lastElement = tail[i];
	    }
	 
	    return result;
	}
	
	
	
	// Sort a linked list of 0s, 1s and 2s  
    // by changing pointers. 
    public static Node sortList(Node head) 
    { 
        if(head==null || head.next==null) 
        { 
            return head; 
        } 
        // Create three dummy nodes to point to  
        // beginning of three linked lists. These  
        // dummy nodes are created to avoid many  
        // null checks.  
        Node zeroDumy = new Node(0);  
        Node oneDumy = new Node(0);  
        Node twoDumy = new Node(0);  
  
        // Initialize current pointers for three  
        // lists and whole list.  
        Node zero = zeroDumy, one = oneDumy, two = twoDumy;  
        // Traverse list  
        Node curr = head;  
        while (curr!=null)  
        {  
            if (curr.data == 0)  
            {  
                zero.next = curr;  
                zero = zero.next;  
                curr = curr.next;  //increment
            } 
            else if (curr.data == 1)  
            {  
                one.next = curr;  
                one = one.next;  
                curr = curr.next; //increment 
            }  
            else 
            {  
                two.next = curr;  
                two = two.next;  
                curr = curr.next;  //increment
            }  
        } 
        // Attach three lists  
        zero.next = (oneDumy.next!=null) ? (oneDumy.next) : (twoDumy.next);  
        one.next = twoDumy.next;  
        two.next = null; 
        // Updated head  
        head = zeroDumy.next; 
        return head; 
    } 
    
    
    
 // Linear-time partition routine to sort an array containing 0, 1 and 2
 	// It similar to three-way Partitioning for Dutch national flag problem
 	public static void threeWayPartition(int[] A, int end)
 	{
 		int start = 0, mid = 0;
 		int pivot = 1;

 		while (mid <= end)
 		{
 			if (A[mid] < pivot)		 // current element is 0
 			{
 				swap(A, start, mid);
 				++start;
 				++mid;
 			}
 			else if (A[mid] > pivot)	// current element is 2
 			{
 				swap(A, mid, end);
 				--end;
 			}
 			else						// current element is 1
 				++mid;
 		}
 	}

 	// Utility function to swap two elements A[i] and A[j] in the array
 	private static void swap(int[] A, int i, int j) {
 		int temp = A[i];
 		A[i] = A[j];
 		A[j] = temp;
 	}
	
	public static void main(String arg[]) {

		LinkedListSortSinglePass list = new LinkedListSortSinglePass();

		// Creating a linked list 2->1->0->0->2->0>1
		Node head=new Node(2);
		list.addToTheLast(head);
		list.addToTheLast(new Node(1));
		list.addToTheLast(new Node(0));
		list.addToTheLast(new Node(0));
		list.addToTheLast(new Node(2));
		list.addToTheLast(new Node(0));
		list.addToTheLast(new Node(1));
		list.addToTheLast(new Node(3));
		list.addToTheLast(new Node(4));
		list.printList(head);
		//this is list example
	//	Node d=sortList(head, 5);
	//	list.printList(d);
		
		Node d2=sortList(head);
		list.printList(d2);
		
		
		//This is array example
		System.out.println("It similar to three-way Partitioning for Dutch national flag problem");
		int A[] = { 0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0 };

		threeWayPartition(A, A.length - 1);
		System.out.println(Arrays.toString(A));
	}
}
