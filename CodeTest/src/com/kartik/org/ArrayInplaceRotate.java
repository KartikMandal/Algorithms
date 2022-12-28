package com.kartik.org;

import java.util.Arrays;
/**
 * Rotate an array by k times

Consider the array {10, 20, 30, 40, 50}. Suppose we rotate the array once, we have to move the elements 10, 20, 30, 40 right by 1 position and move the last element 50 to the beginning to get {50, 10, 20, 30, 40}. So if we have an array of size n, then for 1 rotate operation we will need n moves. If we rotate the array k times then there will be k*n moves. There is a faster method for rotating an array. Let the array be A = {10, 20, 30, 40, 50} and the number of rotations k = 2. The procedure is:

1. Reverse the entire array. So we get {50, 40, 30, 20, 10}

2. Reverse the array in the region 0 to k -1. If k = 2, we reverse the region A[0] to A[1]. So we get the array {40, 50, 30, 20, 10}

3. Finally reverse the array in the region k to n-1 where n is the length of the array. If k=2, we reverse the region A[2] to A[4]. So we get the required result {40, 50, 10, 20, 30}.

With this technique, we always need 2*n moves irrespective of the value of k.
 * @author kmandal
 *
 */
public class ArrayInplaceRotate {

	static void rotate(int []nums,int k){
		reverseArray(nums,0,k-1);//3,4,2,7,8,9
		reverseArray(nums,k,nums.length-1);//3,4,2,9,8,7
		reverseArray(nums,0,nums.length-1);//7,8,9,2,4,3
		}
		
		public static int[] reverseArray(int[] nums,int i,int j){
			//Tail Recursion.
			if(i<j){
				swap(nums,i,j);
			    reverseArray(nums, i+1, j-1);
			}
			return nums;
		}
		
		static void swap(int []nums,int a,int b){
			int temp=nums[a];
			nums[a]=nums[b];
			nums[b]=temp;
			}
		
		public static void main(String[] args) {
			int num[]={2,4,3,7,8,9};
			System.out.println(Arrays.toString(num));
			rotate(num, 4);
			System.out.println(Arrays.toString(num));

		}
}
