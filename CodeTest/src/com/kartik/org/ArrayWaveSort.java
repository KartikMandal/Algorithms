package com.kartik.org;

import java.util.Arrays;
/**
 * Re-arrange the elements in an array like a wave so that the values of the array alternately increase and decrease. The elements in the array are unique. For instance, if A = {50, 10, 20, 30, 40}, after re-arranging A can be {10, 30, 20, 50, 40} where in the value of consecutive elements alternately increases and decreases

This problem can be solved in O(nlogn) without additional memory as follows:

1. First sort the entire array in ascending order. So {50, 10, 20, 30, 40} becomes {10, 20, 30, 40, 50}

2. Then starting from index 1 in the array, swap the neighboring elements. So {10, 20, 30, 40, 50} becomes {10, 30, 20, 50, 40}
 * 
 * @author kmandal
 *
 */
public class ArrayWaveSort {

	/*
	a: non-empty array that has to be sorted so that the values in it 
	    alternatively increase and decrease. The elements should be unique
	*/
	public static void waveSort(int[] a) {
	    /*Sort the elements in ascending order*/
	    Arrays.sort(a);
	 
	    /*Swap the alternate elements*/
	    for (int i = 1; i < a.length - 1; i += 2) {
	        int temp = a[i];
	        a[i] = a[i+1];
	        a[i+1] = temp;
	    }
	}
	public static void main(String[] args) {
		int num[]={2,3,4,7,8,9,11};
		System.out.println(Arrays.toString(num));
		waveSort(num);
		System.out.println(Arrays.toString(num));

	}

}
