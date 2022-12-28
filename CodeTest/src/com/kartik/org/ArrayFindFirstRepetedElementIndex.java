package com.kartik.org;

import java.util.HashSet;

/**
 Find the first occurrence of a number in a sorted array

Consider the sorted array A = {10, 10, 20, 20, 30, 30, 30}. If we are asked to return
 the first occurrence of 30, then we return the index 4. If we are asked to return
  the first occurrence of a number not present in the array such as 15, then we return -1.

We can do this using modified binary search in O(logn). 
In normal binary search, we stop as soon as we find the element being searched. 
In the modified binary search, we continue the binary search if the found element
 is not the first occurrence of the element in the array. The code is given below
 * @author kmandal
 *
 */
public class ArrayFindFirstRepetedElementIndex {

	/*
	a: array being searched
	x: element being searched
	Return value: first position of x in a, if x is absent -1 is returned
	*/
	public static int findFirst(int[] a, int x) {
	    int n = a.length;
	    int low = 0;
	    int high = n - 1;
	 
	    while (low <= high) {
	        int mid = (low + high) / 2;
	 
	        if (a[mid] == x) {
	            if (mid == 0 || a[mid - 1] != x)
	                 return mid;
	            else
	                 high = mid - 1;
	 
	        } else if (a[mid] > x) {
	            high = mid - 1;
	        } else {
	            low = mid + 1;
	        }
	    }
	    return -1;
	}
	
	
	// This function prints the first repeating element in arr[] 
		static int getFirstRepeatingElementArray(int array[]) 
		{ 
			// Initialize index of first repeating element 
			int minimumIndex = -1; 
	 
			// Creates an empty hashset 
			HashSet<Integer> set = new HashSet<>(); 
	 
			// Iterate over the input array from right to left 
			for (int i=array.length-1; i>=0; i--) 
			{ 
				// If set contains the element, update minimum index 
				if (set.contains(array[i])) 
					minimumIndex = i; 
	 
				else   // Else add element to hash set 
					set.add(array[i]); 
			} 
			return minimumIndex;
		} 
	 
	
	
	public static void main(String[] args) {
		int[] a = {10, 11, 20, 20, 30, 30, 30};
       System.out.println(findFirst(a,30));
       
       System.out.println(getFirstRepeatingElementArray(a));
	}

}
