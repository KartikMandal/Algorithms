package com.kartik.org;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note: 
You may assume k is always valid, 1 <= k <= input array's size for non-empty array.

Follow up:
Could you solve it in linear time?
 * 
 * 
 * 
 * @author kmandal
 *
 */
public class ArrayFindMaximumSlidingWindow {

	public static void main(String[] args) {
		int[] data;
		data = new int[] {1,3,-1,-3,5,3,6,7};
		int windowSize=3;
		maxSlideWindowDque(data,data.length, windowSize);
		System.out.println();
		data = new int[]{1,3,-1,-3,5,3,6,7};
		 int a[]=maxSlideWindow(data, windowSize);
		 for (int i : a) {
			 System.out.print(i+" ");
		}
		 System.out.println();
		 data = new int[]{1,3,12,-3,9,3,6,7};
		 efficientSolution(data,windowSize);
	}
	
	
	/**
	 * Using buret force process
	 * @param A
	 * @param k
	 * @return
	 */
	static int[] maxSlideWindow(int[] A,int k){
		int[] maxs = new int[A.length - k + 1];
		for (int i = 0; i < maxs.length; i++) {
		  int temp = A[i];
		  for (int j = 1; j < k; j++) {
		    if (A[i + j] > temp)  // Can flip inequality to get minimum
		      temp = A[i + j];
		  }
		  maxs[i] = temp;
		}
		return maxs;
	}
/**
 * A Dequeue (Double ended queue) based method for printing maixmum element of
 * all subarrays of size k
 * @param nums
 * @param k
 * @return
 */
	
	
	static void maxSlideWindowDque(int arr[], int n, int k) {
		// Create a Double Ended Queue, Qi that will store indexes of array
		// elements
		// The queue will store indexes of useful elements in every window and
		// it will
		// maintain decreasing order of values from front to rear in Qi, i.e.,
		// arr[Qi.front[]] to arr[Qi.rear()] are sorted in decreasing order
		Deque<Integer> Qi = new LinkedList<Integer>();

		/* Process first k (or first window) elements of array */
		int i;
		for (i = 0; i < k; ++i) {
			// For every element, the previous smaller elements are useless so
			// remove them from Qi
			while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()])
				Qi.removeLast(); // Remove from rear

			// Add new element at rear of queue
			Qi.addLast(i);
		}

		// Process rest of the elements, i.e., from arr[k] to arr[n-1]
		for (; i < n; ++i) {
			// The element at the front of the queue is the largest element of
			// previous window, so print it
			System.out.print(arr[Qi.peek()] + " ");

			// Remove the elements which are out of this window
			while ((!Qi.isEmpty()) && Qi.peek() <= i - k)
				Qi.removeFirst();

			// Remove all elements smaller than the currently
			// being added element (remove useless elements)
			while ((!Qi.isEmpty()) && arr[i] >= arr[Qi.peekLast()])
				Qi.removeLast();

			// Add current element at the rear of Qi
			Qi.addLast(i);

		}

		// Print the maximum element of last window
		System.out.print(arr[Qi.peek()]);
	}
	
	static void efficientSolution(int[] A, int w) {
		Deque<Integer> DQ = new ArrayDeque<Integer>();
	        // the first window case
		for (int i = 0; i < w; i++) {
			// If the element at next index is greater than the element at the index stored at the end, 
	                // remove the element index from the end.
			while (!DQ.isEmpty() && A[i] >= A[DQ.getLast()])
				DQ.removeLast();
			// add the next index at the end of the queue.
			DQ.addLast(i);
		}
	        // sliding starts
		for (int i = w; i < A.length; i++) {
			System.out.println(A[DQ.getFirst()]);
	 
			// follow the same guidelines as above
			while (!DQ.isEmpty() && A[i] >= A[DQ.getLast()])
				DQ.removeLast();
	 
			// remove elements which are no longer in the range of the window
			while (!DQ.isEmpty() && DQ.getFirst() <= i - w)
				DQ.remove();
	 
			// add the new index.
			DQ.addLast(i);
		}
	 
		System.out.println(A[DQ.getFirst()]);
	}
}
