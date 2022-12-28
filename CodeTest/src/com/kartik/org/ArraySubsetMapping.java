package com.kartik.org;

import java.util.Arrays;
import java.util.HashMap;
/**
 * <pre>
 * Largest sub-set possible for an array satisfying the given condition
 * Given an array arr[] and an integer K. The task is to find the size of 
 * the maximum sub-set such that every pair from the sub-set (X, Y) is of 
 * the form Y != (X * K) where X < Y.
 * 
 * Example 1:
 * input: arr[] = {2, 3, 6, 5, 4, 10}, K = 2
 * Output: 3 {2, 3, 5} is the required sub-set
 * Example 2:
 * Input: arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, K = 2
 * Output: 6
 * </pre>
 * @author kmandal
 *
 */
public class ArraySubsetMapping {

	// Function to return the size of the required sub-set 
	static int sizeSubSet(int a[], int k, int n) 
	{ 
	    // Sort the array 
	    Arrays.sort(a); 
	  
	    // HashMap to store the contents 
	    // of the required sub-set 
	    HashMap< Integer, Integer> s = new HashMap< Integer, Integer>(); 
	      
	    // Insert the elements satisfying the conditions 
	    for (int i = 0; i < n; i++) 
	    { 
	        if (a[i] % k != 0 || s.get(a[i] / k) == null) 
	            s.put(a[i], s.get(a[i]) == null ? 1 : s.get(a[i]) + 1); 
	    } 
	  
	    // Return the size of the set 
	    return s.size(); 
	} 
	  
	// Driver code 
	public static void main(String args[]) 
	{ 
	    int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; 
	    int n = a.length; 
	    int k = 2; 
	    System.out.println( sizeSubSet(a, k, n)); 
	} 

}
