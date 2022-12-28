package com.kartik.org;

public class LinkedListMerge {
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


	public void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.value);
			temp = temp.next;
		}
		System.out.println();
	}
	
	// Main function that inserts nodes of linked list q into p at 
    // alternate positions. Since head of first list never changes 
    // and head of second list/ may change, we need single pointer 
    // for first list and double pointer for second list. 
   static void merge(Node p,Node q) 
    { 
        Node p_curr = p, q_curr = q; 
        Node p_next, q_next; 
  
        // While there are available positions in p; 
        while (p_curr != null && q_curr != null) { 
  
            // Save next pointers 
            p_next = p_curr.next; 
            q_next = q_curr.next; 
  
            // make q_curr as next of p_curr 
            q_curr.next = p_next; // change next pointer of q_curr 
            p_curr.next = q_curr; // change next pointer of p_curr 
  
            // update current pointers for next iteration 
            p_curr = p_next; 
            q_curr = q_next; 
        } 
        q=null;
        LinkedListMerge list=new LinkedListMerge();
        list.printList(p);
    } 
	
	
	public static void main(String[] args) {
		LinkedListMerge list=new LinkedListMerge();
		// Creating a linked list
		Node head=new Node(5);
		list.addToTheLast(head);
		list.addToTheLast(new Node(6));
		list.addToTheLast(new Node(7));
		list.addToTheLast(new Node(1));
		list.addToTheLast(new Node(2));
		list.printList(head);
		
		LinkedListMerge listtwo=new LinkedListMerge();
		
		// Creating a linked list
		Node head2 = new Node(5);
		listtwo.addToTheLast(head2);
		listtwo.addToTheLast(new Node(6));
		listtwo.addToTheLast(new Node(7));
		listtwo.addToTheLast(new Node(1));
		listtwo.addToTheLast(new Node(2));
		listtwo.printList(head2);
		
		merge(head,head2);
		
		

	}

}
