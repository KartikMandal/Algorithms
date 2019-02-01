package com.kartik.org;

/**
 * Find the maximum continuous sum in an array
 * An array can have positive and negative elements in it. We have to find a subset of contiguous elements 
 * in the array whose sum is the maximum. Let the maximum continuous sum be represented as MCS
 * 
 * In the brute force approach, we pick an element and then go on adding its right neighbors one by one to find 
 * the maximum contiguous sum starting at that element. We then repeat the process for all elements in the array 
 * to find the MCS across all elements. The time complexity of the brute force approach is O(n2).
 * 
 * However it is possible to find the MCS in O(n) time using kadane’s algorithm. This algorithm works for all cases
 *  (including the case where all the elements are negative). We maintain the variable max_local which will store 
 *  
 *  the sum of the neighboring elements in the current window. The algorithm is described below:
 *  
 *  1. Choose the first element and initialize max_local to the first element.
 *  
 *  2. Traverse through the remaining elements. If the result of adding max_local to the current element is 
 *  greater than current element, then add the current element to max_local and keep continuing the window. 
 *  If however the result of adding max_local to the current element is less than the current element, then 
 *  start a fresh window that starts at the current element and initialize max_local to the current element.
 *  
 *  3. The maximum value of max_local across all elements will be the MCS of the array.
 *  
 *  Let A = {4, -9, 5, 6 , 1} . max_local is initialized to 4. The remaining calculations are shown in the table below
 *  
 *  @link http://www.interviewdruid.com/category/dynamic-programming/
 *  
 * @author kmandal
 *
 */
public class ArrayMaximumContinuousSum {

	/* a: array of numbers for which MCS should be found. 
    At least 1 element should be present
mcsStartPos: the starting array index of the MCS is returned here
mcsEndPos: the ending array index of the MCS is returned here 
Return value: Maximum continous sum of the elements 
*/
	static int[] kadaneMcs(int a[],int startArray, int endArray) {
		int max_so_far = Integer.MIN_VALUE, curr_max = 0, start = 0, end = 0, s = 0;
		// this is required for hold the data
		int data[]=new int[3];
		for (int i = startArray; i < endArray; i++) {
			curr_max += a[i];
			if (max_so_far < curr_max) {
				max_so_far = curr_max;
				start = s;
				end = i;
			}

			if (curr_max < 0) {
				curr_max = 0;
				s = i + 1;
			}
		}
		data[0]=max_so_far;
		data[1]=start;
		data[2]=end;
		return data;
	}

	public static void main(String[] args) {
		int num[]={6,2,6,-7,5,4,-8,9};
		int data[]=kadaneMcs(num, 0,num.length);
		System.out.println("Maximum contiguous sum is "+data[0]+" Starting index " +data[1]+" Ending index " +data[2]);
		 data=kadaneMcs(num, 2,num.length);
		System.out.println("Maximum contiguous sum is "+data[0]+" Starting index " +data[1]+" Ending index " +data[2]);
		data=kadaneMcs(num, 3,num.length-1);
		System.out.println("Maximum contiguous sum is "+data[0]+" Starting index " +data[1]+" Ending index " +data[2]);

	}

}
