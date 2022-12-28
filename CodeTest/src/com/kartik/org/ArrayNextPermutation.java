package com.kartik.org;

import java.util.Arrays;

public class ArrayNextPermutation {

	public void nextPermutation(int[] nums) {
		// find first decreasing digit
		int mark = -1;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				mark = i - 1;
				break;
			}
		}
		if (mark == -1) {
			reverse(nums, 0, nums.length - 1);
			return;
		}
		int idx = nums.length - 1;
		for (int i = nums.length - 1; i >= mark + 1; i--) {
			if (nums[i] > nums[mark]) {
				idx = i;
				break;
			}
		}
		swap(nums, mark, idx);
		reverse(nums, mark + 1, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}

	private void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

	private void reverse(int[] nums, int i, int j) {
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		int []nums={1,2,8,7};
		ArrayNextPermutation aa=new ArrayNextPermutation();
	//	nums=new int[]{1,2,3,4};
		aa.nextPermutation(nums);

	}

}
