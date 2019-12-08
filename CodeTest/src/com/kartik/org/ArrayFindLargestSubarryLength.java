package com.kartik.org;

import java.util.HashMap;

/**
 * 
 * Given an array of integers, find the length of the longest subarray 
 * with sum equals to 0.
Examples :

Input: arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
Output: 5
The largest subarray with 0 sum is -2, 2, -8, 1, 7
 * 
 */
public class ArrayFindLargestSubarryLength {

	/**
	 * A simple solution is to consider all subarrays one by one and check 
	 * the sum of every subarray. We can run two loops: the outer loop 
	 * picks a starting point i and the inner loop tries all subarrays 
	 * starting from i. Time complexity of this method is O(n2).
	 * @param arr
	 * @param n
	 * @return
	 */
    static int maxLen(int arr[], int n) 
    { 
        int max_len = 0; 
  
        // Pick a starting point 
        for (int i = 0; i < n; i++) { 
            // Initialize curr_sum for every 
            // starting point 
            int curr_sum = 0; 
  
            // try all subarrays starting with 'i' 
            for (int j = i; j < n; j++) { 
                curr_sum += arr[j]; 
  
                // If curr_sum becomes 0, then update 
                // max_len 
                if (curr_sum == 0) 
                    max_len = Math.max(max_len, j - i + 1); 
            } 
        } 
        return max_len; 
    } 
  
    //https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
 // Returns length of the maximum length subarray with 0 sum 
    /**
     * 
     * @param arr
     * @return
     */
    static int maxLen(int arr[]) 
    { 
        // Creates an empty hashMap hM 
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>(); 
  
        int sum = 0; // Initialize sum of elements 
        int max_len = 0; // Initialize result 
  
        // Traverse through the given array 
        for (int i = 0; i < arr.length; i++) { 
            // Add current element to sum 
            sum += arr[i]; 
  
            if (arr[i] == 0 && max_len == 0) 
                max_len = 1; 
  
            if (sum == 0) 
                max_len = i + 1; 
  
            // Look this sum in hash table 
            Integer prev_i = hM.get(sum); 
  
            // If this sum is seen before, then update max_len 
            // if required 
            if (prev_i != null) 
                max_len = Math.max(max_len, i - prev_i); 
            else // Else put this sum in hash table 
                hM.put(sum, i); 
        } 
  
        return max_len; 
    }
    
    public static void main(String args[]) 
    { 
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 }; 
        int n = arr.length; 
        System.out.println("Length of the longest 0 sum "
                           + "subarray is " + maxLen(arr, n)); 
        
        System.out.println("Length of the longest 0 sum "
                + "subarray is " + maxLen(arr)); 
    } 

}
