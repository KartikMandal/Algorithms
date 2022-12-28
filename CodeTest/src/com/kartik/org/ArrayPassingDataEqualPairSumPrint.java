package com.kartik.org;

import java.util.Arrays;
import java.util.HashSet;
/**
 * Write a program that, given an array A[] of n numbers and another number x, 
 * determines whether or not there exist two elements in S whose sum is exactly x.
 * 
 * This method works in O(n) time and Auxiliary Space: O(n) where n is size of array.
 * 1) Initialize an empty hash table s.
 * 2) Do following for each element A[i] in A[]
   (a)    If s[x - A[i]] is set then print the pair (A[i], x - A[i])
   (b)    Insert A[i] into s.
 * 
 * @author kmandal
 *
 */
public class ArrayPassingDataEqualPairSumPrint {
	public static void main(String args[]) { 
		int []a=new int[]{ 12, 14, 17, 15, 19, 20, -11};
		int []b=new int[]{ 2, 4, 7, 5, 9, 10, -1};
		System.out.println("Using simple technique give O(n2) time");
		printPairsUsingTwoPointers( a, 9); 
		System.out.println("Using hashing technique give O(n) time");
		printpairs( b, 9);
	} 
	/** * Given a number finds two numbers from an array so that the sum is equal to that number k. 
	 * 
	 *  @param numbers 
	 *  @param k
	 *   
	 **/ 
	public static void printPairsUsingTwoPointers(int[] numbers, int k) {
		if (numbers.length < 2) {
			return;
		}
		Arrays.sort(numbers);
		int left = 0;
		int right = numbers.length - 1;
		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum == k) {
				System.out.printf("(%d, %d) %n", numbers[left], numbers[right]);
				left = left + 1;
				right = right - 1;
			} else if (sum < k) {
				left = left + 1;
			} else if (sum > k) {
				right = right - 1;
			}
		}
	}
	
	/**
	 * METHOD 2 (Use Hashing)
	  This method works in O(n) time.

	1) Initialize an empty hash table s.
	2) Do following for each element A[i] in A[]
   (a)    If s[x - A[i]] is set then print the pair (A[i], x - A[i])
   (b)    Insert A[i] into s.
   Time Complexity: O(n)
	Auxiliary Space: O(n) where n is size of array.
	 * @param arr
	 * @param sum
	 */
	static void printpairs(int arr[],int sum) 
    {        
        HashSet<Integer> s = new HashSet<Integer>(); 
        for (int i=0; i<arr.length; ++i) 
        { 
            int temp = sum-arr[i]; 
            // checking for condition 
            if (temp>=0 && s.contains(temp)) 
            { 
                System.out.println("Pair with given sum " + 
                                    sum + " is (" + arr[i] + 
                                    ", "+temp+")"); 
            } 
            s.add(arr[i]); 
        } 
    } 

}
