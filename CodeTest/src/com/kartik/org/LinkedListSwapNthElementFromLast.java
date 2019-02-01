package com.kartik.org;

public class LinkedListSwapNthElementFromLast {

	private Node head;
	 
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
 
	//public static int i = 0;  
	public static Node nthFromLastNode(Node head,int n)
	{
		Node firstPtr=head;
		Node secondPtr=head;
 
		for (int i = 0; i < n; i++) {
			firstPtr=firstPtr.next;
 
		}
 
		while(firstPtr!=null)
		{
			firstPtr=firstPtr.next;
			secondPtr=secondPtr.next;
		}
 
		return secondPtr;
		
		/*Node result = head;

	    if(head != null) {
	        result = nthFromLastNode(head.next, n);

	        if(++i == n){
	            result = head;
	        }
	    }
	    return result;*/
	}

	
	/*Helper function which swaps two neighbors n1 and n2
	head: first node in the linked list
	prev: node previous to n1
	n1: first node to be swapped
	n2: second node to be swapped. n2 occurs immediately after n1
	Return value: head of the result linked list after swapping neighbors
	*/
	public static Node swapNeighbors(Node head,  
			Node prev, Node n1, Node n2) {
	    /*Swap n1 and n2*/
	    n1.next = n2.next;
	    n2.next = n1;
	 
	    if (prev != null) {
	        prev.next = n2;
	    } else {
	        head = n2; /*If prev doesn't exist, update head to n2*/
	    }
	 
	    return head; 
	}
	/*Main function for swapping the kth node from beginning and end
	head: first node in the linked list. 
	k: which node in the linked list should be swapped
	length: number of nodes in the linked list
	Return value: head of the result linked list on success, null on error
	*/
	public static Node swapKthNode(Node head, int k, 
	                    int length)  {
		Node[] prevArray = new Node[1];
	 
	    if (head == null || k < 1 || k > length)
	        return null;
	 
	    /*k1 is the kth node from begining and prev1 is previous to k1*/
	    Node k1 = findKthNodeFromBegin(head, k, prevArray);
	    Node prev1 = prevArray[0];
	 
	    /*k2 is the kth node from end and prev2 is previous to k2*/
	    Node k2 = nthFromLastNode(head, k);
	    Node prev2 = prevArray[0];
	 
	    if (k1 == null || k2 == null)
	        return null; /*the k value is incorrect*/
	 
	    if (k1 == k2)
	        return head; /*both nodes are the same. So no need to swap*/
	 
	    /*If k1 and k2 are neighbors, then handle this case and return*/
	    if (k1.next == k2) 
	        return swapNeighbors(head, prev1, k1, k2);
	 
	    if (k2.next == k1) 
	        return swapNeighbors(head, prev2, k2, k1);
	 
	    /*k1 and k2 are not neighbors. So swap k1.next with k2.next*/
	    Node temp = k1.next;
	    k1.next = k2.next;
	    k2.next = temp;
	 
	    if (prev1 != null) {
	        prev1.next = k2; 
	    } else  {
	        head = k2; /* After swap, k2 becomes new head*/
	    }
	 
	    if (prev2 != null) {
	        prev2.next = k1; 
	    } else  {
	        head = k1; /* After swap, k1 becomes new head */
	    }
	 
	    return head;
	}
	private static Node findKthNodeFromBegin(Node head2, int k, Node[] prevArray) {
		// TODO Auto-generated method stub
		return null;
	}


	public static void main(String[] args) {
		LinkedListSwapNthElementFromLast list = new LinkedListSwapNthElementFromLast();
		// Creating a linked list
		Node head=new Node(5);
		list.addToTheLast(head);
		list.addToTheLast(new Node(6));
		list.addToTheLast(new Node(7));
		list.addToTheLast(new Node(1));
		list.addToTheLast(new Node(2));
 
		list.printList();
		// Finding 3rd node from end
		Node nthNodeFromLast= list.nthFromLastNode(head,3);
		System.out.println("3th node from end is : "+ nthNodeFromLast.value);
 
	}

}
