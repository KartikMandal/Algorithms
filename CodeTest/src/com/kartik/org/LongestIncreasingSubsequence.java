package com.kartik.org;
/**
 * 
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such 
 * that all elements of the subsequence are sorted in increasing order. For example, the length of LIS for 
 * {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * 
 * { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 } is 6 and LIS is {0,2,6,9,11,15 or 0,2,6,9,13,15}
 * 
 * 
 * @author kmandal
 *
 */
public class LongestIncreasingSubsequence {

	
	// Function to find length of longest increasing subsequence
		public static int LIS(int[] A, int i, int n, int prev)
		{
			// Base case: nothing is remaining
			if (i == n) {
				return 0;
			}

			// case 1: exclude the current element and process the
			// remaining elements
			int excl = LIS(A, i + 1, n, prev);

			// case 2: include the current element if it is greater
			// than previous element in LIS
			int incl = 0;
			if (A[i] > prev) {
				incl = 1 + LIS(A, i + 1, n, A[i]);
			}

			// return maximum of above two choices
			return Integer.max(incl, excl);
		}

		// Program for Longest Increasing Subsequence
		public static void main(String[] args)
		{
			int[] A = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

			System.out.print("Length of LIS is " + LIS(A, 0, A.length, Integer.MIN_VALUE));
		}

}
