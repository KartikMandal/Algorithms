package com.kartik.org;

public class ArrayFindHeavyWeight {

	static int getIndex(int[]a,int start,int end){
		int div=(end-start);
		if(div%2==1){
		int mid=div/2;
		int leftSum=sum(a,start,mid);
		int rightSum=sum(a,mid+1,end);
		if(leftSum>rightSum){
			return getIndex(a, start, end);
		}else if(leftSum<rightSum){
			return getIndex(a, start, end);
		}else{
			return Integer.MIN_VALUE;
		}
		}else{
			int mid=div/2;
			int leftSum=sum(a,start,mid);
			int rightSum=sum(a,mid+1,end);
			int extraNode=a[0];
			if(leftSum>rightSum){
				return getIndex(a, start, end);
			}else if(leftSum<rightSum){
				return getIndex(a, start, end);
			}else{
				return extraNode;
			}
		}
		
	}
	static int sum(int[]a,int start,int end){
		int sum=0;
		for (int i = start; i < end; i++) {
			sum=sum+a[i];
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
