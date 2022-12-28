package com.kartik.org;

import java.util.Arrays;
/**
 * Given an array, remove all the duplicates from the array

Suppose the given array is A = {1, 4, 2, 1, 5, 2} and we have to remove all 
duplicates from it, then the result array is {1, 4, 2, 5}. All duplicates in 
an array A can be removed using the following approaches

1. Brute force approach. Pick every element in A and remove all the duplicates 
of that element. Removing all duplicates of one element can be done in O(n). 
Since we have to do this for n elements, the time complexity will be O(n2) 
and no extra space is needed

2. Hash table approach. Traverse the elements in A and add the elements to a 
hash table. If we encounter an element which is already in the hash table, 
then we exclude it from the result. The time complexity is O(n) but we will 
need extra space for the hash table.

3. Sorting. Sort the array A. After sorting, the duplicates will be arranged 
next to each other. Then iterate through the sorted array and retain an element 
in A only if it is different from the previous element. We will be using this 
approach in the code below. The time complexity is O(nlog(n)) and we don’t need
 additional space.
 * 
 * @author kmandal
 *
 */
public class ArrayRemoveDuplicateElement {

	/*
	a: non-empty input array from which duplicates should be removed. 
	    this array will be modified
	Returns: new output array which doesn't have duplicates 
	*/
	public static int[] removeDuplicates(int[] a) {
	    int length = a.length;
	 
	    /*Sort the array*/
	    Arrays.sort(a);
	 
	    int fillPos = 1;
	    for (int i = 1; i < length; ++i) {
	        if (a[i] != a[i - 1]) {
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
		int b[]=removeDuplicates(num);
		for (int i : b) {
			System.out.print(i+" ");
		}

	}

}
