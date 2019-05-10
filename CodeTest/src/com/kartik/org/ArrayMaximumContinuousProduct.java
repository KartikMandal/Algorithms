package com.kartik.org;

public class ArrayMaximumContinuousProduct {

	// Find the maximum possible sum in arr[]  
    // such that arr[m] is part of it 
    static int maxCrossingSum(int arr[], int l, 
                                int m, int h) 
    { 
        // Include elements on left of mid. 
        int sum = 1; 
        int left_sum = Integer.MIN_VALUE; 
        for (int i = m; i >= l; i--) 
        { 
            sum = sum * arr[i]; 
            if (sum > left_sum) 
            left_sum = sum; 
        } 
  
        // Include elements on right of mid 
        sum = 1; 
        int right_sum = Integer.MIN_VALUE; 
        for (int i = m + 1; i <= h; i++) 
        { 
            sum = sum * arr[i]; 
            if (sum > right_sum) 
            right_sum = sum; 
        } 
  
        // Return sum of elements on left 
        // and right of mid 
        return left_sum * right_sum; 
    } 
  
    // Returns sum of maxium sum subarray  
    // in aa[l..h] 
    static int maxSubArraySum(int arr[], int l,  
                                      int h) 
    { 
    // Base Case: Only one element 
    if (l == h) 
        return arr[l]; 
  
    // Find middle point 
    int m = (l + h)/2; 
  
    /* Return maximum of following three  
    possible cases: 
    a) Maximum subarray sum in left half 
    b) Maximum subarray sum in right half 
    c) Maximum subarray sum such that the  
    subarray crosses the midpoint */
    return Math.max(Math.max(maxSubArraySum(arr, l, m), 
                    maxSubArraySum(arr, m+1, h)), 
                    maxCrossingSum(arr, l, m, h)); 
    } 
	
	
	
	public static void main(String[] args) {
		int num[]={6,2,6,-7,5,4,-8,9};
		/*int data[]=kadaneMcs(num, 0,num.length);
		System.out.println("Maximum contiguous sum is "+data[0]+" Starting index " +data[1]+" Ending index " +data[2]);
		 data=kadaneMcs(num, 2,num.length);
		System.out.println("Maximum contiguous sum is "+data[0]+" Starting index " +data[1]+" Ending index " +data[2]);
		data=kadaneMcs(num, 3,num.length-1);
		System.out.println("Maximum contiguous sum is "+data[0]+" Starting index " +data[1]+" Ending index " +data[2]);*/
		
		int d=maxSubArraySum(num, 0,num.length-1);
		System.out.println("Maximum contiguous sum is "+d+" Starting index 0 Ending index " +(num.length-1));

	}

}
