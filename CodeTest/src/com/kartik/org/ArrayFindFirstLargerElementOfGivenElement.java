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
	public static void main(String[] args) {
		int[] a = {10, 20, 20, 30, 40, 50};
System.out.println(findNextHigher(a,35));
	}

}
