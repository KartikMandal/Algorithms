package com.kartik.org;

import java.util.Arrays;
/**
 * 
 * @author kmandal
 * 
 * start	mid		end		pivot	while condtion 		if condition	elseif condition	else condition
 * 0		0		n-1		1		while(mid<=end)		a[mid]<1		a[mid]>1
 * ---------------------------------------------------------------------------------------------------------			
 * 0		0		12		1		while(0<=12)	    0<1
 * 1		1		12		1		while(1<=12)		1<1				1>1
 * 1		2		12		1		while(2<=12)		2<1				2>1
 * 1		2		11		1		while(2<=11)		2<1				2>1
 * 1		3		11		1		while(3<=11)		2<1				2>1
 * 2		3		11		1		while()
 * 
 *
 */

public class ArrayDutchFlagAlgo {
	// Linear-time partition routine to sort an array containing 0, 1 and 2
	 	// It similar to three-way Partitioning for Dutch national flag problem
	 	public static void threeWayPartition(int[] A, int end)
	 	{
	 		int start = 0, mid = 0;
	 		int pivot = 1;

	 		while (mid <= end)
	 		{
	 			if (A[mid] < pivot)		 // current element is 0
	 			{
	 				swap(A, start, mid);
	 				++start;
	 				++mid;
	 			}
	 			else if (A[mid] > pivot)	// current element is 2
	 			{
	 				swap(A, mid, end);
	 				--end;
	 			}
	 			else						// current element is 1
	 				++mid;
	 		}
	 	}

	 	// Utility function to swap two elements A[i] and A[j] in the array
	 	private static void swap(int[] A, int i, int j) {
	 		int temp = A[i];
	 		A[i] = A[j];
	 		A[j] = temp;
	 	}
	 	
	 	public static void main(String args[]){
	 		//This is array example
			System.out.println("It similar to three-way Partitioning for Dutch national flag problem");
			int A[] = { 0, 1, 2, 2, 1, 0, 0, 2, 0, 1, 1, 0 };

			threeWayPartition(A, A.length - 1);
			System.out.println(Arrays.toString(A));
	 	}
}
