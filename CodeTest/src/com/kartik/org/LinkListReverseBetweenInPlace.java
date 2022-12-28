package com.kartik.org;

/**
 * 
 * @author kmandal
 *
 */

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
				
		/**
		 * <code>
		 * <li><b>  Leetcode-Reverse Linked List </b></li>
			<br>
			Reverse a linked list from position m to n. Do it in-place and in one-pass.
			<br>
			For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
			<br>
			return 1->4->3->2->5->NULL.
			<br>
			Note: Given m, n satisfy the following condition: 1<= m <= n <= length of list.
			<br>
			<li><b>Analysis</b></li>
			<br>
			 --------->1------>2------->3------->4-------5------->nullptr
			 <br>
			  
			HeadPrev  head  constPrev  prev      cur  cur->next
			<br>
			  --------->1------>2------->4------->3-------5------->nullptr
			 <br>
			HeadPrev  head  constPrev        	prev  	 cur

			
		 * </code>		
		 * @param head
		 * @param m
		 * @param n
		 * @return
		 */
			
		public static Node reverseList(Node head, int m, int n){
			if (m > n)
		        return null;
			
			if (m == n)
		        return head;
		 
		    // revs and revend is start and end respectively
		    // of the portion of the linked list which
		    // need to be reversed. revs_prev is previous
		    // of starting position and revend_next is next
		    // of end of list to be reversed.
		    Node start = null, start_prev = null;
		    Node end = null, end_next = null;
		 
		    // Find values of above pointers.
		    int i = 1;
		    Node curr = head;
		    while (curr!=null && i <= n) {
		        if (i < m)
		            start_prev = curr;
		        if (i == m)
		            start = curr;
		 
		        if (i == n) {
		            end = curr;
		            end_next = curr.next;
		        }
		 
		        curr = curr.next;
		        i++;
		    }
		    end.next = null; //nullifing of start_prev and start after the n position
		 
		    // Reverse linked list starting with
		    end = reverseLinkedList(start);
		    // If starting position was not head
		    if (start_prev !=null)
		        start_prev.next = end;
		 
		    // If starting position was head
		    else
		        head = end;
		 
		    start.next = end_next;
		    return head;
		}
		
		public static Node reverseLinkedList(Node node) {
			if (node == null || node.next == null) {
				return node;
			}

			Node remaining = reverseLinkedList(node.next);
			node.next.next = node;
			node.next = null;
			return remaining;
		}
		
		public static void main (String[] args) {
			for ( int i = 130 ; i >= 10 ; i=i-10)
				push(i);
				//Node n= head;
			System.out.println("Generated Linked List: ");
			printLinkedList();
			System.out.println("Linked list after rotation: ");
			Node n = head;
			head=reverseList(n, 2,10);
			System.out.println("Generated Linked List: ");
			printLinkedList();
		}

}
