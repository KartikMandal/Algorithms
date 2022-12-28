package com.kartik.org;

import java.util.Arrays;
/**
 * Given an array, remove all occurrences of an element from the array

Suppose the given array is A = {1, 4, 2, 1, 5, 2} and we have to remove
 all occurences of 1 from it, then the result array is {4, 2, 5, 2}. 
 The element to be removed from the array can be present in multiple
  locations. We can efficiently remove all occurrences of the element 
  in O(1) space and O(n) time in a single pass through the array by doing
   the following:

1. Maintain a variable called fill_pos to keep track of where we should 
store the next element of the array that should not be deleted.
 Initialize fill_pos to 0.

2. Traverse through the array. If the current element in the array should
 be deleted then skip it. If current element in the array should not be 
 deleted, then store the current element at fill_pos in the array and 
 increment fill_pos
 * 
 * @author kmandal
 *
 */
public class ArrayRemoveAllOcurenceElement {

	/*
	a: input array from which all occurrences of an element should be removed
	x: element to be removed
	Return value: output array after removing x 
	*/
	public static int[] removeElement(int[] a, int x) {
	    int fillPos = 0;
	    for (int i = 0; i < a.length; ++i) {
	        if (a[i] != x) {
	            a[fillPos] = a[i];
	            fillPos++;
	        }
	    }
	 
	    int[] result = Arrays.copyOf(a, fillPos);
	    return result;
	}
	public static void main(String[] args) {
		int num[]={2,0,4,0,3,0,0,7,1,10,0,8,9,2,5,3};
		for (int i : num) {
			System.out.print(i+" ");
		}
		System.out.println();
		int b[]=removeElement(num,10);
		for (int i : b) {
			System.out.print(i+" ");
		}

	}

}
