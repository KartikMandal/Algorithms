package com.kartik.org;

import java.util.Arrays;
/**
 * https://www.programcreek.com/2013/03/leetcode-wiggle-sort-java/
 * @author kmandal
 * 
 * Given an unsorted array nums, reorder it in-place such that nums[0] < nums[1] > nums[2] < nums[3].... Example:

Input: nums = [3,5,2,1,6,4]
Output: One possible answer is [3,5,1,6,2,4]
 *
 */
public class ArrayWiggleSort {

	public void wiggleSort(int[] nums) {
	    if (nums == null || nums.length <= 1) {
	        return;
	    }
	 
	    for (int i = 1; i < nums.length; i++) {
	        if (i % 2 == 1) {
	            if (nums[i - 1] > nums[i]) {
	                swap(nums, i - 1, i);
	            }
	        } else {
	            if (nums[i - 1] < nums[i]) {
	                swap(nums, i - 1, i);
	            }
	        }
	    }
	    System.out.println(Arrays.toString(nums));
	}
	 
	private void swap(int[] nums, int i, int j) {
	    int t = nums[i];
	    nums[i] = nums[j];
	    nums[j] = t;
	}
	public static void main(String[] args) {
		int []nums={3,5,2,1,6,4};
		ArrayWiggleSort aa=new ArrayWiggleSort();
		aa.wiggleSort(nums);
	}

}
