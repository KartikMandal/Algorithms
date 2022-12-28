package com.kartik.org;

/**
 * Replace each element in an array with the next greatest

Consider the array A = {0, 2, 8, 1, 3, 5, 4}.

The greatest number after 0 in A is maximum of {2, 8, 1, 3, 5, 4} = 8. So 0 is replaced by 8.

The greatest number after 8 in A is maximum of {1, 3, 5, 4} = 5. So 8 is replaced with 5.

4 is the last number in A. There are no more elements to its right. So 4 is replaced by an 
invalid number or the smallest possible number.

So the resulting array is = {8, 8, 5, 5, 5, 4, 99999}.

The brute force approach will try to compute the next greatest of an element by 
scanning all the elements to its right. This will have a time complexity of O(n2).

However we can achieve the same in O(n) by traversing from the end of the array 
to the beginning and maintaining the maximum element seen so far. The code is given below
 * 
 * @author kmandal
 *
 */
public class ArrayReplaceEachElementNextGreatest {

	/*
	a: non-empty array in which each element should be replaced with next greatest
	*/
	public static int[] replaceWithNextGreatest(int[] a) {
	    int n = a.length;
	    int nextGreatest = a[n-1];
	    a[n-1] = 99999;  
	 
	    /*Process the array backwards*/
	    for (int i = n-2; i >= 0; --i) {
	        int temp = a[i];
	 
	        a[i] = nextGreatest;
	 
	        if (temp > nextGreatest)
	            nextGreatest = temp;
	    }
		return a;
	}
	public static void main(String[] args) {
		int num[]={2,0,4,0,3,0,0,7,1,10,0,8,9,2,5,3};
		for (int i : num) {
			System.out.print(i+" ");
		}
		System.out.println();
		int b[]=replaceWithNextGreatest(num);
		for (int i : b) {
			System.out.print(i+" ");
		}

	}

}
