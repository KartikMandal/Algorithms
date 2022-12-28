package com.kartik.org;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an array of integers, find the length of the longest subarray with sum
 * equals to 0. Examples :
 * 
 * Input: arr[] = {15, -2, 2, -8, 1, 7, 10, 23}; Output: 5 The largest subarray
 * with 0 sum is -2, 2, -8, 1, 7
 * 
 */
public class ArrayFindLargestSubarryLength {

	/**
	 * A simple solution is to consider all subarrays one by one and check the
	 * sum of every subarray. We can run two loops: the outer loop picks a
	 * starting point i and the inner loop tries all subarrays starting from i.
	 * Time complexity of this method is O(n2).
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	static int maxLen(int arr[], int n) {
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

	// https://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
	// Returns length of the maximum length subarray with 0 sum
	/**
	 * 
	 * @param arr
	 * @return
	 */
	static int maxLen(int arr[]) {
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
			// if required this is very important
			if (prev_i != null)
				max_len = Math.max(max_len, i - prev_i);
			else
				// Else put this sum in hash table
				hM.put(sum, i);
		}

		return max_len;
	}

	public static void subArraySum(int[] arr, int n, int sum) {
		// cur_sum to keep track of cummulative sum till that point
		int cur_sum = 0;
		int start = 0;
		int end = -1;
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			cur_sum = cur_sum + arr[i];
			// check whether cur_sum - sum = 0, if 0 it means
			// the sub array is starting from index 0- so stop
			if (cur_sum - sum == 0) {
				start = 0;
				end = i;
				break;
			}
			// if hashMap already has the value, means we already
			// have subarray with the sum - so stop
			if (hashMap.containsKey(cur_sum - sum)) {
				start = hashMap.get(cur_sum - sum) + 1;
				end = i;
				break;
			}
			// if value is not present then add to hashmap
			hashMap.put(cur_sum, i);

		}
		// if end is -1 : means we have reached end without the sum
		if (end == -1) {
			System.out.println("No subarray with given sum exists");
		} else {
			System.out.println("Sum found between indexes " + start + " to "
					+ end);
		}
	}

	// User defined pair class
	static class Pair {
		int first, second;

		Pair(int a, int b) {
			first = a;
			second = b;
		}
	}

	/**
	 * <code>
	 *  arr[] ={1,-4,2,2,5,-4,3}
	 *  
	 *  If we consider all prefix sums, we can notice that there is a sub array with 0 sum 
	 *  when:
	 *  case 1:Either a prefix sum is repeted or 
	 *  Case 2: Or prefix sum is 0.
	 *  
	 *  after create prefix sum:
	 *  arr[] ={1,-3,-1,1,6,2,5}
	 *  
	 *  Since prefix sum 1 repeted so we have found longest sorted sub array found
	 *  
	 * </code>
	 * 
	 * @param a
	 */
	static ArrayList<Pair> findSubArrays(int[] arr, int n) {
		// create an empty map
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		// create an empty vector of pairs to store
		// subarray starting and ending index
		ArrayList<Pair> out = new ArrayList<>();

		// Maintains sum of elements so far
		int sum = 0;

		for (int i = 0; i < n; i++) {
			// add current element to sum
			sum += arr[i];
			// if sum is 0, we found a subarray starting
			// from index 0 and ending at index i
			if (sum == 0){
				out.add(new Pair(0, i));
			}
			ArrayList<Integer> al = new ArrayList<>();

			// If sum already exists in the map there exists
			// at-least one subarray ending at index i with
			// 0 sum
			if (map.containsKey(sum)) {
				// map[sum] stores starting index of all subarrays
				al = map.get(sum);
				for (int it = 0; it < al.size(); it++) {
					out.add(new Pair(al.get(it) + 1, i));
				}
			}
			al.add(i);
			map.put(sum, al);
		}
		return out;
	}

	/**
	 * <code>
	 *  arr[] ={1,-4,2,2,5,-4,3}
	 *  
	 *  If we consider all prefix sums, we can notice that there is a sub array with 0 sum 
	 *  when:
	 *  case 1:Either a prefix sum is repeted or 
	 *  Case 2: Or prefix sum is 0.
	 *  
	 *  after create prefix sum:
	 *  arr[] ={1,-3,-1,1,6,2,5}
	 *  
	 *  Since prefix sum 1 repeted so we have found longest sorted sub array found
	 *  
	 * </code>
	 * 
	 * @param a
	 */
	static boolean subArray(int[] a) {
		Map<Integer, Boolean> m = new HashMap<>();
		int n = a.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += a[i];
			if (sum == 0 || (m.get(sum) != null && m.get(sum) == true)) {
				return true;
			}
			m.put(sum, true);
		}
		return false;
	}

	public static void main(String args[]) {
		int arr[] = { 15, -2, 2, -5, 0, 5, -8, 1, 7, 10, 23 };
		int n = arr.length;
		System.out.println("Length of the longest 0 sum " + "subarray is "
				+ maxLen(arr, n));

		System.out.println("Length of the longest 0 sum " + "subarray is "
				+ maxLen(arr));
		subArraySum(arr, arr.length - 1, 0);

		int a[] = { 1, -4, 2, 2, 5, -4, 3 };
		System.out.println(subArray(a));

	}

}
