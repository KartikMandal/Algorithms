package com.kartik.org;

import java.util.Arrays;

/**
 * 
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the
 * longest subsequence of a given sequence such that all elements of the
 * subsequence are sorted in increasing order. For example, the length of LIS
 * for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60,
 * 80}.
 * 
 * { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 } is 6 and LIS is
 * {0,2,6,9,11,15 or 0,2,6,9,13,15}
 * 
 * 
 * 
 * 
 * @author kmandal
 *
 */
public class ArrayLongestIncreasingSubsequence {

	// Function to find length of longest increasing subsequence
	public static int LIS(int[] A, int i, int n, int prev) {
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

	/**
	 * Approach 4: Dynamic Programming with Binary Search Algorithm
	 * 
	 * In this approach, we scan the array from left to right. We also make use
	 * of a dpdp array initialized with all 0's. This dpdp array is meant to
	 * store the increasing subsequence formed by including the currently
	 * encountered element. While traversing the numsnums array, we keep on
	 * filling the dpdp array with the elements encountered so far. For the
	 * element corresponding to the j^{th}j th index (nums[j]nums[j]), we
	 * determine its correct position in the dpdp array(say i^{th}i th index) by
	 * making use of Binary Search(which can be used since the dpdp array is
	 * storing increasing subsequence) and also insert it at the correct
	 * position. An important point to be noted is that for Binary Search, we
	 * consider only that portion of the dpdp array in which we have made the
	 * updates by inserting some elements at their correct positions(which
	 * remains always sorted). Thus, only the elements upto the i^{th}i th index
	 * in the dpdp array can determine the position of the current element in
	 * it. Since, the element enters its correct position(ii) in an ascending
	 * order in the dpdp array, the subsequence formed so far in it is surely an
	 * increasing subsequence. Whenever this position index ii becomes equal to
	 * the length of the LIS formed so far(lenlen), it means, we need to update
	 * the lenlen as len = len + 1len=len+1.
	 * 
	 * Note: dpdp array does not result in longest increasing subsequence, but
	 * length of dpdp array will give you length of LIS.
	 * 
	 * Consider the example:
	 * 
	 * input: [0, 8, 4, 12, 2]
	 * 
	 * dp: [0]
	 * 
	 * dp: [0, 8]
	 * 
	 * dp: [0, 4]
	 * 
	 * dp: [0, 4, 12]
	 * 
	 * dp: [0 , 2, 12] which is not the longest increasing subsequence, but
	 * length of dpdp array results in length of Longest Increasing Subsequence.
	 * 
	 * https://leetcode.com/problems/longest-increasing-subsequence/solution/
	 * 
	 * @param nums
	 * @return
	 */
	public static int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		int len = 0;
		for (int num : nums) {
			int i = Arrays.binarySearch(dp, 0, len, num);
		    //  int i = Arrays.binarySearch(nums,num);

			if (i < 0) {
				i = -(i + 1);
			}
			dp[i] = num;
			if (i == len) {
				len++;
			}
		}
		return len;
	}
	/**
	Approach 3: Dynamic Programming
	Algorithm

	This method relies on the fact that the longest increasing subsequence possible upto the i^{th}i 
	th
	  index in a given array is independent of the elements coming later on in the array. Thus, if we know the length of the LIS upto i^{th}i 
	th
	  index, we can figure out the length of the LIS possible by including the (i+1)^{th}(i+1) 
	th
	  element based on the elements with indices jj such that 0 \leq j \leq (i + 1) 0<=j<=(i+1).

	We make use of a dpdp array to store the required data. dp[i]dp[i] represents the length of the longest increasing s
	ubsequence possible considering the array elements upto the i^{th}i 
	th
	  index only ,by necessarily including the i^{th}i 
	th
	  element. In order to find out dp[i]dp[i], we need to try to append the current element(nums[i]nums[i]) in every possible 
	  increasing subsequences upto the (i-1)^{th}(i-1) 
	th
	  index(including the (i-1)^{th}(i-1) 
	th
	  index), such that the new sequence formed by adding the current element is also an increasing subsequence. Thus, we can easily determine dp[i]dp[i] using:

	dp[i] = \text{max}(dp[j]) + 1, \forall 0\leq j < idp[i]=max(dp[j])+1, 0<=j<i

	At the end, the maximum out of all the dp[i]dp[i]'s to determine the final result.

	LIS_{length}= \text{max}(dp[i]), \forall 0\leq i < n LIS 
	length	
	 =max(dp[i]), 0<=i<n

	The following animation illustrates the method:
	*/
	public static int lengthOfLISDP(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

	// Program for Longest Increasing Subsequence
	public static void main(String[] args) {
		int[] A = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

		System.out.println("Length of LIS is "
				+ LIS(A, 0, A.length, Integer.MIN_VALUE));
		
		System.out.println(lengthOfLIS(A));
		System.out.println(lengthOfLISDP(A));
	}

}
