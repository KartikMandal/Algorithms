package com.kartik.org;
/**
 * Find the first element larger than k in a sorted array
Consider the sorted array A = {10, 20, 20, 30, 40, 50}. The first element larger than 25 is 30. 
In normal binary search, we search for a particular element and stop when we find 
the element. When we are trying to find the first element larger than k, k may 
not even exist in the array. So we instead use a modified form of binary 
search where we keep track of the first element larger than k as we search the array. 
The time complexity is O(logn). The code is given below

An efficient solution is to use Binary Search. In a general binary search, we are looking for a 
value which appears in the array. Sometimes, however, we need to find the first element which is 
either greater than a target.

To see that this algorithm is correct, consider each comparison being made. If we find an element 
that’s no greater than the target element, then it and everything below it can’t possibly match, 
so there’s no need to search that region. We can thus search the right half. If we find an 
element that is larger than the element in question, then anything after it must also be larger, 
so they can’t be the first element that’s bigger and so we don’t need to search them. 
The middle element is thus the last possible place it could be.

Note that on each iteration we drop off at least half the remaining elements from consideration. 
If the top branch executes, then the elements in the range [low, (low + high) / 2] are all discarded, 
causing us to lose floor((low + high) / 2) – low + 1 >= (low + high) / 2 – low = (high – low) / 2 elements.

If the bottom branch executes, then the elements in the range [(low + high) / 2 + 1, high] are 
all discarded. This loses us high – floor(low + high) / 2 + 1 >= high – (low + high) / 2 = (high – low) / 2 elements.

Consequently, we’ll end up finding the first element greater than the target in O(lg n) iterations of this process.
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
	
	
	/*
	a: sorted array containing elements in non-decreasing order
	k: we are searching for the number immediately above k
	Returns: the number immediately greater than k in the array if it exists,
	    MAX_INT otherwise By using Binary search 
	*/
	public static int findNextHigherIndex(int[] a, int k) {
		int start = 0, end = a.length - 1;  
	    
        int ans = -1;  
        while (start <= end) {  
            int mid = (start + end) / 2;  
    
            // Move to right side if target is  
            // greater.  
            if (a[mid] <= k) {  
                start = mid + 1;  
            }  
    
            // Move left side.  
            else {  
                ans = mid;  
                end = mid - 1;  
            }  
        }  
        return ans;
	}
	
	
	// Returns index of x if it is present in arr[l.. 
    // r], else return -1 
   /* static int binarySearch(int arr[], int l, int r, int x) 
    { 
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
  
            // If the element is present at the 
            // middle itself 
            if (arr[mid] == x) 
                return mid; 
  
            // If element is smaller than mid, then 
            // it can only be present in left subarray 
            if (arr[mid] > x) 
                return binarySearch(arr, l, mid - 1, x); 
  
            // Else the element can only be present 
            // in right subarray 
            return binarySearch(arr, mid + 1, r, x); 
        } 
  
        // We reach here when element is not present 
        // in array 
        return -1; 
    } */
	
    
 // Returns index of x if it is present in arr[l.. 
    // r], else return -1 
    static int binarySearchToGetNextHigherElement(int arr[], int l, int r, int x) 
    { 
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
            if (arr[mid] >= x) {  
                return mid;  
            }  
  
            // If element is smaller than mid, then 
            // it can only be present in left subarray 
            if (arr[mid] >= x)
            return binarySearchToGetNextHigherElement(arr, l, mid - 1, x); 
  
            // Else the element can only be present 
            // in right subarray 
            return binarySearchToGetNextHigherElement(arr, mid + 1, r, x); 
        } 
  
        // We reach here when element is not present 
        // in array 
        return -1; 
    } 
	
	
	
	static class TreeNode {  
	    int key;  
	    TreeNode left, right;  
	} 
	  
	// To create new BST Node  
	static TreeNode newNode(int item)  
	{  
		TreeNode temp = new TreeNode();  
	    temp.key = item;  
	    temp.left = null; 
	    temp.right = null;  
	    return temp;  
	}  
	  
	// To insert a new node in BST  
	static TreeNode insert(TreeNode node, int key)  
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
	static int findMaxforN(TreeNode root, int N)  
	{  
	    // Base cases  
	    if (root == null)  
	        return -1;  
	    /*if (root.key == N)  
	        return N;  
	    else if (root.key> N)  
            return root.key;  
	    return root.key < N?findMaxforN(root.right, N):findMaxforN(root.left, N);*/
	    if (root.key >= N)  
	        return root.key;  
	    return root.key < N?findMaxforN(root.right, N):findMaxforN(root.left, N);
	}
	public static void main(String[] args) {
		int[] a = {10, 20, 20, 30,37,39, 40, 50};
		System.out.println(findNextHigher(a,35));
		System.out.println(findNextHigherIndex(a,35));
		System.out.println(binarySearchToGetNextHigherElement(a,0,a.length-1,35));
		
		int N = 41;
		TreeNode root1 = null; 
	    root1 = insert(root1, a[0]);
	    for (int i=1;i<a.length;i++) {
	    	 insert(root1, a[i]);
		}
	      
	    System.out.println(findMaxforN(root1, N));
	    
	    TreeNode root = null; 
	    root = insert(root, 25);  
	    insert(root, 2);  
	    insert(root, 1);  
	    insert(root, 3);  
	    insert(root, 12);  
	    insert(root, 9);  
	    insert(root, 21);  
	    insert(root, 19);  
	    insert(root, 25);  
	  
	   // System.out.println(findMaxforN(root, N));
	    
	    System.out.println(findMaxforN(root, 19));
	}

}
