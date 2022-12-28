package com.kartik.org;

import java.util.Stack;

public class ArrayNearestSmallestElement {
	/* prints element and NGE pair for all  
	elements of arr[] of size n */
	static void printNSE(int arr[], int n)  
	{  
	    Stack<Integer> s = new Stack<Integer>();  
	  
	    int displayArray[] = new int[n];  
	  
	    // iterating from n-1 to 0  
	    for (int i = n - 1; i >= 0; i--)  
	    {  /*We will pop till we get the  
	        greater element on top or stack gets empty*/
	        while (!s.isEmpty() && s.peek() > arr[i])  
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
	    printNSE(arr, n);  
	    System.out.println();
	     int arr1[] = { 4,6,5,4,3,9,4,8,1 };
	      n = arr1.length;
	      printNSE(arr1, n);
	} 
}
