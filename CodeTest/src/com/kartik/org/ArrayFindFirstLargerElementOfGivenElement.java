package com.kartik.org;
/**
 * Find the first element larger than k in a sorted array
Consider the sorted array A = {10, 20, 20, 30, 40, 50}. The first element larger than 25 is 30. 
In normal binary search, we search for a particular element and stop when we find 
the element. When we are trying to find the first element larger than k, k may 
not even exist in the array. So we instead use a modified form of binary 
search where we keep track of the first element larger than k as we search the array. 
The time complexity is O(logn). The code is given below
 * @author kmandal
 *
 */
public class ArrayFindFirstLargerElementOfGivenElement {

	/*
	a: sorted array containing elements in non-decreasing order
	k: we are searching for the number immediately above k
	Returns: the number immediately greater than k in the array if it exists,
	    MAX_INT otherwise By using Binary search 
	*/
	public static int findNextHigher(int[] a, int k) {
	    int low = 0; 
	    int high = a.length - 1;
	 
	    int result = Integer.MAX_VALUE;
	    while (low <= high) {
	        int mid = (low + high) / 2;
	 
	        if (a[mid] > k) {
	            result = a[mid]; /*update the result and continue*/
	            high = mid - 1;
	        } else {
	            low = mid + 1;
	        }
	    } 
	 
	    return result;
	}
	
	
	
	
	
	static class Node {  
	    int key;  
	    Node left, right;  
	} 
	  
	// To create new BST Node  
	static Node newNode(int item)  
	{  
	    Node temp = new Node();  
	    temp.key = item;  
	    temp.left = null; 
	    temp.right = null;  
	    return temp;  
	}  
	  
	// To insert a new node in BST  
	static Node insert(Node node, int key)  
	{  
	    // if tree is empty return new node  
	    if (node == null)  
	        return newNode(key);  
	  
	    // if key is less then or grater then  
	    // node value then recur down the tree  
	    if (key < node.key)  
	        node.left = insert(node.left, key);  
	    else if (key > node.key)  
	        node.right = insert(node.right, key);  
	  
	    // return the (unchanged) node pointer  
	    return node;  
	}  
	  
	// function to find max value less then N  
	static int findMaxforN(Node root, int N)  
	{  
	    // Base cases  
	    if (root == null)  
	        return -1;  
	    if (root.key == N)  
	        return N;  
	    else if (root.key> N)  
            return root.key;  
	    return root.key < N?findMaxforN(root.right, N):findMaxforN(root.left, N);
	}
	public static void main(String[] args) {
		int[] a = {10, 20, 20, 30, 40, 50};
		System.out.println(findNextHigher(a,35));
		
		
		int N = 41;
	    Node root1 = null; 
	    root1 = insert(root1, a[0]);
	    for (int i=1;i<a.length;i++) {
	    	 insert(root1, a[i]);
		}
	      
	    System.out.println(findMaxforN(root1, N));
	    
	    Node root = null; 
	    root = insert(root, 25);  
	    insert(root, 2);  
	    insert(root, 1);  
	    insert(root, 3);  
	    insert(root, 12);  
	    insert(root, 9);  
	    insert(root, 21);  
	    insert(root, 19);  
	    insert(root, 25);  
	  
	    System.out.println(findMaxforN(root, N));
	    
	    System.out.println(findMaxforN(root, 19));
	}

}
