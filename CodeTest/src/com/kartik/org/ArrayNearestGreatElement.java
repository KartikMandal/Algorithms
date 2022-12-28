package com.kartik.org;

import java.util.Stack;
/**
 * <code>
 * Given an array, print the Next Greater Element (NGE) for every element. 
 * The Next greater Element for an element x is the first greater element 
 * on the right side of x in array. Elements for which no greater element 
 * exist, consider next greater element as -1. The next greater elements 
 * should be printed in same order as input array.
 * Example 1: 
 * Question: There is an array A[N] of N numbers. You have to compose an array Output[N] such that each element in Output[i] 
 * will tell the next greater element to the right in the original array. If there is no greater number to the right, then 
 * the output array should contain -1 in that position.

Array 1: {4, 6, 5, 4, 3, 4, 9, 8, 1}

Output: {6, 9, 9, 9, 4, 9, -1, -1, -1}

Let us try to understand the problem statement. We are given an input array that has some random numbers. We need to produce
 another output array that contains the ‘Next Greater Element’ for each of the corresponding numbers of the original array.
  If there does not exist a greater element to the right, we simply replace it with ‘-1’.

In the sample input let us try to look at the elements.

Element	Next Greater Element	Reason
4		6						The next element to 4
6		9						The next elements 5, 4, 3, 4 are smaller than 6. 9 is greater
5		9						The next elements 4, 3, 4 are smaller than 5. 9 is greater
4		9						The next elements 3, 4, are smaller/equal to 4. 9 is greater
3		4						The next element greater is 4
4		9						The next element greater is 9
9		-1						The next elements 8, 1 are smaller than 9. Hence -1
8		-1						The next element 1 is smaller than 8. Hence -1
1		-1						There is no element to the right, so no element is greater. Hence -1
We can easily deduce that the last element of the output array will always be ‘-1’ since there will be no element greater than it on the right.
 * </code>
 * @author kmandal
 *
 */
public class ArrayNearestGreatElement {
	/* prints element and NGE pair for all  
	elements of arr[] of size n */
	static void printNGE(int arr[], int n)  
	{  
	    Stack<Integer> s = new Stack<Integer>();  
	  
	    int displayArray[] = new int[n];  
	  
	    // iterating from n-1 to 0  
	    for (int i = n - 1; i >= 0; i--)  
	    {  /*We will pop till we get the  
	        greater element on top or stack gets empty*/
	    	//s.peek() -->Looks at the object at the top of this stack without removing it from the stack.
	        while (!s.isEmpty() && s.peek() < arr[i])  
	            s.pop();  
	  
	        /*if stack gots empty means there  
	        is no element on right which is greater  
	        than the current element.  
	        if not empty then the next greater  
	        element is on top of stack*/
	        if (s.empty())  
	            displayArray[i] = -1;          
	        else
	            displayArray[i] = s.peek();          
	  
	        s.push(arr[i]);  
	    }  
	  
	    for (int i = 0; i < n; i++)  
	        System.out.println(arr[i] + " ---> " + displayArray[i]);
	    
	}  
	  
	/* Driver program to test above functions */
	public static void main(String[] args)  
	{  
	    int arr[] = { 11,9, 13, 21, 3 };  
	    int n = arr.length;  
	    printNGE(arr, n);  
	    System.out.println();
	     int arr1[] = { 4,6,5,4,3,9,4,8,1 };
	      n = arr1.length;
	      printNGE(arr1, n);
	} 

}
