package com.kartik.org;

import java.util.Arrays;

public class ArrayInplaceRotate {

	public static void main(String[] args) {
		int num[]={2,4,3,7,8,9};
		System.out.println(Arrays.toString(num));
		rotate(num, 3);
		System.out.println(Arrays.toString(num));

	}

	static void rotate(int []nums,int k){
		reverse(nums,0,k-1);//3,4,2,7,8,9
		reverse(nums,k,nums.length-1);//3,4,2,9,8,7
		reverse(nums,0,nums.length-1);//7,8,9,2,4,3
		}

		static void swap(int []nums,int a,int b){
		int temp=nums[a];
		nums[a]=nums[b];
		nums[b]=temp;
		}
		static void reverse(int[]nums,int start,int end){
		for(int i=start;i<=(start+end)/2;i++){
		swap(nums,(start+end)-i,i);
		}
		}
}
