package com.kartik.org;

import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * 
 * @author kmandal
 *
 */
public class ArrayMergeMSortedList {
	/**
	 * 
	 * @author kmandal
	 *
	 */
	private static class Node {
		private int value;
		private Node next;
 
		Node(int value) {
			this.value = value;
 
		}
	}
	/**
	 * 
	 * @param lists
	 * @return
	 */
	public static Node mergeKLists(Node[] lists) {
	    if(lists==null||lists.length==0)
	        return null;
	 
	    PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>(){
	        public int compare(Node l1, Node l2){
	            return l1.value - l2.value;
	        }
	    });
	 
	    Node head = new Node(0);
	    Node p = head;
	 
	    for(Node list: lists){
	        if(list!=null)
	            queue.offer(list);//Inserts the specified element into this priority queue.

	    }    
	 
	    while(!queue.isEmpty()){
	    	//Retrieves and removes the head of this queue, or returns null if this queue is empty.
	        Node n = queue.poll();
	        p.next = n;
	        p=p.next;
	 
	        if(n.next!=null)
	            queue.offer(n.next);
	    }    
	 
	    return head.next;
	 
	}
	/**
	 * 
	 * @param node
	 * @param head
	 * @return
	 */
	public Node addToTheLast(Node node,Node head) {
		 
		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;
 
			temp.next = node;
		}
		return head;
	}
	/**
	 * 
	 * @param list
	 * @param is
	 * @return
	 */
	private static Node addArrayToLinkdList(ArrayMergeMSortedList list,
			int[] is) {
		Node headTemp=null;
		for (int i : is) {
			headTemp=list.addToTheLast(new Node(i),headTemp);
		}
		return headTemp;
	}
	/**
	 * 
	 * @param head
	 */
	public static void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.value);
			temp = temp.next;
		}
		System.out.println();
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayMergeMSortedList list=new ArrayMergeMSortedList();
		int num[][]={{2,3,4,7,8,9},{2,5,6,17,18,19},{22,24,31,71,81,91},{10,20,30,70,80,90}};
		Node lists[]=new Node[4];
		int i=0;
		for (int[] is : num) {
			Node head = addArrayToLinkdList(list, is);
			lists[i]=head;
			i++;
		}
		System.out.println();
		Node mergerDat= mergeKLists(lists);
		printList(mergerDat);
	}


	
}
