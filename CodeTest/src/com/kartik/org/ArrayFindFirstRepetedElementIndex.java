package com.kartik.org;
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
	
	public static void main(String[] args) {
		int[] a = {10, 10, 20, 20, 30, 30, 30};
System.out.println(findFirst(a,20));
	}

}
