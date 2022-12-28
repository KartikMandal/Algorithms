package com.kartik.org;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author kmandal
 *
 */
public class ArraySubarraySumHavingExactlySameOfPassingKvalue {

	// Function to find number of subarrays
	// with sum exactly equal to k.
	static int findSubarraySum(int arr[], int n, int sum) {
		// HashMap to store number of subarrays
		// starting from index zero having
		// particular value of sum.
		Map<Integer, Integer> prevSum = new HashMap<>();

		int res = 0;

		// Sum of elements so far.
		int currsum = 0;
		int maxSize=0;
		for (int i = 0; i < n; i++) {

			// Add current element to sum so far.
			currsum += arr[i];

			// If currsum is equal to desired sum,
			// then a new subarray is found. So
			// increase count of subarrays.
			if (currsum == sum){
				res++;
				//maxSize=maxSize<prevSum.size()+1?prevSum.size()+1:maxSize;
				maxSize=Math.max(prevSum.size()+1,maxSize);
				System.out.println(maxSize);
			}
			// currsum exceeds given sum by currsum
			// - sum. Find number of subarrays having
			// this sum and exclude those subarrays
			// from currsum by increasing count by
			// same amount.
			int rem=currsum - sum;
			if (prevSum.containsKey(rem))
				res += prevSum.get(rem);

			// Add currsum value to count of
			// different values of sum.
			Integer count = prevSum.get(currsum);
			if (count == null)
				prevSum.put(currsum, 1);
			else
				prevSum.put(currsum, count + 1);
		}

		return res;
	}

	public static void main(String[] args) {

		int arr[] = {9, 1, 20, 3, 10, 5,2};
		int sum = 33;
		int n = arr.length;
		System.out.println(findSubarraySum(arr, n, sum));
	}
}