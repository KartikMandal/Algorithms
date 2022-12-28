package com.kartik.org;



/**
 *Rotate Linked List block wise
Given a Linked List of length n and block length k rotate in circular manner towards right/left each block by a number d. 
If d is positive rotate towards right else rotate towards left.

Consider the array {10, 20, 30, 40, 50}. Suppose we rotate the array once, we have to move the elements 10, 20, 30, 40 right by 1 position and move the last element 50 to the beginning to get {50, 10, 20, 30, 40}. So if we have an array of size n, then for 1 rotate operation we will need n moves. If we rotate the array k times then there will be k*n moves. There is a faster method for rotating an array. Let the array be A = {10, 20, 30, 40, 50} and the number of rotations k = 2. The procedure is:
<code>
1. number of sets will be depend on the value of n and k where n is the length of array and k is the position,

2. number of sets= gcd(n,k) where gcd is greatest common divisor 

3. outer loop i=0 to i<sets

4. nums[j]=nums[(j+k)%n];

5. inner loop end when d==i

6. increment next set 

7. Time Complexity= o(n) and space Complexity= o(n)

	_____________________________________________________
	|	i	|	j	|	d=(j+k)%n	|	nums[j]=nums[d]	|
	_____________________________________________________
	|	0	|	0	|	(0+3)%9=3	|	nums[0]=nums[3]	|
	|	0	|	3	|	(3+3)%9=6	|	nums[3]=nums[6]	|
	|	0	|	6	|	(6+3)%9=0	|	nums[6]=nums[0]	|
	_____________________________________________________
	|	1	|	1	|	(1+3)%9=4	|	nums[1]=nums[4]	|
	|	1	|	4	|	(4+3)%9=7	|	nums[4]=nums[7]	|
	|	1	|	7	|	(7+3)%9=1	|	nums[7]=nums[1]	|
	_____________________________________________________
	|	2	|	2	|	(2+3)%9=5	|	nums[2]=nums[5]	|
	|	2	|	5	|	(5+3)%9=8	|	nums[5]=nums[8]	|
	|	2	|	8	|	(8+3)%9=2	|	nums[8]=nums[2]	|
	_____________________________________________________

</code>

@author kmandal
 */

public class LinkListRotatedByJugglingAlgo {

	static Node head;
	static Node mainRoat;

	private static class Node {
		private int data;
		private Node next;
		Node(){}
		Node(int data) {
			this.data = data;

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

	static Node getPostion(Node node, int k) {
		Node current = node;
		while (k > 1) {
			current = current.next;
			k--;
		}
		current.next=null;
		return current;
	}
	
	static int getSize(Node node) {
		if(node == null){
			return 0;
		}
		return getSize(node.next)+1;

	}
	
	static int gcd(int a,int b){
		if(b==0)
			return a;
		else
			return gcd(b,a%b);
	} 
	
	public static void insertNth(int data, int position) {
		Node newNode = new Node(); //create a new node
		newNode.data = data;
		newNode.next = null;
 
		if(head == null && position != 0) { //if head is null and position is zero skip it.
			return;
		} else if(head == null && position == 0) { // if head null and position is zero set at the head.
			head = newNode;
		}
 
		if(position == 0) { // if position is zero then new node set at the head.
			newNode.next = head;
			head = newNode;
		}
 
		Node current = head;
		Node previous = null;
		int i = 0;
 
		while(i < position) { //loop until find the given position.
			previous = current;
			current = current.next;
			if(current == null)
				break;
			i++;
		}
 
		newNode.next = current; //get the new node and linked the remaining nodes in the list.
		if(previous !=null)
		previous.next = newNode; //set the looped node to the new node.
 
	}
	
	
	/* Takes index as argument and return data at index*/
    public static int getNth(int index) 
    { 
        Node current = head; 
        int count = 0; /* index of Node we are 
                          currently looking at */
        while (current != null) 
        { 
            if (count == index) 
                return current.data; 
            count++; 
            current = current.next; 
        } 
        return 0; 
    } 
	
	static Node rotate(Node nums,int k){
		
		int d=-1,i,j,n=getSize(nums);
		int temp,te;
		for(i=0;i<gcd(n,k);i++){
			j=i;
			temp=getNth(i);
			while(true){
				d=(j+k)%n;
				
				if(d==i)
					break;
				te=getNth(d);
				insertNth(te, j);
				j=d;
			}
			insertNth(temp, j);
		}
		return nums;
	}
		

	public static void main(String[] args) {
		LinkListRotatedByJugglingAlgo list=new LinkListRotatedByJugglingAlgo();
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
		Node d=rotate(head, 3);
		list.printList(d);

	}

}
