package com.kartik.org;
/**
 * 
 * Find the maximum continuous product in an array
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
public class ArrayMaximumContinuousProduct {

	// Find the maximum possible product in arr[]  
    // such that arr[m] is part of it 
    static int maxCrossingProduct(int arr[], int l, 
                                int m, int h) 
    { 
        // Include elements on left of mid. 
        int product = 1; 
        int left_Product = Integer.MIN_VALUE; 
        for (int i = m; i >= l; i--) 
        { 
            product = product * arr[i]; 
            if (product > left_Product) 
            left_Product = product; 
        } 
  
        // Include elements on right of mid 
        product = 1; 
        int right_product = Integer.MIN_VALUE; 
        for (int i = m + 1; i <= h; i++) 
        { 
            product = product * arr[i]; 
            if (product > right_product) 
            right_product = product; 
        } 
  
        // Return product of elements on left 
        // and right of mid 
        return left_Product * right_product; 
    } 
  
    // Returns product of maxium product subarray  
    // in aa[l..h] 
    static int maxSubArrayProduct(int arr[], int l,  
                                      int h) 
    { 
    // Base Case: Only one element 
    if (l == h) 
        return arr[l]; 
  
    // Find middle point 
    int m = (l + h)/2; 
  
    /* Return maximum of following three  
    possible cases: 
    a) Maximum subarray product in left half 
    b) Maximum subarray product in right half 
    c) Maximum subarray product such that the  
    subarray crosses the midpoint */
    return Math.max(Math.max(maxSubArrayProduct(arr, l, m), 
                    maxSubArrayProduct(arr, m+1, h)), 
                    maxCrossingProduct(arr, l, m, h)); 
    } 
	
	
	
	public static void main(String[] args) {
		int num[]={6,2,6,-7,5,4,-8,9};
		/*int data[]=kadaneMcs(num, 0,num.length);
		System.out.println("Maximum contiguous sum is "+data[0]+" Starting index " +data[1]+" Ending index " +data[2]);
		 data=kadaneMcs(num, 2,num.length);
		System.out.println("Maximum contiguous sum is "+data[0]+" Starting index " +data[1]+" Ending index " +data[2]);
		data=kadaneMcs(num, 3,num.length-1);
		System.out.println("Maximum contiguous sum is "+data[0]+" Starting index " +data[1]+" Ending index " +data[2]);*/
		
		int d=maxSubArrayProduct(num, 0,num.length-1);
		System.out.println("Maximum contiguous product is "+d+" Starting index 0 Ending index " +(num.length-1));

	}

}
